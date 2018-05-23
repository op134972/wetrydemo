package nio.channel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by tangwc on 2018/5/23.
 */
public class e_Channel2Channel {

    public static void main(String[] args) throws IOException {

        FileChannel fileChannel = new RandomAccessFile("", "rw").getChannel();

        FileChannel fileChannel2 = new RandomAccessFile("", "rw").getChannel();

        fileChannel.transferTo(0, fileChannel.size(), fileChannel2);

        fileChannel.transferFrom(fileChannel2, 0, fileChannel2.size());

    }
}
