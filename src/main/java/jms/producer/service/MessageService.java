package jms.producer.service;

import com.google.gson.Gson;
import jms.producer.model.Vendor;
import jms.producer.sender.MessageSender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageService {

    private static Logger logger = LogManager.getLogger(MessageService.class);

    @Autowired
    MessageSender messageSender;

    public void process(Vendor vendor) {
        Gson gson = new Gson();
        String json = gson.toJson(vendor);
        logger.info("Message: " + json);
        messageSender.send(json);
    }
}
