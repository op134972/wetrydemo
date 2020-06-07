package atgg.channel;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: tangwenchuan
 * @Date: 2020-05-29 23:00
 *
 * 文件读取
 */
public class NIOFileChannel02 {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/data/nio/file01.txt");

        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //读入到buffer
        channel.read(byteBuffer);


        //反转
        byteBuffer.flip();

        //打印，定长
        System.out.println(new String(byteBuffer.array(),0,byteBuffer.limit(), "utf-8"));

        //关闭流
        fileInputStream.close();
    }
}
