package nio.f.selector;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * Created by wch on 18-5-28.
 */
public class b_SelectionKey {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();

        socketChannel.configureBlocking(false);

        Selector selector = Selector.open();

        SelectionKey sk1 = socketChannel.register(selector, SelectionKey.OP_READ);
        System.out.println(selector.keys().size());

        sk1.cancel();

        System.out.println(selector.keys().size());
//        selector.select();
        System.out.println(selector.keys().size());

        /**
         * 三种操作的影响：
         * 1、键取消：注册不会立即取消，键会立即失效
         * 2、选择器关闭：所有注册到该选择器的通道会被注销，所有相关的键会被无效化
         * 3、通道关闭：所有相关的键会被取消，选择器无影响(keys减少一个)
         */

        System.out.println("===================================================");


        System.out.println(selector.isOpen());
        /**
         * 如果在key cancel之后，没有select操作，仍然对同一个selector registry，会抛出CancelKeyException的异常
         * ref:http://adapterofcoms.iteye.com/blog/605080    :: tips2
         */
        Selector s2 = Selector.open();
        SelectionKey sk2 = socketChannel.register(s2, SelectionKey.OP_WRITE);
        System.out.println(sk2.interestOps());

        if ((sk2.readyOps() & SelectionKey.OP_READ) != 0) {

        }

        /**
         * 四中状态
         * 实现同上：
         * public final boolean isAcceptable() {
                return (readyOps() & OP_ACCEPT) != 0;
         }
         */
        if (sk2.isAcceptable() ||
                sk2.isReadable() ||
                sk2.isAcceptable() ||
                sk2.isConnectable()) {

        }


        /**
         * 具体如何选择？？？？？？
         */

    }
}
