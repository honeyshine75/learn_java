import java.io.BufferedReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.io.*;

public class UDPSendDemo2 {
    public static void main(String[] args) throws IOException{
        System.out.println("���Ͷ���������������");
        /**
         * ����UDP����ķ��Ͷ�
         * ˼·��
         * 1�� ����udp��socket����
         * 2�� ��Ҫ���͵����ݷ�װ�����ݰ���
         * 3�� ͨ��udp��socket�������ݰ����ͳ�ȥ
         * 4�� �ر�socket����
         */
        //1. udp socket����ʹ��DatagramSoceket����
        DatagramSocket ds = new DatagramSocket();

        //2. ��Ҫ���͵����ݷ�װ�����ݰ���
        //String str = "UDP������ʾ��������";
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        String line = null;

        while((line = bufr.readLine()) != null){
            byte[] buf = line.getBytes();
            DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"), 10000);
            ds.send(dp);
            if("886".equals(line))
                break;
        }

        //4. �ر�

        ds.close();
    }
}