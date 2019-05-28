import java.net.DatagramSocket;
import java.io.IOError;
import java.io.IOException;
import java.net.DatagramPacket;

public class Rece implements Runnable {
    private DatagramSocket ds;
    public Rece(DatagramSocket ds){
        this.ds = ds;
    }
    @Override
    public void run() {
        try{
            while(true){
                byte[] buf = new byte[1024];
                DatagramPacket dp = new DatagramPacket(buf, buf.length);
                ds.receive(dp); //×èÈû
                String ip = dp.getAddress().getHostAddress();
                int port = dp.getPort();
                String test = new String(dp.getData(), 0, dp.getLength());
                System.out.println(ip + ":" + port + ":" + test);
                if(test.equals("886")){
                    System.out.println(ip + ".......ÍË³öÁÄÌìÊÒ");
                }
            }
            //ds.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}