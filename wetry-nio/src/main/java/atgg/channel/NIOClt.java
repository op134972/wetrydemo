package atgg.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @Author: tangwenchuan
 * @Date: 2020-05-30 19:38
 */
public class NIOClt {

    public static void main(String[] args) throws IOException {
        SocketChannel skCnl = SocketChannel.open();

        skCnl.configureBlocking(false);

        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 9999);

        if (!skCnl.connect(inetSocketAddress)) {
            while (!skCnl.finishConnect()) {
                System.out.println("连接中...");
            }
        }

        ByteBuffer byteBuffer = ByteBuffer.wrap("hello wch".getBytes());

        skCnl.write(byteBuffer);


        int read = System.in.read();
    }
}
