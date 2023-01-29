package com.example.jmshw.HELLO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class EmergencyUnit {

    @Autowired
    private JmsTemplate jmsTemplate;

    public EmergencyUnit(JmsTemplate jmsTemplate) {this.jmsTemplate = jmsTemplate;}

    public void Message1 (String name, String condition){
        jmsTemplate.convertAndSend("jms/NewPatientTopic",
                new Patient(name, condition),
                message -> {
                    message.setJMSCorrelationID("15");
                    return message;
                });
    }
}
