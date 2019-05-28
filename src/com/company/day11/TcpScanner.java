import java.io.IOException;
import java.net.Socket;
 
public class TcpScanner {
 
    public static final int MIN_PORT_NUMBER = 1;
    public static final int MAX_PORT_NUMBER = 65536;
     
    public static boolean scan(String host, int port, int timeOut) {
        boolean flag = false;
        Socket socket = null;
        try {
            socket = new Socket(host,port);
            socket.setSoTimeout(timeOut);
            flag = true;
        } catch (IOException e) {
            // e.printStackTrace();
        } finally{
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (Exception e) {
            }
        }
        return flag;
    }
     
    /**
     * @param args
     */
    public static void main(String[] args) {
        String host = "127.0.0.1";
        for (int i = 1; i <= 65535; i++) {
            if (scan(host, i, 5000)) {
                System.out.println("PORT listening:" + i);
            }else{
                System.out.println(i);
            }
        }
    }
}