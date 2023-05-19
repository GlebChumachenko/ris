package JMS;

import jakarta.ejb.Stateless;
import jakarta.jms.*;
import jakarta.annotation.Resource;

@Stateless
public class JmsProducer {

    @Resource
    private ConnectionFactory connectionFactory;

    @Resource(name = "MyQueueName")
    private Queue queue;

    public void produceMessage(String messageString) throws Exception {

        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession();

        MessageProducer producer = session.createProducer(queue);

        TextMessage message = session.createTextMessage(messageString);
        producer.send(message);

        session.close();
        connection.close();
    }
}