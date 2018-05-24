package nio.channel;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created by wch on 18-5-24.
 */
public class f_ChannelVisit {

    public static void main(String[] args) throws IOException {

        int port = 1234;

//        ServerSocketChannel ssc = ServerSocketChannel.open();
//
//        ssc.socket().bind(new InetSocketAddress(port));
//
//        SocketChannel channel = ssc.accept();
//
//        ByteBuffer buffer = ByteBuffer.allocate(1024);
//
//        channel.read(buffer);
//
//        buffer.flip();
//
//        System.out.println(buffer.toString());
//
//        channel.close();
//
//        ssc.close();

        Socket socket = new Socket("localhost", port);

        InputStream inputStream = socket.getInputStream();

        inputStream.read("hello".getBytes());

    }
}
