package JMS;

import fileWork.FileWorker;
import jakarta.jms.*;
import jakarta.ejb.*;

import java.io.IOException;


@MessageDriven(activationConfig = {
        @ActivationConfigProperty(
                propertyName = "destinationType",
                propertyValue = "jakarta.jms.Queue"),
        @ActivationConfigProperty(
                propertyName = "destination",
                propertyValue = "MyQueueName")
}
)
public class JmsConsumer implements MessageListener {

    public void onMessage(Message message) {
        try {
            String text = ((TextMessage) message).getText();
            FileWorker.sortAndWriteFile(text);
            } catch (JMSException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}