import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketDemo {

    /*
     * TCP 服务器端
     *
     * 1,创建服务器ServerSocket对象（指定服务器端口号）
     * 2，开启服务器了，等待客户端的连接，当客户端连接后，可以获取到连接服务器的客户端Socket对象
     * 3,给客户端反馈信息
     * 4,关闭流资源
     */
    @Test
    public void TCPServer() throws IOException {
            //1,创建服务器ServerSocket对象（指定服务器端口号）
            ServerSocket ss = new ServerSocket(8888);
            //2，开启服务器了，等待客户端的连接，当客户端连接后，可以获取到连接服务器的客户端Socket对象
            Socket s = ss.accept();
            //3,给客户端反馈信息
            /*
             * a,获取客户端的输出流
             * b,在服务端端，通过客户端的输出流写数据给客户端
             */
            //a,获取客户端的输出流
            OutputStream out = s.getOutputStream();
            //b,在服务端端，通过客户端的输出流写数据给客户端
            out.write("你已经连接上了服务器".getBytes());
            //4,关闭流资源
            out.close();
            s.close();
            //ss.close();  服务器流 通常都是不关闭的
    }

    /*
     * TCP 客户端
     *
     * 1，创建客户端Socket对象,（指定要连接的服务器地址与端口号）
     * 2,获取服务器端的反馈回来的信息
     * 3,关闭流资源
     */
    @Test
    public void TCPClient() throws IOException {
            //1，创建客户端Socket对象,（指定要连接的服务器地址与端口号）
            Socket s = new Socket("127.0.0.1", 8888);
            //2,获取服务器端的反馈回来的信息
            InputStream in = s.getInputStream();
            //获取获取流中的数据
            byte[] buffer = new byte[1024];
            //把流中的数据存储到数组中，并记录读取字节的个数
            int length = in.read(buffer);
            //显示数据
            System.out.println( new String(buffer, 0 , length) );
            //3,关闭流资源
            in.close();
            s.close();
    }

}
