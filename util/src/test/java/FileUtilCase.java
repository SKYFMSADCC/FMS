import com.adcc.skyfml.util.FileUtil;
import junit.framework.TestCase;
import org.xml.sax.SAXException;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: GuoXY
 * Date: 2014/7/1
 * Time: 9:59
 * To change this template use File | Settings | File Templates.
 */
public class FileUtilCase extends TestCase {
    public static void testFileProcessCase() {
        // 1、判断指定目录中是否存在文件
//        String rootDirPath = "E:\\Reference\\Code\\myself\\dms";
//        File rootDir = new File(rootDirPath);
//        System.out.println(rootDir + "是否为目录：" +rootDir.isDirectory());
//
//        String[] fileNameList = rootDir.list();
//
//        System.out.println( rootDir + "含有的文件目录总数：" + fileNameList.length );
//        for(int i = 0; i < fileNameList.length; i++){
////            File childFile = new File(rootDirPath + "\\" + fileNameList[i]);
////            System.out.println(fileNameList[i] + "是否为文件：" + childFile.isFile());
//
//            // m.group会将所有匹配到的对象拼成一个字符串
//            Pattern p = Pattern.compile("(.+\\.txt)");
//            Matcher m = p.matcher(fileNameList[i]);
//            if(m.find())
//                System.out.print(m.group());
//        }
        // 2、判断内容是不是xml文件
//        boolean b = FileUtil.IsXmlDocByContext("C:/Users/GuoXY/Desktop/flightplan.txt");
//        if(b) {
//            System.out.println("xml文件");
//        } else {
//            System.out.println("不是xml文件");
//        }

        // 3、文件移动
        FileUtil.MoveFile("C:/Users/GuoXY/Desktop/flightplan.txt","C:/Users/GuoXY/Desktop/FlyPlanData");
    }

}
