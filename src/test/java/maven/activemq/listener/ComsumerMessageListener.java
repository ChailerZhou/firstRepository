package maven.activemq.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ComsumerMessageListener implements MessageListener {

    public void onMessage(Message arg0) {
        TextMessage txtMsg = (TextMessage) arg0;
        System.out.println("接收到一个纯文本消息");
        try {
            System.out.println("消息内容是：" + txtMsg.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
