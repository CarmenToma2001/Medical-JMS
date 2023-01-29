package com.example.jmshw.HELLO;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.jms.support.JmsHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import java.util.ArrayList;
import java.util.List;

@Component
public class PatientRegistry {
    private final JmsTemplate jmsTemplate;
    private List<Info> Info;

    public PatientRegistry(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
        this.Info = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.add("Concussion");
        temp.add("Amnesia");
        temp.add("Amnesia");
        this.Info.add(new Info("Cristina", temp));
    }

    @JmsListener(destination = "jms/InquireQueue", containerFactory = "myFactory")
    public void receiveMessage2(String information, @Header(JmsHeaders.CORRELATION_ID) String messageId) {
        System.out.println("Received <" + information.split(" ")[0] + ">, message id " + messageId);
        jmsTemplate.convertAndSend("jms/ResponseQueue", this.Info.get(0), message -> {
            message.setJMSCorrelationID(messageId);
            return message;
        });
    }
}
