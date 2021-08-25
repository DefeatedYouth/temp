package com.sgcc.bd.overallview.common.utils;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 说明：日期处理
 */
public class MyDateUtil {

	private static final Calendar C = new GregorianCalendar();

	/**
	 * 获取YYYY格式
	 * @return
	 */
	public static String getSdfTimes() {
		return DateUtil.format(new Date(),"yyyyMMddHHmmss");
	}

	/**
	 * 获取YYYY格式
	 * @return
	 */
	public static String getYear() {
		return DateUtil.format(new Date(),"yyyy");
	}

	/**
	 * 获取YYYY-MM格式
	 * @return
	 */
	public static String getMonth() {
		return DateUtil.format(new Date(),"yyyyMM");
	}

	/**
	 * 获取YYYY-MM-DD格式
	 * @return
	 */
	public static String getDay() {
		return DateUtil.format(new Date(),"yyyy-MM-dd");
	}

	/**
	 * 获取YYYYMMDD格式
	 * @return
	 */
	public static String getDays(){
		return DateUtil.format(new Date(),"yyyyMMdd");
	}

	/**
	 * 获取YYYY-MM-DD HH:mm:ss格式
	 * @return
	 */
	public static String getTime() {
		return DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 格式化日期
	 * @return
	 */
	public static Date fomatDate(String date) {
		try {
			return DateUtil.parse(date, "yyyy-MM-dd");
		} catch (Exception e) {
		}
		return null;
	}

    /**
     * 得到n天之后是周几
     * @param days
     * @return
     */
    public static String getAfterDayWeek(String days) {
    	int daysInt = Convert.toInt(days);
        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();
		return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
    }

	/**
	 * 按照参数format的格式，日期转字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String date2Str(Date date,String format){
		if(date!=null){
			return DateUtil.format(date, format);
		}else{
			return "";
		}
	}

	public static String date2SqlStr(Date date){
		if(date!=null){
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}else{
			return "";
		}
	}
	public static String getTimeId(){
		return DateUtil.format(new Date(), "yyyyMMddHHmmssSSS");
	}

	/**
	 * <br>功能说明：取当前 日期的下一个月
	 * <br>--------------------------------------
	 * <br>修     改：
	 * <br>修改者：
	 * <br>时    间:
	 * <br>--------------------------------------
	 * <br>@param date
	 * <br>@return
	 */
	public static Date getNextMonth(Date date){
		C.setTime(date);
		C.set(Calendar.MONTH, ( C.get(Calendar.MONTH) + 1));
		return  C.getTime();
	}


	/**
	 * 获取月的第一天
	 * @return
	 */
	public static Date getMonthFirstDay(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY,calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
		return calendar.getTime();
	}
	/**
	 * 获取月的最后一天
	 * @return
	 */
	public static Date getMonthFinalDay(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY,calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
		return calendar.getTime();
	}
	/**
	 * 获取上一个月的第一天
	 * @return
	 */
	public static Date getLastMonthFirstDay(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY,calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
		return calendar.getTime();
	}
	/**
	 * 获取上一个月的最后一天
	 * @return
	 */
	public static Date getLastMonthFinalDay(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY,calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
		return calendar.getTime();
	}



	/**
	 *	通过下次试验时间
	 */
	public static Date getNextMonthByParam(Date date,Integer period){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, (calendar.get(Calendar.MONTH) + period));
		return calendar.getTime();
	}


	/**
	 *	计算日期 N天后的日期
 	 */
	public static Date getNextDayByParam(Date date,Integer period){
		C.setTime(date);
		C.set(Calendar.DATE, ( C.get(Calendar.DATE) + period));
		return  C.getTime();
	}
	/**
	 *	计算日期 明天的零时零分
	 */
	public static Date getNextDayZero(Date date,Integer period){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, (calendar.get(Calendar.DATE) + period));
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		return calendar.getTime();
	}
	/**
	 *	计算日期 下一小时
	 */
	public static Date getNextHourZero(Date date,Integer period){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, (calendar.get(Calendar.HOUR_OF_DAY) + period));
		return calendar.getTime();
	}



	/**
	 *	计算日期 N天后的日期
	 */
	public static Date getAfterMoth(Date date,Integer month){
		Calendar calendar = Calendar.getInstance(); //得到日历
		calendar.setTime(date);//把当前时间赋给日历
		calendar.add(Calendar.MONTH, month);  //设置为之后的月数
		return calendar.getTime();
	}

	/**
	 * 根据周期月数以及上次试验时间获取下一次试验时间
	 *
	 * @param monthNum 月份数
	 * @param time     上次试验时间
	 * @return
	 */
	public static Date getNextTestTime(Integer monthNum, Date time) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(time);
		calendar.add(Calendar.MONTH, monthNum);
		Date nextTestTime = calendar.getTime();
		return nextTestTime;
	}

	/**
	 * 日期增加天数
	 * @param date
	 * @param iCount
	 * @return
	 */
	public static Date getAddDate(Date date, int iCount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, iCount);
		return cal.getTime();
	}

	public static int compareDate(Date date1, Date date2) {
		if (date1.getTime() > date2.getTime()){
			return -1;
		}

		else if (date1.getTime() < date2.getTime())
		{
			return 1;
		}
		else {
			return 0;
		}
	}

	/**
	 * 格式化字符串为日期
	 *
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date parseDate(String date, String format) {
		try {
			return DateUtil.parse(date, format);
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * 日期 默认格式  年月日
	 *
	 * @param date
	 * @return
	 */
	public static Date parseDateDefault(String date) {
		return parseDate(date,"yyyy-MM-dd");
	}

	/**
	 * 日期 默认格式  年月日
	 *
	 * @param date
	 * @return
	 */
	public static Date parseTimeDefault(String date) {
		try {
			return parseDate(date,"yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 日期 默认格式  年月日
	 *
	 * @param date
	 * @return
	 */
	public static Boolean isValidDate(String date) {
		boolean convertSuccess=true;
		// 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
			format.setLenient(false);
			format.parse(date);
		} catch (Exception e) {
			convertSuccess=false;
		}
		return convertSuccess;
	}
	public static Date validStrDateForImport(String date) {
		Date parse = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy.MM.dd");
		try {
			// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
			format.setLenient(false);
			parse = format.parse(date);
		} catch (Exception e) {

		}
		if (parse != null){
			return parse;
		}
		try {
			// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
			format2.setLenient(false);
			parse = format2.parse(date);
		} catch (Exception e) {

		}
		return parse;
	}

	public static Boolean isValidDate(int date) {
		String value = String.valueOf(date);
		if(value.length() == 13){
			return true;
		}
		return false;
	}

    public static void main(String[] args) {
//		Double proportion = 10.00;
//		//下限数量
//		Double l = (proportion / 100.00)*11;
//		Integer round = (int) Math.round(l);
//		System.out.println(round);
		System.out.println(getNextDayZero(new Date(),1));
//		System.out.println(date2SqlStr(getMonthFinalDay()));
//		System.out.println(date2SqlStr(getMonthFirstDay()));
//		System.out.println(date2SqlStr(getLastMonthFirstDay()));
//		System.out.println(date2SqlStr(getLastMonthFinalDay()));
    }

}
