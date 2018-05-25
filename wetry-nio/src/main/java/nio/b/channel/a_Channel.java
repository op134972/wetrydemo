package nio.b.channel;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by wch on 18-5-19.
 * FileChannel
 * SocketChannel
 * ServerSocketChannel
 * DatagramChannel
 */
public class a_Channel {
    public static void main(String[] args) throws IOException {
        /**
         * fileChannel
         */
        FileInputStream fis = new FileInputStream("/data/2542.stack");

        FileChannel fileChannel = fis.getChannel();

        ByteBuffer bb = ByteBuffer.allocate(1024*1024);

        fileChannel.read(bb);

        bb.flip();
        while (bb.hasRemaining()) {
            System.out.print((char)bb.get());
        }

        SocketChannel socketChannel = SocketChannel.open();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        DatagramChannel datagramChannel = DatagramChannel.open();

//        RandomAccessFile randomAccessFile = new RandomAccessFile("","");


        /**
         * WritableChannel
         */
    }
}
