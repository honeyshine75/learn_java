package com.company.day16;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author zxd
 * @date 2019/5/31 14:34
 *
 * 一、使用NIO完成网络通信的三个核心：
 *
 * 1.通道（Channel）：负责链接
 *      java.nio.channels.Channel 接口：
 *          |--SelectableChannel
 *              |--SocketChannel
 *              |--ServerSocketChannel
 *              |--DatagramChannel
 *
 *              |--Pipe.SinkChannel
 *              |--Pipe.SourceChannel
 *
 * 2.缓冲区（Buffer）：负责数据的存取
 *
 * 3.选择器（Selector）：是SelectableChannel 的多路复用器。用于监控SelectableChannel 的IO状况
 *
 */
public class TestBlockNIO {

    //客户端
    @Test
    public void client() throws IOException {
        //1.获取通道

        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileChannel inChannel = null;
        try {
            inChannel = FileChannel.open(Paths.get("E:\\git-repository\\github\\learn_java\\src\\com\\company\\day15\\1.png"), StandardOpenOption.READ);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //2.分配指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //3.读取本地图片并发送到服务器
        while (inChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        //4.关闭通道
        inChannel.close();
        socketChannel.close();
    }

    //服务端
    @Test
    public void server() throws IOException {
        //1.获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        FileChannel outChannel = null;
        try {
            outChannel = FileChannel.open(Paths.get("E:\\git-repository\\github\\learn_java\\src\\com\\company\\day16\\2.png"), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2.绑定链接
        serverSocketChannel.bind(new InetSocketAddress(9898));

        //3.获取客户端的通道
        SocketChannel socketChannel = serverSocketChannel.accept();

        //4.分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //5.接收客户端的数据并保存到本地
        while (socketChannel.read(buffer) != -1){
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }

        //6.关闭通道
        socketChannel.close();
        outChannel.close();
        serverSocketChannel.close();
    }
}
