package com.example.jmshw.HELLO;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

//import javax.ejb.ActivationConfigProperty;
//import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

//@MessageDriven(mappedName = "NewPatientTopic", activationConfig = {
//                @ActivationConfigProperty(
//               propertyName = "subscriptionDurability",
//               propertyValue = "Durable")})
@Component
public class FamilyDoctor {
    @JmsListener(destination = "jms/NewPatientTopic", containerFactory = "myFactory")
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                System.out.println("The Doctor was informed"+((TextMessage) message).getText());
            }
            catch (JMSException ex) {
                throw new RuntimeException(ex);
            }
        }
        else {
            throw new IllegalArgumentException("Message must be of type TextMessage");
        }
    }
}

