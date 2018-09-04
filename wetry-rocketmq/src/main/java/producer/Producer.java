package producer;


import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

/**
 * Created by wch on 18-8-23.
 * 方式1：可靠同步
 */
public class Producer {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("group_name");
        producer.setNamesrvAddr("172.16.27.254:9876");
        try {
            producer.start();
            for (int i = 0; i < 100; i++) {
                // create a message , specify topic,tag and message.
                Message msg = new Message("TopicTest", "TagTest", ("hello rmq" + i).getBytes());
                SendResult sendRes = producer.send(msg);
                System.out.println(sendRes);
            }
        } finally {
            producer.shutdown();
        }
    }
}
