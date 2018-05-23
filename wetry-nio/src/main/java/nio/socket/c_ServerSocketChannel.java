package nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.ServerSocketChannel;

/**
 * Created by tangwc on 2018/5/24.
 */
public class c_ServerSocketChannel {

    public static void main(String[] args) throws IOException {

        /**
         * ServerSocketChannel API：
         * open
         * socket
         * accept
         * validOps
         *
         *
         * 基于通道的socket监听器，与ServerSocket执行相同的任务，但是非阻塞的
         */

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket socket = serverSocketChannel.socket();

        //listen to 1234 port
        socket.bind(new InetSocketAddress(1234));



    }
}
