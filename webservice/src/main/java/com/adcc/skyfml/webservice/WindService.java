package com.adcc.skyfml.webservice;

import com.adcc.skyfml.core.Request;
import com.adcc.skyfml.core.Response;
import org.apache.log4j.Logger;

public class WindService {
    private Logger logger = Logger.getLogger(WindService.class);

    public Response getWind(Request aRequest) {
        logger.info("[风温请求] 开始进行风温请求...");
        System.out.println("[风温请求] 风温请求完成...");
		return null;
	}
}