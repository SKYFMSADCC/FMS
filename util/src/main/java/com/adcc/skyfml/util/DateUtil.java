package com.adcc.skyfml.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * <P>FileName: DateUtil.java
 * @author GuoXY
 * <P>CreateTime: 2014-04-03
 * <P>Description:
 * <P>Version: v1.0
 * <P>History:
 * <P> 
 */
public class DateUtil {

    /**
     * FULL TIME FORMAT
     */
    public static final SimpleDateFormat DATE_TIME_F = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * FULL TIME FORMAT FOR ORACLE
     */
    public static final SimpleDateFormat DATE_TIME_F_ = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
    /**
     * 
     */
    public static final SimpleDateFormat DATE_TIME_HM = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    /**
     * FULL DATE DATE  
     */
    public static final SimpleDateFormat DATE_F = new SimpleDateFormat("yyyy-MM-dd");
    
    /**
     * 
     */
    private static final int DATE_OFFSET = 10;

    /**
     * 
     */
    private DateUtil() {
    }

    
	public static String DateToStr(Date date, String formatStr) {
	   SimpleDateFormat format = new SimpleDateFormat(formatStr);
	   String str = format.format(date);
	   return str;
	} 

	public static Date StrToDate(String str, String formatStr) {
	   SimpleDateFormat format = new SimpleDateFormat(formatStr);
	   Date date = null;
	   try {
	   		date = format.parse(str);
	   } catch (ParseException e) {
		   e.printStackTrace();
	   }
	   return date;
	}


    public static String getCurrentDateTime(String formate) {
        String result = null;
        Date currentDate = new Date();
        SimpleDateFormat formatdater = new SimpleDateFormat(formate);
        result = formatdater.format(currentDate);
        return result;
    }

 
    public static String getDate(Date currentDate, String formate) {
        String result = null;
        SimpleDateFormat formatdater = new SimpleDateFormat(formate);
        result = formatdater.format(currentDate);
        return result;
    }

    public static Date getYesterday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, (calendar.get(Calendar.DAY_OF_YEAR) - 1));
        return calendar.getTime();
    }

    public static String getYesterday(String formate) {
        SimpleDateFormat formatdater = new SimpleDateFormat(formate);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, (calendar.get(Calendar.DAY_OF_YEAR) - 1));
        return formatdater.format(calendar.getTime());
    }

 
    public static Date changeDay(Date date, int offset) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, (calendar.get(Calendar.DAY_OF_YEAR) + offset));
        return calendar.getTime();
    }

 
    public static String changeDay(Date date, int offset, String formate) {
        SimpleDateFormat formatdater = new SimpleDateFormat(formate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, (calendar.get(Calendar.DAY_OF_YEAR) + offset));
        return formatdater.format(calendar.getTime());
    }


    public static String changeDay(String date, int offset, String formate) throws ParseException {
        SimpleDateFormat formatdater = new SimpleDateFormat(formate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(formatdater.parse(date));
        calendar.set(Calendar.DAY_OF_YEAR, (calendar.get(Calendar.DAY_OF_YEAR) + offset));
        return formatdater.format(calendar.getTime());
    }


    public static String changeHour(String datetime, int offset, String formate)
            throws ParseException {
        SimpleDateFormat formatdater = new SimpleDateFormat(formate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(formatdater.parse(datetime));
        calendar.add(Calendar.HOUR, offset);
        return formatdater.format(calendar.getTime());
    }

 
    public static String changeMinute(String datetime, int offset) throws ParseException {
        SimpleDateFormat formatdater = new SimpleDateFormat(SysConstants.FORMAT_DATETIME_FULL);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(formatdater.parse(datetime));
        calendar.add(Calendar.MINUTE, offset);
        return formatdater.format(calendar.getTime());
    }


    public static String changeSecond(String datetime, int offset) throws ParseException {
        SimpleDateFormat formatdater = new SimpleDateFormat(SysConstants.FORMAT_DATETIME_FULL);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(formatdater.parse(datetime));
        calendar.add(Calendar.SECOND, offset);
        return formatdater.format(calendar.getTime());
    }

 
    public static String getSysDateS(String formate) throws ParseException {
        String result = null;
        Date currentDate = new Date();
        SimpleDateFormat formatdater = new SimpleDateFormat(formate);
        result = formatdater.format(currentDate);
        return result;
    }

 
    public static Date getSysDateD(String formate) throws ParseException {
        Date currentDate = new Date();
        return currentDate;
    }

	/**
	* @function：字符开始时间yyyy-mm-dd加上" 00:00:00"后缀
	* @param
	* @return
	*/
    public static String getBeginDate(String beginDate) throws ParseException {
        String result = null;
        if (!ObjectUtil.isBlank(beginDate)) {
        	// yyyy-MM-dd HH:mm:ss 切除后面的毫秒
         	if (beginDate.length() > 10) {
         		beginDate = beginDate.substring(0, 9);
         	}
            result = beginDate + " 00:00:00";
        }
        return result;
    }
    
	/**
	* @function：字符结束时间yyyy-mm-dd加上" 23:59:59"后缀
	* @param
	* @return
	*/
    public static String getEndDate(String endDate) throws ParseException {
        String result = null;
        if (!ObjectUtil.isBlank(endDate)) {
        	// yyyy-MM-dd HH:mm:ss 涓轰簡鑳藉鐞嗚繖绉嶆牸寮忕殑鏃ユ湡
         	if (endDate.length() > 10) {
         		endDate = endDate.substring(0, 9);
         	}
            result = endDate + " 23:59:59";
        }
        return result;
    }

	/**
	* @function
	* @Description
	* @param
	* @return锛歋tring
	*/
    public static String getBeginDate(Date beginDate) {
        String result = null; 
        if (!ObjectUtil.isBlank(beginDate)) {
        	result = DateToStr(beginDate, "yyyy-MM-dd");
            result = result + " 00:00:00";
        }
        return result;
    }

	/**
	* @function
	* @Description
	* @parame
	* @return
	*/
    public static String getEndDate(Date endDate) {
        String result = null; 
        if (!ObjectUtil.isBlank(endDate)) {
        	result = DateToStr(endDate, "yyyy-MM-dd");
            result = result + " 23:59:59";
        }
        return result;
    }
    
    public static String normalDate(String datetime) throws ParseException {
        String result = null;
        if (!ObjectUtil.isBlank(datetime)) {
            result = datetime.substring(0, DATE_OFFSET);
        }
        return result;
    }

//    public static Date getDBDate() {
//        return SysDate.getCurrentTimestamp();
//    }
//
//
//    public static String getDBDateTimeStr() {
//        return DateUtil.dateTime2Str(SysDate.getCurrentTimestamp());
//    }

    public static String dateTime2Str(Date date) {
        String str = "";
        if (null != date) {
            str = DateUtil.toString(date, "yyyy-MM-dd HH:mm:ss");
        }
        return str;
    }

    public static String toString(Date date, String format) {
        if (date == null) {
            return null;
        }
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }


    public static String date2Week(Date date) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat("E").format(date);
    }
    // public static void main (String args[]){
    // try {
    // System.out.println(getSysDate(WebConstants.FORMAT_DATETIME_FULL));
    // } catch (ParseException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    //
    // }
	/**
	* @function
	* @Description
	* @param
	* @return
	*/
    public static String oracleTimeToStandardTime(String oraTimeStr) {
//    	Date currentTime = new Date(oraTimeStr);
//    	
//    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    	String dateString = formatter.format(currentTime);
////    	ParsePosition pos = new ParsePosition(8);
////    	Date currentTime_2 = formatter.parse(dateString, pos);
//    	System.out.println(dateString);
    	
    	Date date = null;
    	try {
			date = DATE_TIME_F_.parse(oraTimeStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println(date);
    	String dateString = DATE_TIME_F.format(date);
    	System.out.println(dateString);
    	
        return dateString;
    }

}
