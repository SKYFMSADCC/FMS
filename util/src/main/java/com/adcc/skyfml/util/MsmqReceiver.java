package com.adcc.skyfml.util;

import com.adcc.skyfml.controller.WindController;
import ionic.Msmq.Message;
import ionic.Msmq.MessageQueueException;
import ionic.Msmq.Queue;
import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.util.Observable;
import java.util.Observer;

public class MsmqReceiver extends Observable {
    private Logger logger = Logger.getLogger(MsmqReceiver.class);
    private String fullname;
    private WindController windController;

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public void setWindController(WindController windController) {
        this.windController = windController;
    }

    public void addObserver(Observer observer) {
        super.addObserver(observer);
        logger.info("被观察对象添加观察者");
    }

    public void recive() {
        this.addObserver(windController);
        while (true) {
            try {
                Queue queue = new Queue(fullname);
                Message msg= queue.receive(600000);
                if(msg!=null) {
                    this.setChanged();
                    logger.info("[MQ消息获取] 收到消息内容为: " + msg.getBodyAsString());
                    System.out.println("[MQ消息获取] 收到消息内容为: "
                            + msg.getBodyAsString());
                    this.notifyObservers(msg.getBodyAsString());
                    this.clearChanged();
                }
            } catch (UnsupportedEncodingException ex) {
                logger.error("获取消息内容出错!\n" + ex.getMessage());
                System.out.println("获取消息内容出错: " + ex.toString());
            } catch (MessageQueueException ex1) {
                logger.error("获取回执消息超时!\n" + ex1.getMessage());
                System.out.println("获取回执消息超时: " + ex1.toString());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    logger.error("线程休眠出错!\n" + e.getMessage());
                }
            }
        }
    }
}