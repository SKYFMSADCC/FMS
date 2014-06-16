package com.adcc.skyfml.controller;

import com.adcc.skyfml.core.*;
import com.adcc.skyfml.webservice.WindService;
import org.apache.log4j.Logger;

import java.util.Observable;
import java.util.Observer;

public class WindController implements Observer {

    private Logger logger = Logger.getLogger(WindController.class);
    private IFilter filter;
    private DownRequestWind downRequestWind;
    private WindService windService;
    private FmlMsgBuilder fmlMsgBuilder;
    private ISender sender;
    private String upMessageCache = "";

    public IFilter getFilter() {

        return filter;
    }

    public void setFilter(IFilter filter) {
        this.filter = filter;
    }

    public DownRequestWind getDownRequestWind() {
        return downRequestWind;
    }

    public void setDownRequestWind(DownRequestWind downRequestWind) {
        this.downRequestWind = downRequestWind;
    }

    public WindService getWindService() {
        return windService;
    }

    public void setWindService(WindService windService) {
        this.windService = windService;
    }

    public FmlMsgBuilder getFmlMsgBuilder() {
        return fmlMsgBuilder;
    }

    public void setFmlMsgBuilder(FmlMsgBuilder fmlMsgBuilder) {
        this.fmlMsgBuilder = fmlMsgBuilder;
    }

    public void setSender(ISender sender) {
        this.sender = sender;
    }

    public void update(Observable observable,Object arg) {
        String aContent = (String)arg;
        if(filter.isFilter(aContent) == true) {
            logger.info("报文格式不符合要求，进行过滤处理!");
            return;
        } else {
            String uplinkack = "UPLINKACK";
            String uplink = "UPLINK";

            //判断报文类型是否为回执报，若为回执报，则将回执报中参数与上行报文缓存进行比较，
            //检查是否匹配，匹配则将上行报文缓存置空，不匹配则再发送一次上行报文
            if (aContent.contains(uplinkack)) {
                if(upMessageCache.equals("")) {
                    //如果收到的是回执报，并且缓存上行报文为空，原因是上一次的回执报与缓存上行报
                    //信息不匹配而进行的重发
                } else {
                    //如果收到的是回执报，并且缓存上行报文不为空，则进行回执报与缓存上行报信息匹配
                    //compare(aContent,upMessageCache);
                    //匹配成功则将缓存上行报置为空，匹配不成功则重新发送一次缓存上行报
                }

                sender.send(upMessageCache);
                upMessageCache = "";
            } else if(aContent.contains(uplink)) {
                logger.info("报文格式符合要求，进行解析处理!");
                Request request = downRequestWind.parse(aContent);
                logger.info("报文解析完成，向Webservice服务进行风温请求!");
                Response response = windService.getWind(request);
                logger.info("风温数据请求完成，构造上传报文!");
                String upMsg = fmlMsgBuilder.build(response);
                logger.info("上传报文构造完成：" + upMsg);
                sender.send(upMsg);
                //将上传报文进行缓存，用于未正确接收到回执报文时进行报文重发
                upMessageCache = upMsg;
            }
        }
	}
}