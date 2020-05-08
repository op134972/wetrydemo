package reactor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: tangwenchuan
 * @Date: 2019-11-05 17:36
 *
 * 经典的server socket实现
 */
public class A_Server implements Runnable {

    private static final int PORT = 0;
    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(PORT);
            while (!Thread.interrupted()) {
            }
        } catch (IOException e) {

        }
    }

    static class Handler implements Runnable{

        Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                byte[] input = new byte[1024];
                socket.getInputStream().read(input);
                byte[] output = process(input);
                socket.getOutputStream().write(output);
            } catch (IOException e) {

            }
        }

        private byte[] process(byte[] input) {
            return new byte[0];
        }
    }
}
