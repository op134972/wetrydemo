package nio.d.rfc.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.DatagramChannel;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangwc on 2018/5/25.
 */
public class a_TimeClient {


    private static final int DEFAULT_TIME_PORT = 9999;
    private static final long DIFF_1900 = 2208988800L;
    protected int port = DEFAULT_TIME_PORT;
    protected List remoteHosts;
    protected DatagramChannel channel;

    public a_TimeClient(String[] args) throws Exception {
        if (args.length == 0) {
            throw new Exception("Usage:[ -p port ] host ...");
        }
        parseArgs(args);
        this.channel = DatagramChannel.open();
    }

    private void parseArgs(String[] args) {
        remoteHosts = new LinkedList();
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            //设置端口
            if (arg.equals("-p")) {
                i++;
                this.port = Integer.parseInt(args[i]);
                continue;
            }

            //设置host
            InetSocketAddress sa = new InetSocketAddress(arg, port);
            // 验证是否有地址
            if (sa.getAddress() == null) {
                System.out.println("Cannot resolve address:" + arg);
                continue;
            }
            remoteHosts.add(sa);
        }
    }

    /**
     * 给所有支持的host发送 查询时间的请求
     */
    protected void sendReqs() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1);
        for (Object remoteHost : remoteHosts) {
            InetSocketAddress sa = (InetSocketAddress) remoteHost;
            System.out.println("Requesting time from:" + sa.getHostName() + ":" + sa.getPort());

            //读取状态
            buffer.clear().flip();
            //客户端发送请求，sa代表不同的服务端地址和端口， 如何接受呢？ 关键方法
            channel.send(buffer, sa);
        }
    }

    /**
     * 接受的关键方法
     * 返回的address对象会带有服务端的返回信息，buffer 也会被填充
     */
    private InetSocketAddress receivePacket(DatagramChannel channel, ByteBuffer buffer) throws IOException {
        buffer.clear();
        return (InetSocketAddress) channel.receive(buffer);
    }

    public void getReplies() throws IOException, InterruptedException {
        ByteBuffer longBuffer = ByteBuffer.allocate(8);
        //大端  英特网好像是大端传输
        longBuffer.order(ByteOrder.BIG_ENDIAN);

        longBuffer.putLong(0, 0);

        longBuffer.position(4);

        // slice什么用法？ 忘了... 回去看
        ByteBuffer buffer = longBuffer.slice();

        int expect = remoteHosts.size();
        int replies = 0;
        System.out.println("");
        System.out.println("Waiting for replies...");
        while (true) {
            InetSocketAddress sa = receivePacket(channel, buffer);
            buffer.flip();
            replies++;
            printTime(longBuffer.getLong(0), sa);
            if (replies == expect) {
                System.out.println("All req done");
                break;
            }
            //还有请求未响应
            System.out.println("Received " + replies + " of " + expect + " replies!");
            Thread.sleep(100);
        }
    }

    private void printTime(long remote1900, InetSocketAddress sa) {
        long local = System.currentTimeMillis() / 1000;
        // remote time as seconds since Jan 1, 1970
        long remote = remote1900 - DIFF_1900;
        Date remoteDate = new Date(remote * 1000);
        Date localDate = new Date(local * 1000);
        long skew = remote - local;
        System.out.println("Reply from "
                + sa.getHostName() + ":" + sa.getPort());
        System.out.println(" there: " + remoteDate);
        System.out.println(" here: " + localDate);
        System.out.print(" skew: ");
        if (skew == 0) {
            System.out.println("none");
        } else if (skew > 0) {
            System.out.println(skew + " seconds ahead");
        } else {
            System.out.println((-skew) + " seconds behind");
        }
    }

    public static void main(String[] args) throws Exception {
        String[] argvs = {"-p", "9999", "localhost"};
        a_TimeClient client = new a_TimeClient(argvs);
        client.sendReqs();
        client.getReplies();
    }


}
