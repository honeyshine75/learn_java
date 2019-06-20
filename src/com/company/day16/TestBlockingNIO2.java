package com.company.day16;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author zxd
 * @date 2019/5/31 15:13
 */
public class TestBlockingNIO2 {

    //客户端
    @Test
    public void client() throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        FileChannel inChannel = FileChannel.open(Paths.get("E:\\git-repository\\github\\learn_java\\src\\com\\company\\day15\\1.png"), StandardOpenOption.READ);

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (inChannel.read(buffer) != -1){
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }
        socketChannel.shutdownOutput();

        //接受服务端反馈
        int len = 0;
        while ((len = socketChannel.read(buffer)) != -1){
            buffer.flip();
            System.out.println(new String(buffer.array(), 0, len));
            buffer.clear();
        }

        inChannel.close();
        socketChannel.close();
    }

    //服务端
    @Test
    public void server() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        FileChannel outChannel = null;
        try {
            outChannel = FileChannel.open(Paths.get("E:\\git-repository\\github\\learn_java\\src\\com\\company\\day16\\2.png"), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        serverSocketChannel.bind(new InetSocketAddress(9898));

        SocketChannel socketChannel = serverSocketChannel.accept();

        ByteBuffer buffer =  ByteBuffer.allocate(1024);
        while (socketChannel.read(buffer) != -1){
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }

        //发送反馈给客户端
        buffer.put("服务端接受数据成功".getBytes());
        buffer.flip();
        socketChannel.write(buffer);

        socketChannel.close();
        serverSocketChannel.close();
        outChannel.close();
    }
}
