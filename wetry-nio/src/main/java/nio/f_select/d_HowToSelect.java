package nio.f_select;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * Created by tangwc on 2018/5/31.
 */
public class d_HowToSelect {
    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open();
        Selector selector = Selector.open();
        sc.configureBlocking(false);
        SelectionKey sk = sc.register(selector, SelectionKey.OP_READ);


        /**
         * select():  无限阻塞
         * select(timeout):指定阻塞时长
         * selectNow():完全非阻塞
         */
//        selector.select();

        selector.select(5000);

        selector.selectNow();

        //唤醒之前的N次select阻塞，和之后的一次select阻塞
        selector.wakeup();

        selector.select();
//        selector.select();//这次会正常阻塞


        // 取消所有的阻塞， 通道会被取消
        selector.close();




    }

}
