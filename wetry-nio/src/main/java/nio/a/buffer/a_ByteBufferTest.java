package nio.a.buffer;

import java.nio.ByteBuffer;

/**
 * Created by wch on 18-5-17.
 *
 * mark, position, limit, capacity
 * 初始化：mark=-1, posotion=0, limit==capacity==输入大小
 * flip:limit=position,position=0
 * rewind:position=0
 */
public class a_ByteBufferTest {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        System.out.println("初始化 limit = cap = 1024(传入字节数), position = 0, mark = -1");
        System.out.println(byteBuffer.toString());
        byteBuffer.put((byte) 'H').put((byte) 'e').put((byte) 'l').put((byte) 'l').put((byte) 'o');

        System.out.println("put写入之后，position 变化");
        System.out.println(byteBuffer.toString());
        System.out.println(byteBuffer.get(0));

        System.out.println(new String(byteBuffer.array(), 0, byteBuffer.position()));

        // 翻转：limit = position,potision = 0。翻转成为一个准备读出元素的状态
        System.out.println(byteBuffer.toString()+" flip >>>>>");
        byteBuffer.flip();
        System.out.println(byteBuffer.toString()+" rewind >>>>>");

        //rewind():只设置position = 0，limit不变. 使用 rewind回退，重读已经被翻转的缓冲区中的数据
        byteBuffer.rewind();
        System.out.println(byteBuffer.toString()+" flip >>>>>");


        //再次翻转，Flip，position和LIMIT都为0
        byteBuffer.flip();
        System.out.println(byteBuffer.toString());


        System.out.println("=============================");


        ByteBuffer byteBuffer2 = ByteBuffer.allocate(1024);

        byteBuffer2.put((byte) 'H').put((byte) 'e').put((byte) 'l').put((byte) 'l').put((byte) 'o');

        // 不flip 会读到cap位
        byteBuffer2.flip();
        // 方式1：适合多线程
        for (int i = 0; byteBuffer2.hasRemaining(); i++) {
            System.out.print((char)byteBuffer2.get());
        }

        System.out.println();

        byteBuffer2.flip();
        // 方式2：更高效，上界不会在每次重复时被检查
        int count = byteBuffer2.remaining();
        for (int i = 0; i<count; i++) {
            System.out.print((char)byteBuffer2.get());
        }

        System.out.println();
        System.out.println(byteBuffer2.toString());

        //clear 只是重新定义limit 和position  limit = capacity, position = 0。元素不会被清除
        byteBuffer2.clear();
        System.out.println(byteBuffer2.toString());
        System.out.println(byteBuffer2.get(1));
    }
}
