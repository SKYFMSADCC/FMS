package com.adcc.skyfml.core;

import org.apache.log4j.Logger;

public class MsgFilter implements IFilter {
    private Logger logger = Logger.getLogger(MsgFilter.class);

    public boolean isFilter(String aContent) {
        logger.info("[报文过滤] 开始进行报文过滤...");
        System.out.println("[报文过滤] 开始进行报文过滤...");
        if(aContent.contains("REQ"))
            return true;
        else
            return false;
	}
}