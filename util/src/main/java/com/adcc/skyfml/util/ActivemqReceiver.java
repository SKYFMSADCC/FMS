package com.adcc.skyfml.util;

import org.apache.activemq.command.ActiveMQDestination;
import org.apache.log4j.Logger;
import com.adcc.skyfml.controller.WindController;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.UncategorizedJmsException;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.util.Observable;
import java.util.Observer;

public class ActivemqReceiver extends Observable {

    private Logger logger = Logger.getLogger(ActivemqReceiver.class);
    private JmsTemplate jmsTemplate;
    private WindController windController;
    private ActiveMQDestination destination;

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public WindController getWindController() {
        return windController;
    }

    public void setWindController(WindController windController) {
        this.windController = windController;
    }

    public ActiveMQDestination getDestination() {
        return destination;
    }

    public void setDestination(ActiveMQTopic destination) {
        this.destination = destination;
    }

    public void addObserver(Observer observer) {
        super.addObserver(observer);
        logger.info("被观察对象添加观察者");
    }

    public void recive() {
        this.addObserver(windController);
        while (true) {
            try {
                TextMessage txtmsg = (TextMessage) jmsTemplate
                        .receive(destination.getPhysicalName());
                if (null != txtmsg.getText()) {
                    this.setChanged();
                    logger.info("[MQ消息获取] 收到消息内容为: " + txtmsg.getText());
                    System.out.println("[MQ消息获取] 收到消息内容为: "
                            + txtmsg.getText());
                    this.notifyObservers(txtmsg.getText());
                    this.clearChanged();
                } else
                    break;
            } catch (UncategorizedJmsException jmsEx) {
                logger.error("获取MQ消息出错!");
                jmsEx.printStackTrace();
                break;
            } catch (Exception e) {
                logger.error("获取MQ消息出错!");
                e.printStackTrace();
                break;
            }

        }
    }
}