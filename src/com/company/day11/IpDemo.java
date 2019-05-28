import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpDemo {
    public static void main(String[] args) throws UnknownHostException{
        //获取本地ip地址
        InetAddress ip = InetAddress.getLocalHost();
        //获取其他主机的ip地址对象
        ip = InetAddress.getByName("8.8.8.8");
        System.out.println(ip.getHostAddress());
        System.out.println(ip.getHostName());
    }
}