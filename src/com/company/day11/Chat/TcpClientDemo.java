import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClientDemo {
    public static void main(String[] args) throws UnknownError, IOException{
        //客户端发送数据到服务端
        /**
         * Tcp传输，客户端建立过程
         * 1. 创建Tcp客户端socket服务，使用Socket对象。
         *      建议该对象一创建就明确目的地，要连接的主机
         * 2. 如果连接建立成功，说明数据传输通道已建立
         *      该通道就是socket流，是底层建立好的。既然是流，说明这里
         *      既有输入，也有输出
         *      想要输入或者输出流对象，可以找socket获取。
         *      可以通过getOutputStream(),和getInputStream()来获取两个字节流
         * 3. 使用输出流，将数据写出。
         * 4. 关闭资源
         */
        //创建客户端socket服务
         Socket socket = new Socket("127.0.0.1", 10002);

        //获取socket中的输出流
        OutputStream out = socket.getOutputStream();

        //使用输出流将指定的数据写出去
        out.write("啦啦啦啦啦".getBytes());

        //关闭资源
        socket.close();
    }
}