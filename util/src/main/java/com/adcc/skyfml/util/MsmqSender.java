package com.adcc.skyfml.util;

import com.adcc.skyfml.controller.ISender;
import ionic.Msmq.Message;
import ionic.Msmq.MessageQueueException;
import ionic.Msmq.Queue;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;

import java.io.UnsupportedEncodingException;

public class MsmqSender implements ISender {

    private Logger logger = Logger.getLogger(ActivemqSender.class);
    private String fullname;

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void send(final String aContent) {
        logger.info("[MsMQ 上行报文] 发送上行报文...");
        System.out.println("[MsMQ 上行报文] 发送上行报文...");
        try {
            String label="skyfml";
            Queue queue = new Queue(fullname);
            String body= "Hello, World!This is a upload message for msmq.";
            Message msg = null;
            byte[] correlationId = { 0,2,4,6,8,9 };
            try {
                msg = new Message(body, label, correlationId);

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return;
            }
            queue.send(msg);
            logger.info("[MsMQ 上行报文] 发送内容为:"+ msg.getBodyAsString());
            System.out.println("[MsMQ 上行报文] 发送内容为:" + msg.getBodyAsString());
        } catch (UnsupportedEncodingException ex) {
            logger.error("获取消息内容出错!\n" + ex.getMessage());
            System.out.println("获取消息内容出错: " + ex.toString());
        } catch (MessageQueueException ex1) {
            logger.error("Msmq发送消息出错!");
            System.out.println("Msmq发送消息出错: " + ex1);
        }
    }
}