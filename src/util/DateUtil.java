package util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	static long millisecondsOfOneDay=1000*60*60*24;
	public static java.sql.Date util2sql(java.util.Date d){
		return new java.sql.Date(d.getTime());
	}
	
	/*
	 * ��ȡ���죬���Ұ�ʱ���֣���ͺ��붼��0����Ϊͨ�����ڿؼ���ȡ�����ڣ�����û��ʱ����ͺ����
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
	 * ��ȡ�³���
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
	 * ��ȡ��ĩ
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
	 *��ȡ����һ��������
	 * @return
	 */
	public static int thisMonthTotalDay(){
		long lastMonth=monthEnd().getTime();
		long firstMonth=monthBegin().getTime();
		return (int)((lastMonth-firstMonth)/millisecondsOfOneDay)+1;
	}
	/*
	 * ��ȡ���»�ʣ������
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
