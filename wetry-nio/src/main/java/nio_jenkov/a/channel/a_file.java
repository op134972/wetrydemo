package nio_jenkov.a.channel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by wch on 18-11-9.
 *
 * FileChannel read
 */
public class a_file {
    public static void readFile() throws FileNotFoundException {
        RandomAccessFile rac = null;
        try {
            File file = new File("");
            rac = new RandomAccessFile("/data/nio/file_read.txt", "rw");
            FileChannel fileChannel = rac.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
            //读到buffer中
            int read = fileChannel.read(byteBuffer);
            while (read != -1) {
                System.out.println("Read:" + read);
                // 基本操作 flip 翻转
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    System.out.print((char)byteBuffer.get());
                }
                byteBuffer.clear();
                read = fileChannel.read(byteBuffer);
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                rac.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile();
    }
}
