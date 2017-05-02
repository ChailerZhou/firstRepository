package maven.activemq.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ResponseQueueListener implements MessageListener {

    public void onMessage(Message arg0) {
        if (arg0 instanceof TextMessage) {
            TextMessage tm = (TextMessage) arg0;
            try {
                System.out.println("接收到发送到responseQueue的一个文本消息，内容是：" + tm.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

}
