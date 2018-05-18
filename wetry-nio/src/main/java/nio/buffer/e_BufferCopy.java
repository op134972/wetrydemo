package nio.buffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * Created by wch on 18-5-18.
 *
 * 缓冲区的复制
 */
public class e_BufferCopy {

    public static void main(String[] args) {
        CharBuffer cb1 = CharBuffer.allocate(10);
        CharBuffer cb1_d = cb1.duplicate();
        CharBuffer cb1_s = cb1.slice();

        System.out.println(cb1.hasArray());
        System.out.println(cb1_d.hasArray());
        System.out.println(cb1_s.hasArray());
        /**
         * duplicate
         * 1、共享数据、拥有同样的容量
         * 2、各自的位置、上界、标记
         */
        ByteBuffer bb1 = ByteBuffer.allocate(100);
        System.out.println(bb1.toString());
        bb1.position(5).limit(10).mark().position(8);
        ByteBuffer bb1_d = bb1.duplicate();

        System.out.println(bb1.toString());
        System.out.println(bb1_d.toString());

        bb1.clear();
        System.out.println(bb1.toString());
        System.out.println(bb1_d.toString());

        System.out.println("================================");

        /**
         * asReadOnlyBuffer
         * 只读的缓冲区，put 会抛异常
         */
        ByteBuffer bb2 = ByteBuffer.allocate(100);
        ByteBuffer bb2_readOl = bb2.asReadOnlyBuffer();
        System.out.println(bb2_readOl.isReadOnly());
//        bb2_readOl.put((byte) 1);

        /**
         * slice
         * 切片 ，剩余的 position-limit的区域。
         */
        ByteBuffer bb3 = ByteBuffer.allocate(100);
        bb3.position(3).limit(20);
        while (bb3.hasRemaining()) {
            System.out.print(bb3.get());
        }
        System.out.println();
        bb3.position(5);
        System.out.println(bb3.toString());
        ByteBuffer bb3_slice = bb3.slice();
        System.out.println(bb3_slice.toString());

        System.out.println("================================");

    }
}
