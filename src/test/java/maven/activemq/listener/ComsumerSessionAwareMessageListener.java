package maven.activemq.listener;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.listener.SessionAwareMessageListener;

public class ComsumerSessionAwareMessageListener implements SessionAwareMessageListener<TextMessage> {

    private Destination destination;

    public void onMessage(TextMessage paramM, Session paramSession) throws JMSException {
        System.out.println("收到一条消息");
        System.out.println("消息内容是：" + paramM.getText());

        MessageProducer producer = paramSession.createProducer(destination);
        TextMessage tMessage = paramSession.createTextMessage("ComsumerSesssionAwareMessageListener..");
        producer.send(tMessage);
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}
