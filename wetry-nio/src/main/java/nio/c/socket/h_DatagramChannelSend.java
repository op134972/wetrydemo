package nio.c.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;

/**
 * Created by wch on 18-5-24.
 */
public class h_DatagramChannelSend {
    public static void main(String[] args) throws IOException {

        /**
         * 不像ServerChannel面向连接和流，DatagramChannel面向无连接和数据包
         */
        DatagramChannel datagramChannel = DatagramChannel.open();

        DatagramSocket socket = datagramChannel.socket();

        socket.bind(new InetSocketAddress("localhost", 1234));

        byte[] bytes = "hello".getBytes();

        //每个包可以指定一个地址
        socket.send(new DatagramPacket(bytes, bytes.length,new InetSocketAddress("localhost",1234)));

    }
}
