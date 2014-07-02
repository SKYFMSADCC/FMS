package com.adcc.skyfml.mqAccessUtil;

import com.adcc.skyfml.controller.ISender;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;

public class ActivemqSender implements ISender {

    private Logger logger = Logger.getLogger(ActivemqSender.class);
    private JmsTemplate jmsTemplate;
    private ActiveMQQueue destination;

    public void send(final String aContent) {
        logger.info("[ActiveMQ 上行报文] 发送上行报文...");
        System.out.println("[ActiveMQ 上行报文] 发送上行报文...");
        jmsTemplate.send(destination.getPhysicalName(),new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage message = session.createTextMessage(aContent);
                logger.info("[ActiveMQ 上行报文] 发送内容为:"+ message);
                System.out.println("[ActiveMQ 上行报文] 发送内容为:" + message);
                return message;
            }
        });
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void setDestination(ActiveMQQueue destination) {
        this.destination = destination;
    }
}