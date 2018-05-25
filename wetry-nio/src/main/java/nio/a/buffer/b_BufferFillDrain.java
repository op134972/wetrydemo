package nio.a.buffer;

import java.nio.CharBuffer;

/**
 * Created by wch on 18-5-17.
 * 填充和释放缓冲区
 */
public class b_BufferFillDrain {

    private static int index = 0;

    private static String[] strings = {"hello","world"};

    public static void main(String[] args) {
        CharBuffer charBuffer = CharBuffer.allocate(100);
        while (fillBuffer(charBuffer)) {
            charBuffer.flip();
            drainBuffer(charBuffer);
            //重复释放 则重复flip或者rewind
            charBuffer.flip();
            drainBuffer(charBuffer);
            charBuffer.flip();
            drainBuffer(charBuffer);

            charBuffer.clear();
        }
    }

    private static boolean fillBuffer(CharBuffer charBuffer){
        if (index >= strings.length) {
            return false;
        }
        String str = strings[index++];

        for (int i = 0; i < str.length(); i++) {
            charBuffer.put(str.charAt(i));
        }
        return true;
    }

    private static void drainBuffer(CharBuffer charBuffer){
        while (charBuffer.hasRemaining()) {
            System.out.print((char)charBuffer.get());
        }
        System.out.println();
    }
}
