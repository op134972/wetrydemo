package nio.f.selector;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * Created by wch on 18-5-28.
 */
public class a_SelectorTest {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();

        SocketChannel socketChannel = SocketChannel.open();

        socketChannel.configureBlocking(false);
        SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_READ);
        SelectionKey selectionKey2 = socketChannel.register(selector, SelectionKey.OP_WRITE);
        SelectionKey selectionKey3 = socketChannel.register(selector, SelectionKey.OP_CONNECT);

        //socketChannel 不支持accept
//        SelectionKey selectionKey4 = socketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println(selectionKey.interestOps());
        System.out.println(selectionKey2.interestOps());
        System.out.println(selectionKey3.interestOps());

        System.out.println(socketChannel.isRegistered());

        SelectionKey keyFor = socketChannel.keyFor(selector);
        System.out.println(selectionKey.equals(keyFor));
        System.out.println(selectionKey2.equals(keyFor));
        System.out.println(selectionKey3.equals(keyFor));

        System.out.println(selectionKey2.equals(selectionKey3));

        System.out.println("===================================================");



    }
}
