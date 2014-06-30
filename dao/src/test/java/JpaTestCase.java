import com.adcc.skyfml.dao.CptInfoService;
import com.adcc.skyfml.dao.PlanCptWdService;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: GuoXY
 * Date: 2014/6/26
 * Time: 18:28
 * To change this template use File | Settings | File Templates.
 */
public class JpaTestCase extends TestCase {
    public static void testJpaTestCase() {
//        System.out.println("-----------------\r\n@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n-----------------\r\n");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationcontext-dao.xml");
        CptInfoService cptInfoService = ctx.getBean("cptInfoService", CptInfoService.class);
        PlanCptWdService planCptWdService = ctx.getBean("planCptWdService", PlanCptWdService.class);

        try{
            // 测试一：CptInfo
//            CptInfo cptInfo = new CptInfo();
//            cptInfo.setFlightId("CA8899");
//            cptInfo.setAircraftId("B-5811");
//            cptInfo.setPlanId("planId");
//            cptInfo.setCptName("TOC");
//            cptInfo.setLon(Float.valueOf("81.99"));
//            cptInfo.setLat(Float.valueOf("12.5"));
//            cptInfo.setDep("ZSPD");
//            cptInfo.setArr("VTBS");
//            java.util.Date temp = DateUtil.StrToDate("2014-06-09 4:17:20", SysConstants.FORMAT_DATETIME_FULL);
//            System.out.print(temp);
//            cptInfo.setPlanDate(temp);
//            cptInfo.setAirlines("CA");
            // 增
//            cptInfoService.save(cptInfo);
            // 删
//            cptInfoService.deleteById(27);
            // 单例查寻
//              cptInfo = cptInfoService.findById(new Integer("24"));
//              System.out.println(cptInfo.getAircraftId());
            // 批量查询
//            List<CptInfo> list = (List<CptInfo>) cptInfoService.findAll();
            // 自定义查询
//             List<CptInfo> list = cptInfoService.findByCptnameLike("%C");
//             for (int i = 0; i < list.size(); i++) {
//                System.out.println(list.get(i).getCptName());
//             }
            // 查询总记录数
//            long recordSize = cptInfoService.count();
//            System.out.println(recordSize);

            // 测试二：PlanCptWd
//            PlanCptWd planCptWd = new PlanCptWd();
//            planCptWd.setCptName("COC");
//            planCptWd.setAirlines("CA");
//            planCptWd.setPlanId("013344");
//            planCptWd.setAircraftId("B-5811");
//            planCptWd.setFlightId("CA1011");
//            planCptWd.setAlt(9800);
//            planCptWd.setWindDir(123);
//            planCptWd.setWindTep(222);
//            planCptWd.setWindVel(333);
//
//            planCptWdService.save(planCptWd);

//            PlanCptWd temp = planCptWdService.findById(1);
            System.out.println("122222");
        }catch(Exception ex){
//            Log.error("doNotice() error", MobileMsgNotice.class);
            System.out.println(ex.getMessage());

        }
    }
}
