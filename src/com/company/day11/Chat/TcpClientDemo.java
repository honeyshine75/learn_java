import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClientDemo {
    public static void main(String[] args) throws UnknownError, IOException{
        //�ͻ��˷������ݵ������
        /**
         * Tcp���䣬�ͻ��˽�������
         * 1. ����Tcp�ͻ���socket����ʹ��Socket����
         *      ����ö���һ��������ȷĿ�ĵأ�Ҫ���ӵ�����
         * 2. ������ӽ����ɹ���˵�����ݴ���ͨ���ѽ���
         *      ��ͨ������socket�����ǵײ㽨���õġ���Ȼ������˵������
         *      �������룬Ҳ�����
         *      ��Ҫ���������������󣬿�����socket��ȡ��
         *      ����ͨ��getOutputStream(),��getInputStream()����ȡ�����ֽ���
         * 3. ʹ���������������д����
         * 4. �ر���Դ
         */
        //�����ͻ���socket����
         Socket socket = new Socket("127.0.0.1", 10002);

        //��ȡsocket�е������
        OutputStream out = socket.getOutputStream();

        //ʹ���������ָ��������д��ȥ
        out.write("����������".getBytes());

        //�ر���Դ
        socket.close();
    }
}