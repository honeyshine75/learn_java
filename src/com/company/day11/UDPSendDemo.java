import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSendDemo {
    public static void main(String[] args) throws IOException{
        System.out.println("发送端启动。。。。。");
        /**
         * 创建UDP传输的发送端
         * 思路：
         * 1： 简历udp的socket服务
         * 2： 将要发送的数据封装到数据包中
         * 3： 通过udp的socket服务将数据包发送出去
         * 4： 关闭socket服务
         */
        //1. udp socket服务，使用DatagramSoceket对象。
        DatagramSocket ds = new DatagramSocket();

        //2. 将要发送的数据封装到数据包中

        String str = "UDP传输演示：啦啦啦";
        //使用DatagramPacket将数据封装
        byte[] buf = str.getBytes();

        DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"), 10000);
        //3. 通过udp的socket服务将数据包发送出去，使用send方法
        ds.send(dp);

        //4. 关闭

        ds.close();
    }
}