package nio.buffer;

import java.nio.ByteBuffer;

/**
 * Created by wch on 18-5-19.
 * 数据元素视图
 */
public class i_DataBuffer {

    public static void main(String[] args) {
        ByteBuffer bb1 = ByteBuffer.allocate(10);

        bb1.put((byte) 1).put((byte) 1).put((byte) 1).put((byte) 1).put((byte) 1).put((byte) 1).put((byte) 1);

        bb1.rewind();
        System.out.println(bb1.getInt());
    }
}
