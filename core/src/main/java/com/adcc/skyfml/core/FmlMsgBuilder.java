package com.adcc.skyfml.core;

import org.apache.log4j.Logger;

public class FmlMsgBuilder {
    private Logger logger = Logger.getLogger(FmlMsgBuilder.class);

    public String build(Response aContent) {
        logger.info("[报文构造] 开始进行上传报文构造...");
        System.out.println("[报文构造] 开始进行上传报文构造...");
        return "this is a upload message";
	}
}