package nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * Created by wch on 18-5-24.
 */
public class g_SocketChannel {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = null;
        SocketChannel sc = null;
        try {
            socketChannel = SocketChannel.open();

            System.out.println(socketChannel.isConnected());

            boolean localhost = socketChannel.connect(new InetSocketAddress("localhost", 1234));

            System.out.println(socketChannel.isConnected());

            /**
             * 只是结束connet过程，不是中断已连接的channel
             * 1、connect尚未被调用，产生NoConnectionPendingException
             * 2、connect正在进行，返回false，什么都不会发生
             *
             * 总之：
             * 当通道处于中间的连接状态（connection-pending），只可以调用 finishConnect,isConnectPending,isConnected方法
             */
            socketChannel.finishConnect();

            System.out.println(socketChannel.isConnectionPending());

            System.out.println(socketChannel.finishConnect());

            System.out.println(socketChannel.isConnected());

            System.out.println("===================================================");

            InetSocketAddress address = new InetSocketAddress("localhost", 1234);

            sc = SocketChannel.open();

            sc.configureBlocking(false);

            sc.connect(address);

            while (!sc.finishConnect()) {
                System.out.println("connecting...");
            }
            System.out.println(sc.isConnectionPending());
            System.out.println(sc.finishConnect());
            System.out.println(sc.isConnected());
        } finally {
            sc.close();
            socketChannel.close();
        }


    }
}
