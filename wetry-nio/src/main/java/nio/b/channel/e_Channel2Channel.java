package nio.b.channel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Created by tangwc on 2018/5/23.
 */
public class e_Channel2Channel {

    public static void main(String[] args) throws IOException {

        FileChannel fc1 = new RandomAccessFile("/data/test/a.txt", "rw").getChannel();

        FileChannel fc2 = new RandomAccessFile("/data/test/b.txt", "rw").getChannel();

        fc1.transferTo(0, fc1.size(), fc2);

        fc1.transferFrom(fc2, 0, fc2.size());

        fc1.force(true);

        fc2.force(true);

        fc2.close();

        fc1.close();

    }
}
