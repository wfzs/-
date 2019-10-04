package util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	static long millisecondsOfOneDay=1000*60*60*24;
	public static java.sql.Date util2sql(java.util.Date d){
		return new java.sql.Date(d.getTime());
	}
	
	/*
	 * 获取今天，并且把时，分，秒和毫秒都置0，因为通过日期控件获取的日期，就是没有时分秒和毫秒的
	 * @return
	 */
	public static Date today(){
		Calendar c=Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	
	/*
	 * 获取月初。
	 * @return
	 */
	public static Date monthBegin(){
		Calendar c=Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.DATE, 1);
		
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}
	/*
	 * 获取月末
	 * @return
	 */
	public static Date monthEnd(){
		Calendar c=Calendar.getInstance();
		c.setTime(new Date());
		
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		
		c.set(Calendar.DATE, 1);
		c.add(Calendar.MONDAY, 1);
		c.add(Calendar.DATE, -1);
		return c.getTime();
	}
	/*
	 *获取本月一共多少天
	 * @return
	 */
	public static int thisMonthTotalDay(){
		long lastMonth=monthEnd().getTime();
		long firstMonth=monthBegin().getTime();
		return (int)((lastMonth-firstMonth)/millisecondsOfOneDay)+1;
	}
	/*
	 * 获取本月还剩多少天
	 * @return
	 */
	public static int thisMonthLeftDay(){
		long lastDay=monthEnd().getTime();
		long today=today().getTime();
		return (int)((lastDay-today)/millisecondsOfOneDay)+1;
	}
	public static void main(String[] args) {
		System.out.println(DateUtil.today());
		System.out.println(DateUtil.monthBegin());
		System.out.println(DateUtil.monthEnd());
		System.out.println(DateUtil.thisMonthTotalDay());
		System.out.println(DateUtil.thisMonthLeftDay());
	}
}
