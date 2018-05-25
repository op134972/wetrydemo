package nio.d.rfc.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.DatagramChannel;

/**
 * Created by wch on 18-5-25.
 */
public class b_TimeServer {

    // linux 1000 以下的端口需要权限

    private static final int DEFAULT_TIME_PORT = 9999;
    private static final long DIFF_1900 = 2208988800L;
    protected DatagramChannel channel;

    public b_TimeServer(int port) throws IOException {
        this.channel = DatagramChannel.open();
        this.channel.socket().bind(new InetSocketAddress(port));
        System.out.println("Listening on port " + port + " for time requests");
    }

    public void listen() throws IOException {
        // allocate a buffer
        ByteBuffer longBuffer = ByteBuffer.allocate(8);
        // BIG_ENDIAN
        longBuffer.order(ByteOrder.BIG_ENDIAN);
        longBuffer.putLong(0, 0);
        longBuffer.position(4);
        ByteBuffer buffer = longBuffer.slice();
        while (true) {
            buffer.clear();
            SocketAddress sa = this.channel.receive(buffer);
            if (sa == null) {
                continue;
            }

            System.out.println(" Time req from " + sa);

            buffer.clear();

            longBuffer.putLong(0, System.currentTimeMillis() / 1000 + DIFF_1900);

            this.channel.send(buffer, sa);
        }
    }

    public static void main(String[] args) throws IOException {
        int port = DEFAULT_TIME_PORT;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        b_TimeServer server = new b_TimeServer(port);
        server.listen();
    }

}
