package nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by wch on 18-5-24.
 */
public class f_ChannelAccept {

    public static void main(String[] args) throws IOException, InterruptedException {

        final int port = 1234;

        ServerSocketChannel ssc = ServerSocketChannel.open();

        ByteBuffer buffer = ByteBuffer.wrap("Hello".getBytes());

        ssc.socket().bind(new InetSocketAddress(port));
        ssc.configureBlocking(false);
        while (true) {
            System.out.println("Waiting for connections...");
            SocketChannel sc = ssc.accept();
            if (sc == null) {
                Thread.sleep(1000);
            }else{
                System.out.println("Welcome visit from :" + sc.socket().getRemoteSocketAddress());
                buffer.rewind();
                sc.write(buffer);
                sc.close();
            }
        }


    }
}
