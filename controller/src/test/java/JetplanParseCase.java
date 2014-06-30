import com.adcc.skyfml.controller.CQFlyPlanParseController;
import com.adcc.skyfml.controller.IFlyPlanParseController;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Created with IntelliJ IDEA.
 * User: GuoXY
 * Date: 2014/6/27
 * Time: 14:43
 * To change this template use File | Settings | File Templates.
 */
public class JetplanParseCase {
    private static Logger debugLogger = Logger.getLogger("forDebug");
    private static Logger errorLogger = Logger.getLogger("forError");

    public static void JetplanParseCase() {
        PropertyConfigurator.configure("config/log4j.properties");
        debugLogger.debug("风温接口服务已启动！");
        // TODO Auto-generated method stub
//		System.out.println("2222");
        IFlyPlanParseController windTempControl = new CQFlyPlanParseController();

        java.io.File f = null;
//		while (true) {
        f =	new java.io.File("dataSource/CPL20140609041727855.txt");
//			if(f.exists()){
//				System.out.println("111");
        debugLogger.debug("检测到航班飞行计划数据，开始解析！");
        windTempControl.parseDataSource(f);
        debugLogger.debug("航班飞行计划数据解析完毕，开始入库！");
        windTempControl.saveToDB();
////			f.delete();
//				f = null;
//			} else {
//				System.out.println("2222");
//			}
//			Thread.sleep(2000);
//		}
        debugLogger.debug("风温接口服务已停止！\n\n\n");
    }



}
