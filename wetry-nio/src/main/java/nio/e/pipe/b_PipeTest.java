package nio.e.pipe;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Random;

/**
 * Created by tangwc on 2018/5/26.
 */
public class b_PipeTest {

    public static void main(String[] args) throws IOException {
        WritableByteChannel out = Channels.newChannel(System.out);

        ReadableByteChannel workerChannel = startWork(10);
        ByteBuffer buffer = ByteBuffer.allocate(100);
        while (workerChannel.read(buffer) > 0) {
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }

    }

    private static ReadableByteChannel startWork(int reps) throws IOException {
        Pipe pipe = Pipe.open();
        Worker work = new Worker(pipe.sink(), reps);
        work.start();
        return pipe.source();
    }

    private static class Worker extends Thread {

        WritableByteChannel channel;
        private int reps;

        Worker(WritableByteChannel channel, int reps) {
            this.channel = channel;
            this.reps = reps;
        }

        public void run() {
            ByteBuffer buffer = ByteBuffer.allocate(100);
            try {
                for (int i = 0; i < this.reps; i++) {
                    doSomeWork(buffer);
                    while (channel.write(buffer) > 0) {
                        channel.write(buffer);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        private String[] works = {
                "hi", "hello", "halo", "yo"
        };


        private Random rand = new Random();
        private void doSomeWork(ByteBuffer buffer) {
            int work = rand.nextInt(works.length);
            buffer.clear();
            buffer.put(works[work].getBytes());
            buffer.put("\r\n".getBytes());
            buffer.flip();
        }

    }

}
