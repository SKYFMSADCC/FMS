import com.adcc.skyfml.controller.CQFlyPlanParseController;
import com.adcc.skyfml.controller.IFlyPlanParseController;
import com.adcc.skyfml.controller.JetplanParseController;
import com.adcc.skyfml.util.FileUtil;
import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import java.io.*;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;
/**
 * Created with IntelliJ IDEA.
 * User: GuoXY
 * Date: 2014/6/27
 * Time: 14:43
 * To change this template use File | Settings | File Templates.
 */
public class JetplanParseCase extends TestCase {
    private static Logger debugLogger = Logger.getLogger("forDebug");
    private static Logger errorLogger = Logger.getLogger("forError");
    private static IFlyPlanParseController planParseControl = null;

    @Override
    protected void setUp() throws Exception {
        PropertyConfigurator.configure("controller/config/log4j.properties");
        debugLogger.debug("风温接口服务已启动！");
    }

    public static void testJetplanParseCase() throws SAXException {
        // TODO Auto-generated method stub
        java.io.File fBaseParam = new java.io.File("controller/config/SysBaseParamter.xml");
        final SAXReader readerBaseParam = new SAXReader();
        String scanDirPath = "";
        String backupDirPath = "";
        try {
            final Document paraseRulenDoc = readerBaseParam.read(fBaseParam);
            Element uniqueObject = (Element)paraseRulenDoc.selectSingleNode("/baseParamter/windTempInterfaceService/scanDir");
            scanDirPath = uniqueObject.getText();
            uniqueObject = (Element)paraseRulenDoc.selectSingleNode("/baseParamter/windTempInterfaceService/backupDir");
            backupDirPath = uniqueObject.getText();
            System.out.println(scanDirPath);
            System.out.println(backupDirPath);
        } catch (final DocumentException e) {
            // TODO Auto-generated catch block
//			e.printStackTrace();
            errorLogger.error(e.getMessage());
        }


        // 让程序一直运行下去
//		while (true) {
            // 判断指定目录中是否存在文件
            File fSacnDir = new File(scanDirPath);
            if ((null == fSacnDir) || !fSacnDir.isDirectory()) {
                errorLogger.error("无法打开指定数据源目录！");
                return ;
            }

            String[] fileNameList = fSacnDir.list();
            System.out.println( fSacnDir + "含有的文件目录总数：" + fileNameList.length );
            for(int i = 0; i < fileNameList.length; i++){
                File childFile = new File(scanDirPath + "\\" + fileNameList[i]);
                //                System.out.println(fileNameList[i] + "是否为文件：" + childFile.isFile());
                // xml格式的JetPlan数据处理
                if ( childFile.isFile() && FileUtil.IsXmlDocByContext(scanDirPath + "\\" + fileNameList[i]) ) {
                    debugLogger.debug("检测到Jetplan格式航班计划，开始解析！");
                    planParseControl = new JetplanParseController();
                 // 普通文本格式的飞行计划处理
                } else if (childFile.isFile()) {
                    debugLogger.debug("检测到文本格式航班飞行计划数据，开始解析！");
                    planParseControl = new CQFlyPlanParseController();
                //
                } else {
                    errorLogger.error("数据源目录中存在无关目录！");
                    continue;
                }

                boolean parseStatus = planParseControl.parseDataSource(childFile);
                if (parseStatus) {
                    debugLogger.debug("航班飞行计划数据解析完毕，开始入库！");
                    planParseControl.saveToDB();
//                    childFile.delete();
                } else {
                    System.out.println(backupDirPath);
//                    FileUtil.MoveFile(childFile, backupDirPath);
                }
            }
            // 每5秒钟，检测一次是否出现新的航班计划
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//		}
        debugLogger.debug("风温接口服务已停止！\n\n\n");
    }
}
