import org.junit.Test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPDemo {
    @Test
    public void sender() throws Exception {
        //1,创建DatagramSocket对象
        DatagramSocket sendSocket = new DatagramSocket();
        //2，创建DatagramPacket对象，并封装数据
        //public DatagramPacket(byte[] buf, int length, InetAddress address,  int port)
        //构造数据报包，用来将长度为 length 的包发送到指定主机上的指定端口号。
        byte[] buffer = "hello,UDP".getBytes();
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("localhost"), 12306);
        //3，发送数据
        //public void send(DatagramPacket p) 从此套接字发送数据报包
        sendSocket.send(dp);
        //4，释放流资源
        sendSocket.close();
    }

    @Test
    public void receiver() throws Exception {
        //1,创建DatagramSocket对象,并指定端口号
        DatagramSocket receiveSocket = new DatagramSocket(12306);
        //2,创建DatagramPacket对象, 创建一个空的仓库
        byte[] buffer = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buffer, 1024);
        //3,接收数据存储到DatagramPacket对象中
        receiveSocket.receive(dp);
        //4,获取DatagramPacket对象的内容
        //谁发来的数据  getAddress()
        InetAddress ipAddress = dp.getAddress();
        String ip = ipAddress.getHostAddress();//获取到了IP地址
        //发来了什么数据  getData()
        byte[] data = dp.getData();
        //发来了多少数据 getLenth()
        int length = dp.getLength();
        //显示收到的数据
        String dataStr = new String(data, 0, length);
        System.out.println("IP地址：" + ip + "数据是" + dataStr);
        //5,释放流资源
        receiveSocket.close();
    }
}
