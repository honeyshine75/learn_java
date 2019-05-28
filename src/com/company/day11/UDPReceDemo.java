import java.io.IOError;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceDemo {
    public static void main(String[] args) throws IOException{
        System.out.println("接收端启动。。。。。");
        /**
         * 简历udp接收端的思路
         * 1. 建立 udp socket服务,因为是接受数据，所以要绑定接口号
         * 2. 创建数据包，用于存储接收到的数据，方便用数据包对象的方法解析数据
         * 3. 使用socket服务的receive方法将接受道德数据存储到数据包中
         * 4. 通过数据包中的方法解析数据包中的数据
         * 5. 关闭资源
         */

         //1. 建立udp socket服务
         DatagramSocket ds = new DatagramSocket(10000);

        //2. 创建数据包
        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);

        // 3. 使用接受方法把数据存储到数据包中
        ds.receive(dp); //阻塞

        //4. 通过数据包对象的方法，解析其中的资源，比如 地址 端口 内容。
        String ip = dp.getAddress().getHostAddress();
        int port = dp.getPort();
        String test = new String(dp.getData(), 0, dp.getLength());

        System.out.println(ip + ":" + port + ":" + test);

        //5.关闭资源
        ds.close();
    }
}