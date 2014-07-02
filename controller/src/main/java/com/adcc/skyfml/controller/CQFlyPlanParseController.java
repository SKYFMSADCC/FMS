package com.adcc.skyfml.controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.adcc.skyfml.service.JetplanParseRuleVO;
import com.adcc.skyfml.util.ObjectUtil;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 
 * <P>FileName: CQFlyPlanParseController.java
 * @author GuoXY    
 * <P>CreateTime: 2014-06-07
 * <P>Description: 解析飞行计划服务
 * <P>Version: v1.0
 * <P>History: 
 * @param
 */
public class CQFlyPlanParseController implements IFlyPlanParseController
{
	List cptInfoList = new ArrayList();
	List planCptWdList = new ArrayList();
	
	JetplanParseRuleVO paramVO = new JetplanParseRuleVO();

//	OraclDao dao = new OraclDao();
	
	private static Logger debugLogger = Logger.getLogger("forDebug");
	private static Logger errorLogger = Logger.getLogger("forError");
	
	//	public static void main(String[] args) {
	//	}
	
	// 读取配置文件，加载解析Jetplan所需的参数信息
	public CQFlyPlanParseController() {
//		java.io.File fConfig = null;
//		fConfig = new java.io.File("config/JetplanParseRule.xml");
//		
//		final SAXReader reader = new SAXReader();
//		try {
//			final Document paraseRulenDoc = reader.read(fConfig);
//			Element uniqueObject = (Element)paraseRulenDoc.selectSingleNode("/JetplanParseRule/uniqueObject/planId");
// 
//		} catch (final DocumentException e) {
//			// TODO Auto-generated catch block
////			e.printStackTrace();
//			errorLogger.error(e.getMessage());
//		}
	}

	@Override
	public boolean parseDataSource(File fDataSource) {
		// TODO Auto-generated method stub
		String flyPlanStr ="";
		try {
			FileReader fr;
			fr = new FileReader(fDataSource);
	        int i = 0;
	        
			while( ( i = fr.read() )!= -1) {
				flyPlanStr = flyPlanStr +(char)i;
			}
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(flyPlanStr);
		if (ObjectUtil.isBlank(flyPlanStr)) {
			errorLogger.error("航班计划文件内容为空！！");
		} else {
//			flyPlanStr = flyPlanStr.replace("\r\n", "**");
			
			System.out.println(flyPlanStr);
			
			// 按指定KEY找对应VALUE
//			String regex = "[\\s\\S]*?AC TYPE : (.*?) [\\s\\S]*?";
//			Pattern pattern = Pattern.compile(regex);
			
			// 抽取指定部分的字符串，备做二次处理
			String regex = "[\\s\\S]*?(PART I[\\s\\S]*?)PART II[\\s\\S]*?";
			Pattern pattern = Pattern.compile(regex);
			
			
			
			Matcher matcher = pattern.matcher(flyPlanStr);
			if (matcher.matches()) {
				String group = matcher.group(1);
				System.out.println(group);
			}else {
				System.out.println("no matches!!");
			}
		}
		return true;
	}

	@Override
	public void saveToDB() {
		// TODO Auto-generated method stub
        // CPT_INFO 数据入库
//		dao.insertCptInfo(cptInfoList);
        // PLAN_CPT_WD 数据入库
//		dao.insertPlanCptWd(planCptWdList);
		
		System.out.println("数据已入库！");
	}

}