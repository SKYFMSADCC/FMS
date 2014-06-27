package com.adcc.skyfml.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 *
 * <P>FileName: ParseFlightPlanService.java
 * @author GuoXY
 * <P>CreateTime: 2014-06-07
 * <P>Description: 解析飞行计划服务
 * <P>Version: v1.0
 * <P>History:
 */
public class JetplanParseController implements IWindTempController
{X
    List cptInfoList = new ArrayList();
    List planCptWdList = new ArrayList();

    JetplanParseRuleVO paramVO = new JetplanParseRuleVO();

    OraclDao dao = new OraclDao();

    private static Logger debugLogger = Logger.getLogger("forDebug");
    private static Logger errorLogger = Logger.getLogger("forError");

//	public static void main(String[] args) {
//	}

    // 读取配置文件，加载解析Jetplan所需的参数信息
    public JetplanParseController() {
        java.io.File fConfig = null;
        fConfig = new java.io.File("config/JetplanParseRule.xml");

        final SAXReader reader = new SAXReader();
        try {
            final Document paraseRulenDoc = reader.read(fConfig);
            Element uniqueObject = (Element)paraseRulenDoc.selectSingleNode("/JetplanParseRule/uniqueObject/planId");
            paramVO.setPlanIdAttribute(uniqueObject.attributeValue("attributeName"));
            paramVO.setPlanIdPath(uniqueObject.getTextTrim());
            uniqueObject = (Element)paraseRulenDoc.selectSingleNode("/JetplanParseRule/uniqueObject/planDate");
            paramVO.setPlanDateAttribute(uniqueObject.attributeValue("attributeName"));
            paramVO.setPlanDatePath(uniqueObject.getTextTrim());

            uniqueObject = (Element)paraseRulenDoc.selectSingleNode("/JetplanParseRule/uniqueObject/flightId");
            paramVO.setFlightIdAttribute(uniqueObject.attributeValue("attributeName"));
            paramVO.setFlightIdPath(uniqueObject.getTextTrim());
            uniqueObject = (Element)paraseRulenDoc.selectSingleNode("/JetplanParseRule/uniqueObject/aircraftId");
            paramVO.setAircraftIdAttribute(uniqueObject.attributeValue("attributeName"));
            paramVO.setAircraftIdPath(uniqueObject.getTextTrim());
            uniqueObject = (Element)paraseRulenDoc.selectSingleNode("/JetplanParseRule/uniqueObject/dep");
            paramVO.setDepAttribute(uniqueObject.attributeValue("attributeName"));
            paramVO.setDepPath(uniqueObject.getTextTrim());
            uniqueObject = (Element)paraseRulenDoc.selectSingleNode("/JetplanParseRule/uniqueObject/arr");
            paramVO.setArrAttribute(uniqueObject.attributeValue("attributeName"));
            paramVO.setArrPath(uniqueObject.getTextTrim());

            Element cptPosInfo = (Element)paraseRulenDoc.selectSingleNode("/JetplanParseRule/cptPosInfo");
            paramVO.setCptPosAttribute(cptPosInfo.attributeValue("attributeName"));
            paramVO.setCptPosPath(cptPosInfo.attributeValue("prefixPath"));
            cptPosInfo = (Element)paraseRulenDoc.selectSingleNode("/JetplanParseRule/cptPosInfo/lon");
            paramVO.setLonAttribute(cptPosInfo.attributeValue("attributeName"));
            paramVO.setLonPath(cptPosInfo.getTextTrim());
            cptPosInfo = (Element)paraseRulenDoc.selectSingleNode("/JetplanParseRule/cptPosInfo/lat");
            paramVO.setLatAttribute(cptPosInfo.attributeValue("attributeName"));
            paramVO.setLatPath(cptPosInfo.getTextTrim());

            Element cptWindTempInfo = (Element)paraseRulenDoc.selectSingleNode("/JetplanParseRule/cptWindTempInfo");
            paramVO.setCptWindTempAttribute(cptWindTempInfo.attributeValue("attributeName"));
            paramVO.setCptWindTempPath(cptWindTempInfo.attributeValue("prefixPath"));
            cptWindTempInfo = (Element)paraseRulenDoc.selectSingleNode("/JetplanParseRule/cptWindTempInfo/windDir");
            paramVO.setWindDirAttribute(cptWindTempInfo.attributeValue("attributeName"));
            paramVO.setWindDirPath(cptWindTempInfo.getTextTrim());
            cptWindTempInfo = (Element)paraseRulenDoc.selectSingleNode("/JetplanParseRule/cptWindTempInfo/windVel");
            paramVO.setWindVelAttribute(cptWindTempInfo.attributeValue("attributeName"));
            paramVO.setWindVelPath(cptWindTempInfo.getTextTrim());
            cptWindTempInfo = (Element)paraseRulenDoc.selectSingleNode("/JetplanParseRule/cptWindTempInfo/windTep");
            paramVO.setWindTepAttribute(cptWindTempInfo.attributeValue("attributeName"));
            paramVO.setWindTepPath(cptWindTempInfo.getTextTrim());
            cptWindTempInfo = (Element)paraseRulenDoc.selectSingleNode("/JetplanParseRule/cptWindTempInfo/alt");
            paramVO.setAltAttribute(cptWindTempInfo.attributeValue("attributeName"));
            paramVO.setAltPath(cptWindTempInfo.getTextTrim());
        } catch (final DocumentException e) {
            // TODO Auto-generated catch block
//			e.printStackTrace();
            errorLogger.error(e.getMessage());
        }
    }

    @Override
    public void parseDataSource(File fDataSource) {
        // TODO Auto-generated method stub
        SAXReader reader = new SAXReader();
        try {
            Document jetplanDoc = reader.read(fDataSource);

			/*生成CPT_INFO数据*/
            // 飞行计划、计划生成时间
            Element flyPlan = (Element)jetplanDoc.selectSingleNode(paramVO.getPlanIdPath());
//			System.out.println(flyPlan.getName() + "-->" + flyPlan.attributeValue(paramVO.getPlanIdAttribute()));

            flyPlan = (Element)jetplanDoc.selectSingleNode(paramVO.getPlanDatePath());
            String planCreateTime = flyPlan.attributeValue(paramVO.getPlanDateAttribute());
            planCreateTime = planCreateTime.replace('T', ' ');
            planCreateTime = planCreateTime.replace('Z', ' ');
//			System.out.println(flyPlan.getName() + "-->" + planCreateTime);

            // 航班号、机尾号、起飞机场、落地机场
            Element flyInfo = (Element)jetplanDoc.selectSingleNode(paramVO.getFlightIdPath());
//			System.out.println(flyInfo.getName() + "-->" + flyInfo.attributeValue(paramVO.getFlightIdAttribute()));
            flyInfo = (Element)jetplanDoc.selectSingleNode(paramVO.getAircraftIdPath());
//			System.out.println(flyInfo.getName() + "-->" + flyInfo.attributeValue(paramVO.getAircraftIdAttribute()));
            flyInfo = (Element)jetplanDoc.selectSingleNode(paramVO.getDepPath());
//			System.out.println(flyInfo.getName() + "-->" + flyInfo.attributeValue(paramVO.getDepAttribute()));
            flyInfo = (Element)jetplanDoc.selectSingleNode(paramVO.getArrPath());
//			System.out.println(flyInfo.getName() + "-->" + flyInfo.attributeValue(paramVO.getArrAttribute()));

            // 航路点、经度、纬度
            List cptList = jetplanDoc.selectNodes(paramVO.getCptPosPath());
            Iterator it = cptList.iterator();
            while(it.hasNext()){
                Element cptPosNode = (Element)it.next();

//				System.out.println(element.getName() + "-->" + element.attributeValue(paramVO.getCptPosAttribute()));
                Element latPos = (Element) cptPosNode.selectSingleNode(paramVO.getLatPath());
                Float latValue = Float.valueOf(latPos.attributeValue(paramVO.getLatAttribute().split("\\.")[0])
                        + "." + latPos.attributeValue(paramVO.getLatAttribute().split("\\.")[1]));
//				System.out.println( "  " + latPos.getName() + "-->" + latValue);

                Element lonPos = (Element) cptPosNode.selectSingleNode(paramVO.getLonPath());
                Float lonValue = Float.valueOf(lonPos.attributeValue(paramVO.getLonAttribute().split("\\.")[0])
                        + "." + lonPos.attributeValue(paramVO.getLonAttribute().split("\\.")[1]));
//				System.out.println( "  " + lonPos.getName() + "-->" + lonValue);

                CptInfo cptInfoRecord = new CptInfo();
                cptInfoRecord.setPlanId(flyPlan.attributeValue(paramVO.getPlanIdAttribute()));
                cptInfoRecord.setPlanDate(planCreateTime);
                cptInfoRecord.setAircraftId(flyInfo.attributeValue(paramVO.getAircraftIdAttribute()));
                cptInfoRecord.setFlightId(flyInfo.attributeValue(paramVO.getFlightIdAttribute()));
                cptInfoRecord.setCptName(cptPosNode.attributeValue(paramVO.getCptPosAttribute()));
                cptInfoRecord.setDep(flyInfo.attributeValue(paramVO.getDepAttribute()));
                cptInfoRecord.setArr(flyInfo.attributeValue(paramVO.getArrAttribute()));
                cptInfoRecord.setLat(latValue);
                cptInfoRecord.setLon(lonValue);

                cptInfoList.add(cptInfoRecord);
            }

			/*生成PLAN_CPT_WD数据*/
            // 风向、风速、风温、高度层
            cptList = jetplanDoc.selectNodes(paramVO.getCptWindTempPath());
            it = cptList.iterator();
            while(it.hasNext()){
                Element cptWdNode = (Element)it.next();
//				System.out.println(cptWdNode.getName() + "-@@@->" + cptWdNode.attributeValue(paramVO.getCptWindTempAttribute()));

                List<Element> subList = cptWdNode.elements();
                for(Element flightLevelNode : subList){
                    PlanCptWd cptWdRecord = new PlanCptWd();
                    //遍历得到每个元素的名字和内容
//					System.out.println( " " + e.getName() + "-->" +  + "   " +  + "   " +  + "   "  + e.attributeValue());
                    cptWdRecord.setPlanId(flyPlan.attributeValue(paramVO.getPlanIdAttribute()));
                    cptWdRecord.setAircraftId(flyInfo.attributeValue(paramVO.getAircraftIdAttribute()));
                    cptWdRecord.setFlightId(flyInfo.attributeValue(paramVO.getFlightIdAttribute()));
                    cptWdRecord.setCptName(cptWdNode.attributeValue(paramVO.getCptWindTempAttribute()));
                    cptWdRecord.setWindDir( Float.valueOf(flightLevelNode.attributeValue(paramVO.getWindDirAttribute())) );
                    String cptFlyLevTemp = flightLevelNode.attributeValue(paramVO.getWindTepAttribute());
                    if ('P' == cptFlyLevTemp.charAt(0)) {
                        cptWdRecord.setWindTep( Float.valueOf(cptFlyLevTemp.substring(1)) );
                    } else if ('M' == cptFlyLevTemp.charAt(0)) {
                        cptWdRecord.setWindTep( Float.valueOf("-" + cptFlyLevTemp.substring(1)) );
                    } else {
                        cptWdRecord.setWindTep( Float.valueOf(cptFlyLevTemp) );
                    }
                    cptWdRecord.setWindVel( Float.valueOf(flightLevelNode.attributeValue(paramVO.getWindVelAttribute())) );
                    cptWdRecord.setAlt( Float.valueOf(flightLevelNode.attributeValue(paramVO.getAltAttribute())) );
                    planCptWdList.add(cptWdRecord);
                }
            }
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            errorLogger.error(e.getMessage());
        }
    }

    @Override
    public void saveToDB() {
        // TODO Auto-generated method stub
        // CPT_INFO 数据入库
        dao.insertCptInfo(cptInfoList);
        // PLAN_CPT_WD 数据入库
        dao.insertPlanCptWd(planCptWdList);
    }

//    public static void parserOnenoteXml(String fileName)
//    {
//        File inputXml = new File(fileName);
//        SAXReader saxReader = new SAXReader();
//        try
//        {
//            Document document = saxReader.read(inputXml);
//            Element root = document.getRootElement();
//	    	Element subNote = null;
//
//	    	List noteList = root.elements("Checkpoints");
//	    	System.out.println( noteList.size() );
//	    	for (int i = 0; i < noteList.size(); i++) {
//		    	subNote = (Element) noteList.get(i);
//		    	System.out.println( subNote.getName() );
////		    	List listfile = subNote .elements("title ");
////		    	String a=((Element) listfile.get(0)).getTextTrim();
////		    	String b=((Element) listfile.get(1)).getTextTrim();
//	    	}
//        }
//        catch (DocumentException e)
//        {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public static void createXml(String fileName)
//    {
//        Document document = DocumentHelper.createDocument();
//        Element employees = document.addElement("employees");
//        Element employee = employees.addElement("employee");
//        Element name = employee.addElement("name");
//        name.setText("ddvip");
//        Element sex = employee.addElement("sex");
//        sex.setText("m");
//        Element age = employee.addElement("age");
//        age.setText("29");
//        try
//        {
//            Writer fileWriter = new FileWriter(fileName);
//            XMLWriter xmlWriter = new XMLWriter(fileWriter);
//            xmlWriter.write(document);
//            xmlWriter.close();
//        }
//        catch (IOException e)
//        {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public static void parserFullXml(String fileName)
//    {
//        File inputXml = new File(fileName);
//        SAXReader saxReader = new SAXReader();
//        try
//        {
//            Document document = saxReader.read(inputXml);
//            Element root = document.getRootElement();
//            for(Iterator i = root.elementIterator(); i.hasNext();)
//            {
//                Element oneNode = (Element) i.next();
//                for(Iterator j = oneNode.elementIterator(); j.hasNext();)
//                {
//                    Element node = (Element) j.next();
//                    System.out.println(node.getName() + ":" + node.getText());
//                }
//            }
//        }
//        catch (DocumentException e)
//        {
//            System.out.println(e.getMessage());
//        }
//    }

}