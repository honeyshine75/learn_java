import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSendDemo {
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

        String str = "UDP������ʾ��������";
        //ʹ��DatagramPacket�����ݷ�װ
        byte[] buf = str.getBytes();

        DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"), 10000);
        //3. ͨ��udp��socket�������ݰ����ͳ�ȥ��ʹ��send����
        ds.send(dp);

        //4. �ر�

        ds.close();
    }
}