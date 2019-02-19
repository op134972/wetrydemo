package producer;


import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * Created by wch on 18-8-23.
 * 2:可靠异步 回调
 */
public class Producer2 {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer();
        try {
            producer.start();
            for (int i = 0; i < 100; i++) {
                Message msg = new Message("TopicTest", "TagTest", ("hello mq" + i).getBytes());
                //不会阻塞
                producer.send(msg, new SendCallback() {
                    @Override
                    public void onSuccess(SendResult sendResult) {
                        System.out.println("success" + sendResult);
                    }
                    @Override
                    public void onException(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
            }
        } finally {
            producer.shutdown();
        }
    }
}
