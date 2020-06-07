package atgg.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: tangwenchuan
 * @Date: 2020-05-29 23:26
 *
 * 拷贝txt，一个buffer完成
 */
public class NIOFileChannel03 {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/data/nio/file01.txt");
        FileChannel fileChannel01 = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("/data/nio/file02.txt");
        FileChannel fileChannel02 = fileOutputStream.getChannel();


        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        while (true) {

            //档limit == position时，无法读取。需要清除位置状态
            byteBuffer.clear();

            System.out.println(byteBuffer);

            //返回表示读取字节数，-1表示已读完。 0表示没有读取到（limit == position）
            int read = fileChannel01.read(byteBuffer);

            System.out.println("read:" + read);

            //-1读完，退出程序
            if (read == -1) {
                break;
            }

            System.out.println(byteBuffer);

            //反转，由读状态转入写状态
            byteBuffer.flip();

            System.out.println(byteBuffer);
            //写入
            fileChannel02.write(byteBuffer);

            System.out.println(byteBuffer);
        }

        fileOutputStream.close();
        fileInputStream.close();
    }
}
