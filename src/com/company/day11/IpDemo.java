import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpDemo {
    public static void main(String[] args) throws UnknownHostException{
        //��ȡ����ip��ַ
        InetAddress ip = InetAddress.getLocalHost();
        //��ȡ����������ip��ַ����
        ip = InetAddress.getByName("8.8.8.8");
        System.out.println(ip.getHostAddress());
        System.out.println(ip.getHostName());
    }
}