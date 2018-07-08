package nio.e_pipe;

import java.io.IOException;
import java.nio.channels.Pipe;

/**
 * Created by wch on 18-5-25.
 */
public class a_pipe {
    public static void main(String[] args) throws IOException {
        Pipe pipe = Pipe.open();

        // 读
        Pipe.SourceChannel source = pipe.source();
        // 写
        Pipe.SinkChannel sink = pipe.sink();

    }
}
