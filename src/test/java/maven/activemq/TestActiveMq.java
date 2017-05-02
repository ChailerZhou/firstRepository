package maven.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import maven.charlie.step1.bean.User;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class TestActiveMq {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("activeMq-SpringContext.xml");
        // 先发送消息
        JmsTemplate qss = (JmsTemplate) context.getBean("jmsQueueTemplate");
        final User user = new User();
        user.setName("Dingdang");
        user.setAge(23);
        user.setSex("F");
        user.setId("UI983");

        qss.send("HelloWorld", new MessageCreator() {

            public Message createMessage(Session arg0) throws JMSException {
                return arg0.createObjectMessage(user);
            }
        });



    }

}
