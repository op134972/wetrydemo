package reactor2.c多线程reactor;

import java.io.IOException;

/**
 * @Author: tangwenchuan
 * @Date: 2020-05-25 13:45
 */
public class MthreadReactorTest {

    public static void main(String[] args) throws IOException {
        MthreadReactor mthreadReactor = new MthreadReactor(9999);

        mthreadReactor.run();
    }
}
