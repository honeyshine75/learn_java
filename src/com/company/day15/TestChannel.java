package com.company.day15;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zxd
 * @date 2019/5/30 17:49
 *
 * 一、通道（Channel）：用于源节点与目标节点的连接。在 Java NIO 中负责缓冲区中数据的传输。Channel本身不存储数据，因此需要配合缓冲区进行传输。
 *
 * 二、通道的一些主要实现类
 * java.nio.channels.Channel 接口：
 *      |--FileChannel
 *      |--SocketChannel
 *      |--ServerSocketChannel
 *      |--DatagramChannel
 *
 * 三、获取通道
 * 1.Java 针对支持通道的类提供了getChannel()方法
 *      本地IO
 *      FileInputStream/FileOutputStream
 *      RandomAccessFile
 *
 *      网络IO
 *      Socket
 *      ServerSocket
 *      DatagramSocket
 *
 * 2.在JDK 1.7 中的NIO.2针对各个通道提供了静态方法open()
 * 3.在JDK 1.7 中的NIO.2的Files 工具类的 newByteChannel()
 */
public class TestChannel {

    //利用通道完成文件的复制
    @Test
    public void test1() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try{
            fileInputStream = new FileInputStream("E:\\git-repository\\github\\learn_java\\src\\com\\company\\day15\\1.png");
            fileOutputStream = new FileOutputStream("E:\\git-repository\\github\\learn_java\\src\\com\\company\\day15\\2.png");

            //1.获取通道
            inChannel = fileInputStream.getChannel();
            outChannel = fileOutputStream.getChannel();

            //2.分配指定大小的缓冲区
            ByteBuffer buf = ByteBuffer.allocate(1024);

            //3.将通道中的数据存入缓冲区
            while (inChannel.read(buf) != -1){
                buf.flip(); //切换成读取模式
                //4.将通道中的数据写入通道
                outChannel.write(buf);
                buf.clear();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(outChannel != null){
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inChannel != null){
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
