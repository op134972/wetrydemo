package nio.b.channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Scanner;

/**
 * Created by wch on 18-5-19.
 */
public class b_ChannelCopy {

    public static void main(String[] args) throws IOException {
        ReadableByteChannel srcChannel = Channels.newChannel(System.in);
        WritableByteChannel descChannel = Channels.newChannel(System.out);

        channelCopy(srcChannel, descChannel);

        Scanner scanner = new Scanner(System.in);
        scanner.next();

        descChannel.close();
        srcChannel.close();
    }


    /**
     * 阻塞的
     * @param srcChannel
     * @param descChannel
     * @throws IOException
     */
    private static void channelCopy(ReadableByteChannel srcChannel, WritableByteChannel descChannel) throws IOException {

        ByteBuffer byteBuffer = ByteBuffer.allocate(16 * 1024);

        while (srcChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            descChannel.write(byteBuffer);
            byteBuffer.compact();//压缩 将剩余的字节position 置位 0
            System.out.println("=================");
        }
    }
}
