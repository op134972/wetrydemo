package reactor2.b单线程reactor;

import java.io.IOException;

/**
 * @Author: tangwenchuan
 * @Date: 2020-05-25 11:30
 */
public class ReactorTest {

    public static void main(String[] args) throws IOException {
        Reactor reactor = new Reactor(9999);
        reactor.run();
    }
}
