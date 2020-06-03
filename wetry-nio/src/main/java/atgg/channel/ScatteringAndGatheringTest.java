package atgg.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Author: tangwenchuan
 * @Date: 2020-05-30 15:53
 */
public class ScatteringAndGatheringTest {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(9999));

        SocketChannel socketChannel = serverSocketChannel.accept();

        int maxSize= 8;

        ByteBuffer[] bbs = new ByteBuffer[2];
        bbs[0] = ByteBuffer.allocate(5);
        bbs[1] = ByteBuffer.allocate(3);

        int readed = 0;
        while (true) {
            long read = socketChannel.read(bbs);
            readed += read;
//            socketChannel.read();
        }

    }
}
