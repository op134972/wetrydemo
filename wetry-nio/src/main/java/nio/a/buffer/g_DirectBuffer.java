package nio.a.buffer;

import java.nio.ByteBuffer;

/**
 * Created by wch on 18-5-18.
 * 直接缓冲区：
 * 依赖于非jvm内存机制 进行i/o的缓冲区  速度更快
 */
public class g_DirectBuffer {
    public static void main(String[] args) {
        ByteBuffer bb1_direct = ByteBuffer.allocateDirect(100);
        ByteBuffer bb1 = ByteBuffer.allocate(100);

        System.out.println(bb1.isDirect());
        System.out.println(bb1_direct.isDirect());
        /**
         * 所有缓冲区都提供了isDirect函数判断是否是直接缓冲区
         */
    }
}
