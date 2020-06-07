package atgg.channel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: tangwenchuan
 * @Date: 2020-05-29 22:44
 *
 * 文件写入
 */
public class NIOFileChannel01 {


    public static void main(String[] args) throws IOException {
        String str=  "hello world";

        //创建输出流
        FileOutputStream fileOutputStream = new FileOutputStream("/data/nio/file01.txt");

        //获取channel
        FileChannel fileChannel = fileOutputStream.getChannel();

        //分配buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //写入
        byteBuffer.put(str.getBytes());

        //反转 开始读
        byteBuffer.flip();

        //写入到channel中
        fileChannel.write(byteBuffer);

        //关闭流
        fileOutputStream.close();
    }
}
