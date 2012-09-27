/**
 * 
 */
package com.cpoy.tdd.samples.payroll.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * Utility class for payroll scheduling.
 * 
 * Test Driven Code that would evolve as the tests get complex
 * 
 * @author kalyanchakravarthyv
 * 
 */
public class PayrollSchedulerUtil {

	public static Date getLastWorkingDayofTheMonth(int year, int month) {
		
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		
		calendar.set(Calendar.DAY_OF_MONTH , calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		/*
		 * roll the calendar by one day backward until a weekday is found
		 */
		while(isLastDayAWeekEndOrHoliday(calendar)){
			calendar.roll(Calendar.DAY_OF_MONTH , -1);
		}
		
		System.out.println(calendar.getTime());
		System.out.println( new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime()));
		
		
		return calendar.getTime();
	}

	/**
	 * 
	 * @param calendar
	 * @return
	 * 
	 * TODO Consider holidays which shall be configurable
	 * 
	 */
	private static boolean isLastDayAWeekEndOrHoliday(Calendar calendar) {
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY;
	}

}
