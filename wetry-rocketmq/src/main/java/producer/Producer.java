package producer;


import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * Created by wch on 18-8-23.
 * 方式1：可靠同步
 */
public class Producer {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("group_name");//group_name
        producer.setNamesrvAddr("127.0.0.1:9876");
        try {
            producer.start();
            for (int i = 0; i < 100; i++) {
                // create a message , specify topic,tag and message.
                Message msg = new Message(
                        "TopicTest",//topic
                        "TagTest", //tags
                        ("hello rmq" + i).getBytes()//消息实体
                );
                SendResult sendRes = producer.send(msg);
                System.out.println(sendRes);
            }
        } finally {
            producer.shutdown();
        }
    }
}
