package com.company.day15;

import org.junit.Test;

import javax.swing.text.ChangedCharSetException;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Set;

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
 *
 * 四、通道之间的数据传输
 * transferFrom()
 * transferTo()
 *
 * 五、分散(Scatter)与聚集(Gather)
 * 分散读取(Scattering Reading)：将通道中的数据分散到多个缓冲区中
 * 聚集写入(Gathering Writes)：将多个缓冲区中的数据聚集到通道中\
 *
 * 六、字符集: Charset
 * 编码：字符串 -> 字节数组
 * 解码：字节数组 -> 字符串
 *
 */
public class TestChannel {

    //字符集
    @Test
    public void test6() {
        Charset charset = Charset.forName("GBK");

        //获取编码器和解码器
        CharsetEncoder charsetEncoder = charset.newEncoder();//编码器
        CharsetDecoder charsetDecoder = charset.newDecoder();//解码器

        CharBuffer charBuffer = CharBuffer.allocate(1024);
        charBuffer.put("你好啊，啦啦啦");
        charBuffer.flip();

        //编码
        ByteBuffer byteBuffer = null;
        try {
            byteBuffer = charsetEncoder.encode(charBuffer);
        } catch (CharacterCodingException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 14; i++) {
            System.out.println(byteBuffer.get());
        }

        //解码
        byteBuffer.flip();
        CharBuffer charBuffer1 = null;
        try {
            charBuffer1 = charsetDecoder.decode(byteBuffer);
        } catch (CharacterCodingException e) {
            e.printStackTrace();
        }
        System.out.println(charBuffer1.toString());

        System.out.println("---------------------------------");

        Charset charset1 = Charset.forName("UTF-8");
        byteBuffer.flip();
        CharBuffer charBuffer2 = charset1.decode(byteBuffer);
        System.out.println(charBuffer2.toString());
    }

    @Test
    public void test5(){
        Map<String, Charset> map = Charset.availableCharsets();

        Set<Map.Entry<String, Charset>> set = map.entrySet();

        for (Map.Entry<String, Charset> entry : set){
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    //分散与聚集
    @Test
    public void test4() {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile("E:\\1.mp4", "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //1.获取通道
        FileChannel fileChannel = randomAccessFile.getChannel();

        //2.分配指定大小的缓冲区
        ByteBuffer buffer1 = ByteBuffer.allocate(100);
        ByteBuffer buffer2 = ByteBuffer.allocate(1024);

        //3.分散读取
        ByteBuffer[] buffers = {buffer1, buffer2};
        try {
            fileChannel.read(buffers);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (ByteBuffer byteBuffer : buffers) {
            byteBuffer.flip();
        }
        System.out.println(new String(buffers[0].array(), 0, buffers[0].limit()));
        System.out.println("--------------------------");
        System.out.println(new String(buffers[1].array(), 0, buffers[1].limit()));

        //4.聚集写入
        RandomAccessFile randomAccessFile1 = null;
        try {
            randomAccessFile1 = new RandomAccessFile("E:\\5.mp4", "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileChannel fileChannel1 = randomAccessFile1.getChannel();

        try {
            fileChannel1.read(buffers);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileChannel1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //通道之间的数据传输(直接缓冲区)
    @Test
    public void test3() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("E:/", "1.mp4"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("E:/", "4.mp4"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

//        inChannel.transferTo(0, inChannel.size(), outChannel);
        outChannel.transferFrom(inChannel,0, inChannel.size());

        inChannel.close();
        outChannel.close();
    }

    //2.使用直接缓冲区完成文件的复制(内存映射文件)
    @Test
    public void test2() throws IOException {//689-740
        long start = System.currentTimeMillis();

        FileChannel inChannel = FileChannel.open(Paths.get("E:/", "1.mp4"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("E:/", "3.mp4"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);
        //内存映射文件
        MappedByteBuffer inMapperBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMapperBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0 , inChannel.size());

        //直接对缓冲区进行数据的读写操作
        byte[] dst = new byte[inMapperBuf.limit()];
        inMapperBuf.get(dst);
        outMapperBuf.put(dst);

        inChannel.close();
        outChannel.close();

        long end = System.currentTimeMillis();
        System.out.println("耗费时间为： " + (end - start));
    }

    //利用通道完成文件的复制(非直接缓冲区)
    @Test
    public void test1() { //3486-3327
        long start = System.currentTimeMillis();

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try{
            fileInputStream = new FileInputStream("E:\\1.mp4");
            fileOutputStream = new FileOutputStream("E:\\2.mp4");

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
        long end = System.currentTimeMillis();
        System.out.println("耗费时间为： " + (end - start));
    }
}
