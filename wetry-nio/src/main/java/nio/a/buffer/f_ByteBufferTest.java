package nio.a.buffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created by wch on 18-5-18.
 */
public class f_ByteBufferTest {

    /**
     * 1、allocate
     * 2、wrap
     *
     * 3、duplicate
     * 4、asReadOnlyBUffer
     * 5、slice
     *
     * 6、hasArray
     * 7、array
     * 8、arrayOffset
     *
     * 9、get
     * 10、put
     *
     * ...
     */
    public static void main(String[] args) {
        ByteOrder byteOrder = ByteOrder.nativeOrder();
        System.out.println(byteOrder);

        /**
         * 视图的order在创建之后就确定，不会受源缓冲的改变而改变
         */
        ByteBuffer bb1 = ByteBuffer.allocate(100);
        System.out.println(bb1.order());
        ByteBuffer bb1_d = bb1.duplicate();
        System.out.println(bb1_d.order());
        bb1.order(ByteOrder.LITTLE_ENDIAN);
        System.out.println(bb1.order());
        System.out.println(bb1_d.order());

    }

}
