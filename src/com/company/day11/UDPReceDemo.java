import java.io.IOError;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceDemo {
    public static void main(String[] args) throws IOException{
        System.out.println("���ն���������������");
        /**
         * ����udp���ն˵�˼·
         * 1. ���� udp socket����,��Ϊ�ǽ������ݣ�����Ҫ�󶨽ӿں�
         * 2. �������ݰ������ڴ洢���յ������ݣ����������ݰ�����ķ�����������
         * 3. ʹ��socket�����receive���������ܵ������ݴ洢�����ݰ���
         * 4. ͨ�����ݰ��еķ����������ݰ��е�����
         * 5. �ر���Դ
         */

         //1. ����udp socket����
         DatagramSocket ds = new DatagramSocket(10000);

        //2. �������ݰ�
        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);

        // 3. ʹ�ý��ܷ��������ݴ洢�����ݰ���
        ds.receive(dp); //����

        //4. ͨ�����ݰ�����ķ������������е���Դ������ ��ַ �˿� ���ݡ�
        String ip = dp.getAddress().getHostAddress();
        int port = dp.getPort();
        String test = new String(dp.getData(), 0, dp.getLength());

        System.out.println(ip + ":" + port + ":" + test);

        //5.�ر���Դ
        ds.close();
    }
}