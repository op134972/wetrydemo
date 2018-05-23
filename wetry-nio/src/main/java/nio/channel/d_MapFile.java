package nio.channel;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by tangwc on 2018/5/23.
 */
public class d_MapFile {

    public static void main(String[] args) throws IOException {
        File tempFile = File.createTempFile("mmaptest", null);

        RandomAccessFile file = new RandomAccessFile(tempFile, "rw");

        FileChannel channel = file.getChannel();

        ByteBuffer temp = ByteBuffer.allocate(100);

        temp.put("This is file content".getBytes());

        temp.flip();

        channel.write(temp, 0);

        //... 不搞了 P92页自己看咯

        // 三种mapByteBuffer

        MappedByteBuffer ro = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
        MappedByteBuffer rw = channel.map(FileChannel.MapMode.READ_WRITE, 0, channel.size());
        MappedByteBuffer cow = channel.map(FileChannel.MapMode.PRIVATE, 0, channel.size());

        //

    }

}
