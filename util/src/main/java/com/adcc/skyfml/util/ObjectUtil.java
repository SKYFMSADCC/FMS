package com.adcc.skyfml.util;


import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <P>FileName: ObjectUtil.java
 * @author GuoXY
 * <P>CreateTime: 2014-04-04
 * <P>Description:
 * <P>Version: v1.0
 * <P>History:
 * <P> 
 */
public class ObjectUtil {

    private ObjectUtil() {

    }

    private static Logger log = Logger.getLogger(ObjectUtil.class);

    public static boolean isBlank(String obj) {
        return (null == obj || "".equals(obj));
    }

    public static boolean isBlank(Integer obj) {
        return (null == obj);
    }

    public static boolean isBlank(Date obj) {
        return (null == obj);
    }

    public static boolean isBlank(BigDecimal obj) {
        return (null == obj);
    }

    public static boolean isBlank(Double obj) {
        return (null == obj);
    }

    public static boolean isBlank(Long obj) {
        return (null == obj);
    }

    public static String addPercent(String searchCondition) {
        if (searchCondition != null) {
            searchCondition = "%" + searchCondition + "%";
        }
        return searchCondition;
    }

    public static String subPercent(String searchCondition) {
        if (searchCondition != null) {
            int beginIndex = searchCondition.indexOf("%") + 1;
            int endIndex = searchCondition.lastIndexOf("%");
            searchCondition = searchCondition.substring(beginIndex, endIndex);
        }
        return searchCondition;
    }

    public static String trimVal(String searchCondition) {
        if (searchCondition != null) {
            searchCondition = searchCondition.trim();
        }
        return searchCondition;
    }

    public static List<?> combineList(List<?> mainList , List<?> addList) {
        List returnlist = new ArrayList();
        
        for (int i = 0; i < mainList.size(); i++) {
            returnlist.add(mainList.get(i));
        }
        for (int j = 0; j < addList.size(); j++) {
            returnlist.add(addList.get(j));
        }
        return returnlist;
    }
    
    public static String strSum(String str1, String str2) {
    	Integer sum = 0;
    	if (str1 != null && str2 != null) {
        	sum = Integer.parseInt(str1) + Integer.parseInt(str2);
        }
        return sum.toString();
    }
}
