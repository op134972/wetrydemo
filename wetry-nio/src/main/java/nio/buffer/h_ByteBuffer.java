package nio.buffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;

/**
 * Created by wch on 18-5-19.
 * 视图缓冲区
 */
public class h_ByteBuffer {


    public static void main(String[] args) {
        ByteBuffer bb1 = ByteBuffer.allocate(7);

        /**
         * byteBuffer 转为视图缓冲区
         */
        CharBuffer charBuffer = bb1.asCharBuffer();
        bb1.put((byte) 0).put((byte) 'H').put((byte) 0).put((byte) 'i').put((byte)0).put((byte) '!').put((byte) 0).order(ByteOrder.LITTLE_ENDIAN);
        bb1.rewind();
        System.out.println(bb1);
        System.out.println(charBuffer);

        bb1.rewind();
        while (bb1.hasRemaining()) {
            System.out.println(bb1.get());
        }

        charBuffer.rewind();
        while (charBuffer.hasRemaining()) {
            System.out.println(charBuffer.get());
        }

        charBuffer.rewind();
        System.out.println("position:"+charBuffer.position());
        System.out.println("limit:"+charBuffer.limit());
        System.out.println("capacity:"+charBuffer.capacity());
        System.out.println("=====================================");
    }

}
