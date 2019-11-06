package com.bwei.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * @author wanghd
 */
public class DateUtils {
	
	/**
	 * 将字符串转换成日期
	 * @param str
	 * @return
	 */
	public static Date formateStringToDate(String str) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			 date = dateFormat.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 计算天数
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	public static int getFutureDays(String starttime,String endtime) {
		Date s1 = formateStringToDate(starttime);
		long stime = s1.getTime();
		
		Date s2 = formateStringToDate(endtime);
		long etime = s2.getTime();
		long dt = etime - stime ;
		
		int day = (int) (dt/1000/60/60/24);
		return day;
	}
	
	public static int getFutureDays(String future) {
		
		Date date = new Date();
		long time = date.getTime();
		
		Date formateStringToDate = formateStringToDate(future);
		long time2 = formateStringToDate.getTime();
		
		long dt = time2 - time ;
		
		int day = (int) (dt/1000/60/60/24);
		return day;
	}
	/**
	 * 判断给定日期是否是当天
	 * @param str
	 * @return
	 */
	public static boolean isToday(String str) {
		/*
		 * 获取日期的年 月 日
		 * Calendar instance = Calendar.getInstance();
		instance.setTime(new Date());
		instance.get(Calendar.YEAR);
		instance.get(Calendar.MONTH);
		instance.get(Calendar.DAY_OF_MONTH);*/
		
		int futureDays = getFutureDays(str);
		if(futureDays==0) {
			return true;
		}
		return false;
	}
}
