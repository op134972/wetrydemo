package listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: tangwenchuan
 * @Date: 2021/6/5 4:00 下午
 */
public class ListenerTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(Caller.class);

    public static void main(String[] args) {
        Notifier notifier = new Notifier() ;

        Caller caller = new Caller() ;
        caller.setNotifier(notifier) ;
        caller.setQuestion("你在哪儿！");
        caller.setCallBackListener(new CallBackListener() {
            @Override
            public void callBackNotify(String msg) {
                LOGGER.info("回复=【{}】" ,msg);
            }
        });

        caller.call();
    }
}
