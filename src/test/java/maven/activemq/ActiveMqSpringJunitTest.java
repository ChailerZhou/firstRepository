package maven.activemq;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import maven.charlie.step1.bean.User;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:activeMq-SpringContext.xml"})
public class ActiveMqSpringJunitTest {
    @Autowired
    private JmsTemplate jmsQueueTemplate;

    @Autowired
    private JmsTemplate jmsTopicTemplate;

    @Autowired
    @Qualifier("sessionAwareQueue")
    private Destination destination;

    @Autowired
    @Qualifier("adapterQueue")
    private Destination adapterDestination;

    @Autowired
    @Qualifier("responseQueue")
    private Destination responseDestination;

    /**
     * 先发送队列消息
     */
    @Test
    @Ignore
    public void sendQueueTest() {
        final User user = new User();
        user.setName("Dingdang");
        user.setAge(23);
        user.setSex("F");
        user.setId("UI983");

        jmsQueueTemplate.send("HelloWorld", new MessageCreator() {
            public Message createMessage(Session arg0) throws JMSException {
                return arg0.createObjectMessage(user);
            }
        });
    }

    /**
     * 先发送订阅消息
     */
    @Test
    @Ignore
    public void sendTopicTest() {
        final User user = new User();
        user.setName("Dingdang");
        user.setAge(23);
        user.setSex("F");
        user.setId("UI983");

        jmsTopicTemplate.send("HelloWorld-Topic", new MessageCreator() {
            public Message createMessage(Session arg0) throws JMSException {
                return arg0.createObjectMessage(user);
            }
        });
    }

    /**
     * 测试SessionAwareListener监听器
     */
    @Test
    @Ignore
    public void sessionAwareListenerTest() {
        jmsQueueTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session arg0) throws JMSException {
                return arg0.createTextMessage("测试SessionAwareMessageListener");
            }
        });

        try {// 这里必须要等待一会，否则第二个监听器还没有执行，线程就线束了
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Ignore
    public void listenerAdapterTest() {
        jmsQueueTemplate.send(adapterDestination, new MessageCreator() {
            public Message createMessage(Session arg0) throws JMSException {
                return arg0.createTextMessage("测试MessageListenerAdatper.");
            }
        });

        try {// 这里必须要等待一会，否则第二个监听器还没有执行，线程就线束了
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void responseListenerTest() {
        jmsQueueTemplate.send(adapterDestination, new MessageCreator() {
            public Message createMessage(Session arg0) throws JMSException {
                TextMessage tm = arg0.createTextMessage("测试MessageListenerAdatper.");
                tm.setJMSReplyTo(responseDestination);
                return tm;
            }
        });

        try {// 这里必须要等待一会，否则第二个监听器还没有执行，线程就线束了
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
