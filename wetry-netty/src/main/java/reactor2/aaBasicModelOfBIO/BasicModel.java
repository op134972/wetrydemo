package reactor2.aaBasicModelOfBIO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: tangwenchuan
 * @Date: 2020-05-25 16:14
 *
 * 对于每一个请求都分发给一个线程，每个线程中都独自处理上面的流程。
 *
 * 特点：一个线程一个连接
 * 优点：快
 * 缺点：费
 *
 */
public class BasicModel implements Runnable {
    @Override
    public void run() {
        try {
            ServerSocket ss =
                    new ServerSocket(9999);
            while (!Thread.interrupted()) {
                new Thread(new Handler(ss.accept())).start();
            }
            //创建新线程来handle
            // or, single-threaded, or a thread pool
        } catch (IOException ex) { /* ... */ }
    }

    static class Handler implements Runnable {
        final Socket socket;
        Handler(Socket s) { socket = s; }
        @Override
        public void run() {
            try {
                byte[] input = new byte[1024];
                socket.getInputStream().read(input);
                byte[] output = process(input);
                socket.getOutputStream().write(output);
            } catch (IOException ex) { /* ... */ }
        }
        private byte[] process(byte[] input) {
            byte[] output=null;
            /* ... */
            return output;
        }
    }
}
