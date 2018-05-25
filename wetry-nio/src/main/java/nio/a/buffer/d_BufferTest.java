package nio.a.buffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Arrays;

/**
 * Created by wch on 18-5-17.
 */
public class d_BufferTest {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        byteBuffer.put((byte) 'h').put((byte) 'e').put((byte) 'l');

        System.out.println(byteBuffer.toString());


        byteBuffer.flip();
        System.out.println((char) byteBuffer.get());
        System.out.println(byteBuffer.toString());
        /**
         *compact():压缩，未释放的放前，position = limit-position
         * 丢弃已经释放的数据，保留未释放的数据，并使缓冲区对重新填充容量做好准备。
         */
        byteBuffer.compact();
        System.out.println(byteBuffer.toString());


        System.out.println("================================");

        /**
         * 标记 mark()
         * reset() 返回前一个标记
         * 初始mark为null，调用reset会抛出异常InvalidMarkException
         *
         * rewind(),clear(),flip() limit(index),position(index)会抛弃标记
         */
        byteBuffer.mark();
        byteBuffer.reset();

        System.out.println("================================");


        /**
         * compareTo
         * equals
         */
        CharBuffer cb1 = CharBuffer.allocate(10);
        CharBuffer cb2 = CharBuffer.allocate(10);

        cb1.put("123");
        cb2.put("122");

        System.out.println(cb1.limit());
        System.out.println(cb1.position());
        System.out.println(cb2.limit());
        System.out.println(cb2.position());

        //position -- limit 区间的字段的逐个比较
        System.out.println(cb1.equals(cb2));

        cb1.flip();
        cb2.flip();
        System.out.println(cb1.equals(cb2));
        System.out.println(cb1.compareTo(cb2));


        /**
         * 批量移动
         */
        System.out.println("===============================");

        CharBuffer cb3 = CharBuffer.allocate(100);


        char[] charArr = new char[10];
        cb3.put("hello");

        cb3.flip();
        // 将 position -- limit 的区间放入到array中
        // offset-length 不能大于position-limit 否则会抛出错误
        // get 要求：length - offset <= remaining <= length
        cb3.get(charArr, 0, cb3.remaining());
        System.out.println(Arrays.toString(charArr));

        //put 和 get 相反
        //put 要求：length<=remaining<=length-offset
        System.out.println(cb3.rewind());
        System.out.println(cb3.remaining());
        cb3.put(charArr, 0, cb3.remaining());
        cb3.rewind();
        System.out.println(cb3.toString());

        System.out.println("================================");
        /**
         * wrap、allocate 缓冲数组
         */
        CharBuffer cb5 = CharBuffer.wrap(charArr);
        cb5.put('1');
        System.out.println(Arrays.toString(charArr));

        System.out.println(cb5.hasArray());
        char[] array = cb5.array();
        System.out.println(Arrays.equals(array, charArr));

        //allocate
        CharBuffer cb6 = CharBuffer.allocate(100);
        System.out.println(cb6.hasArray());
        char[] charArr2 = {'1','2','3','4','5'};
        CharBuffer cb7 = CharBuffer.wrap(charArr2, 1, 2);
        System.out.println(cb7.hasArray());

        //
        System.out.println(cb6.arrayOffset());
        System.out.println(cb7.arrayOffset());

        //也支持String
        String str = "floyd";
        CharBuffer cb8 = CharBuffer.wrap(str, 0, str.length());
        System.out.println("mark:"+cb8.mark());
        System.out.println("position:"+cb8.position());
        System.out.println("limit:"+cb8.limit());
        System.out.println("capacity:"+cb8.capacity());

    }
}
