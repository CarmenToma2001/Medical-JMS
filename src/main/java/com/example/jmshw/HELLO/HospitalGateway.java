package com.example.jmshw.HELLO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.jms.support.JmsHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

//import javax.ejb.ActivationConfigProperty;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.management.j2ee.statistics.MessageDrivenBeanStats;
//import javax.ejb.MessageDriven;

//@MessageDriven(mappedName = "NewPatientTopic")
//@MessageDriven(mappedName = "NewPatientTopic",activationConfig = {
//        @ActivationConfigProperty(
//                propertyName = "destination",
//                propertyValue = "tutorialQueue"),
//        @ActivationConfigProperty(
//                propertyName = "destinationType",
//                propertyValue = "javax.jms.Queue")
//})
@Component
public class HospitalGateway {
    @Autowired
    private JmsTemplate jmsTemplate;

    public HospitalGateway(JmsTemplate jmsTemplate) {this.jmsTemplate = jmsTemplate;}
    @JmsListener(destination = "jms/NewPatientTopic", containerFactory = "myFactory")
    public void receiveMessage1(Patient patient, @Header(JmsHeaders.MESSAGE_ID) String messageId) {
        System.out.println("Received <" + patient + ">, message ID: " + messageId);
        jmsTemplate.convertAndSend("jms/InquireQueue",
                patient.getName() + "jms/ResponseQueue",
                message -> {
                    message.setJMSCorrelationID(messageId);
                    return message;
                });
    }

    @JmsListener(destination = "jms/ResponseQueue", containerFactory = "myFactory")
    public void receiveMessage3(Info info, @Header(JmsHeaders.MESSAGE_ID) String messageId){
        System.out.println("Received message 2:  <" + info + ">, message ID: " + messageId);
    }
}
