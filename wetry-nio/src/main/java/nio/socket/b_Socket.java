package nio.socket;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.DatagramChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by tangwc on 2018/5/23.
 */
public class b_Socket {

    public static void main(String[] args) throws IOException {

        /**
         * 通道:连接IO服务导管并提供与该服务交互的方法
         */

        //创建Socket通道的方法
        // 无效的方式

        Socket socket = new Socket();
        SocketChannel channel = socket.getChannel();
        System.out.println(channel);//null

        System.out.println("===========================================================");

        /**
         * 新socket 特性之一  non-block 非阻塞
         *
         * 创建方式如下：3种
         */
        DatagramChannel datagramChannel = DatagramChannel.open();
        SocketChannel socketChannel = SocketChannel.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        DatagramSocket datagramSocket = datagramChannel.socket();
        Socket socketChannelSocket = socketChannel.socket();
        ServerSocket serverSocket = serverSocketChannel.socket();

        /**
         * 创建非阻塞模式
         */

        System.out.println(datagramChannel.isBlocking());// 默认非阻塞
        datagramChannel.configureBlocking(false);
        System.out.println(datagramChannel.isBlocking());
        // 非阻塞IO和可选择性是紧密相连的

        //返回一个锁 用于同步改变阻塞模式
        Object objLock = datagramChannel.blockingLock();

        synchronized (objLock) {
            // do sth ... 该段代码执行时 阻塞模式不能被破坏，需要同步
        }





    }
}
