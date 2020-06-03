package atgg.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: tangwenchuan
 * @Date: 2020-05-30 18:36
 */
public class NIOSrv {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        Selector selector = Selector.open();

        //绑定地址
        serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1",9999));

        //非阻塞模式
        serverSocketChannel.configureBlocking(false);

        //将此channel 注册到selector上，并关心 连接事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);


        while (true) {

            int select = selector.select();

            System.out.println(select);

            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            System.out.println(selectionKeys.size());

            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isAcceptable()) {
                    //建立客户端连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    //连接阻塞模式为非阻塞
                    socketChannel.configureBlocking(false);
                    //注册并关心 读事件
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }

                if (key.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();

                    ByteBuffer byteBuffer = (ByteBuffer) key.attachment();

                    socketChannel.read(byteBuffer);

                    String msg = new String(byteBuffer.array());

                    System.out.println("from 客户端：" + msg.trim());
                }

                System.out.println(key.toString());

                iterator.remove();
            }
        }
    }
}
