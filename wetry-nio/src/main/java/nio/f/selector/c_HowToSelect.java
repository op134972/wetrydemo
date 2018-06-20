package nio.f.selector;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * Created by wch on 18-5-28.
 */
public class c_HowToSelect {
    public static void main(String[] args) throws IOException {

        /**
         * attach
         * 提供一个obj的句柄，获取相关上下文
         */
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        SelectionKey sk = socketChannel.register(selector, SelectionKey.OP_WRITE);
        Object myObj = new Object();
        sk.attach(myObj);
        Object obj = sk.attachment();
        System.out.println(obj.equals(myObj));

        System.out.println("=========================如何使用select==========================");

        int select = selector.select();
        System.out.println(select);

        Set<SelectionKey> keys = selector.keys();
        System.out.println(keys.size());
        //keys返回的key不能直接修改，否则抛异常
        keys.add(socketChannel.register(selector, SelectionKey.OP_WRITE));
    }
}
