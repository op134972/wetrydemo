package nio.channel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URLConnection;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by wch on 18-5-22.
 */
public class c_MappedByteBuffer {

    public static void main(String[] args) throws IOException {

        RandomAccessFile randomAccessFile = new RandomAccessFile("/data/test/a.txt","rw");

        FileChannel fc = randomAccessFile.getChannel();

        MappedByteBuffer map = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size());

        System.out.println(map.isLoaded());

        map.load();

        System.out.println(map.isLoaded());

        System.out.println(map.get());

        map.put("h".getBytes());

        System.out.println(map.get());

        URLConnection.guessContentTypeFromName("");
    }
}
