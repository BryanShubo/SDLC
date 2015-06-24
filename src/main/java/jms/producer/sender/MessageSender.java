package jms.producer.sender;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

@Component
public class MessageSender {
    
    private static Logger logger = LogManager.getLogger(MessageSender.class);

    @Autowired
    JmsTemplate jmsTemplate;

    public void send(String json) {
        try {
            jmsTemplate.convertAndSend(json);
            logger.info("Message sent successfully ");
        } catch(JmsException e) {

            logger.error("Message: " + json);
        }

    }
}
