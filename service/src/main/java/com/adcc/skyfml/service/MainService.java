package com.adcc.skyfml.service;

import com.adcc.skyfml.mqAccessUtil.ActivemqReceiver;
import com.adcc.skyfml.mqAccessUtil.MsmqReceiver;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class MainService {

    private Logger logger = Logger.getLogger(MainService.class);
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        MainService service = new MainService();
        service.start();
    }

	public void start() {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        final ActivemqReceiver receiver = (ActivemqReceiver)applicationContext.getBean("messageReceiver");
        final MsmqReceiver msmqReceiver = (MsmqReceiver)applicationContext.getBean("messageMsmqReceiver");

        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    receiver.recive();
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    msmqReceiver.recive();
                }
            }).start();
            logger.info("消息接收服务启动...");
        } catch (Exception e) {
            logger.warn("消息接收服务停止!" + e.getMessage());
        }
	}

	public void stop() {
        System.exit(0);
    }
}