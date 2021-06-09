package listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Caller {

    private final static Logger LOGGER = LoggerFactory.getLogger(Caller.class);

    private CallBackListener callBackListener ;

    private Notifier notifier ;

    private String question ;

    /**
     * 使用
     */
    public void call(){

        LOGGER.info("开始提问");

        //新建线程，达到异步效果 
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    notifier.execute(Caller.this,question);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        LOGGER.info("提问完毕，我去干其他事了");
    }

    //隐藏 getter/setter


    public CallBackListener getCallBackListener() {
        return callBackListener;
    }

    public Caller setCallBackListener(CallBackListener callBackListener) {
        this.callBackListener = callBackListener;
        return this;
    }

    public Notifier getNotifier() {
        return notifier;
    }

    public Caller setNotifier(Notifier notifier) {
        this.notifier = notifier;
        return this;
    }

    public String getQuestion() {
        return question;
    }

    public Caller setQuestion(String question) {
        this.question = question;
        return this;
    }
}