import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadImag {

    /**
     * 文件上传  服务器端
     *
     * @throws Exception
     */
    @Test
    public void server() throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket clientSocket = serverSocket.accept();
        InetAddress address = clientSocket.getInetAddress();
        String hostAddress = address.getHostAddress();
        System.out.println("客户端" + hostAddress + "已连接");

        InputStream in = clientSocket.getInputStream();
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("C:\\Users\\skdwa\\Desktop\\a.jpg"));
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = in.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }

        OutputStream out = clientSocket.getOutputStream();
        out.write("图片上传成功".getBytes());

        out.close();
        outputStream.close();
        in.close();
        clientSocket.close();

    }

    /*
     * 文件上传 客户端
     *
     * public void shutdownOutput()  禁用此Socket的输出流,间接的相当于告知了服务器数据写入完毕
     */
    @Test
    public void client() throws Exception {

        //2,创建客户端Socket，连接服务器
        Socket socket = new Socket("127.0.0.1", 8888);
        //3,获取Socket流中的输出流，功能：用来把数据写到服务器
        OutputStream out = socket.getOutputStream();
        //4,创建字节输入流，功能：用来读取数据源(图片)的字节
        BufferedInputStream fileIn = new BufferedInputStream(new FileInputStream("C:\\Users\\skdwa\\Pictures\\Saved Pictures\\1436754726998.jpg"));
        //5,把图片数据写到Socket的输出流中(把数据传给服务器)
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = fileIn.read(buffer)) != -1) {
            //把数据写到Socket的输出流中
            out.write(buffer, 0, len);
        }
        //6,客户端发送数据完毕，结束Socket输出流的写入操作，告知服务器端
        socket.shutdownOutput();

        //-----------------反馈信息---------------------
        //12,获取Socket的输入流  作用： 读反馈信息
        InputStream in = socket.getInputStream();
        //13,读反馈信息
        byte[] info = new byte[1024];
        //把反馈信息存储到info数组中，并记录字节个数
        int length = in.read(info);
        //显示反馈结果
        System.out.println(new String(info, 0, length));

        //关闭流
        in.close();
        fileIn.close();
        out.close();
        socket.close();
    }

    /*
     * 文件上传多线程版本, 服务器端
     *
     * 服务器处理多线程问题
     *
     * 			1.因为服务器是要很多人访问的，因此里面一定要用多线程来处理，不然只能一个人一个人的访问，那还叫Y啥服务器
     *
     * 			2，拿上面这个文件上传的例子来说，它将每个连接它的用户封装到线程里面去，把用户要执行的操作定义到 run 方法里面
     * 				一个用户拿一个线程，拿到线程的就自己去执行，如果有其它用户来的时候，再给新来的用户分配一个新的线程
     * 				这样就完成了服务器处理多线程的问题
     * 			3. 在服务器与客户端互传数据时，我们要特别注意的是，防止两个程序造成 死等的状态，一般原因有以下：
     *
     * 					1.  客户端向数据端发送数据时，当发送的是字符时，第次以一行来发送，而服务端在读取的时候，也是以
     * 						 一行来读取，readLine() 而发送的时候往往只是发送换行以行的内容，而不能发换行也发送过去，
     * 						那么服务端在读取的时候就不读取不到换行 ，那么 readLine() 就不会停止
     * 					2. 客户端发送数据时,如果处理的是用  字符流	 或是缓冲流的话，一定要记得刷新流，不然的话，数据就会发不出来
     * 					3 	在用IO 读取文件里面的数据然后发送到服务端 时，当家读取文件 while(in.read()) 读取文件结束时，而在
     * 						服务端的接收程序  while(sin.read())不会接到一个发送完毕的提示，所以会一直等待下去，所以我们在处理这
     * 						个问题的时候，还要将其发送一个文件读取结束的标志，告诉接收端文件已经读取完结，不要再等待了
     * 						而socket 里面给我们封装了 shutdownInput shutdownOutput 两个操作，此可以关闭 流，两样也可以起到告诉
     * 						接收方文件传送完毕的效果
     *
     */
    public void multiThreadServer() throws Exception {
        //1,创建服务器，等待客户端连接
        ServerSocket serverSocket = new ServerSocket(8888);

        //实现多个客户端连接服务器的操作
        while (true) {
            final Socket clientSocket = serverSocket.accept();
            //启动线程，完成与当前客户端的数据交互过程
            new Thread() {
                public void run() {
                    try {
                        //显示哪个客户端Socket连接上了服务器
                        InetAddress ipObject = clientSocket.getInetAddress();//得到IP地址对象
                        String ip = ipObject.getHostAddress(); //得到IP地址字符串
                        System.out.println("小样，抓到你了，连接我！！" + "IP:" + ip);

                        //7,获取Socket的输入流
                        InputStream in = clientSocket.getInputStream();
                        //8,创建目的地的字节输出流   D:\\upload\\192.168.74.58(1).jpg
                        BufferedOutputStream fileOut = new BufferedOutputStream(new FileOutputStream("D:\\upload\\" + ip + "(" + System.currentTimeMillis() + ").jpg"));
                        //9,把Socket输入流中的数据，写入目的地的字节输出流中
                        byte[] buffer = new byte[1024];
                        int len = -1;
                        while ((len = in.read(buffer)) != -1) {
                            //写入目的地的字节输出流中
                            fileOut.write(buffer, 0, len);
                        }

                        //-----------------反馈信息---------------------
                        //10,获取Socket的输出流, 作用：写反馈信息给客户端
                        OutputStream out = clientSocket.getOutputStream();
                        //11,写反馈信息给客户端
                        out.write("图片上传成功".getBytes());

                        out.close();
                        fileOut.close();
                        in.close();
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                };
            }.start();
        }

        //serverSocket.close();
    }

}
