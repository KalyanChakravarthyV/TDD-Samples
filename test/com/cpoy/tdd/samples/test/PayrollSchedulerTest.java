package com.cpoy.tdd.samples.test;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.cpoy.tdd.samples.payroll.util.PayrollSchedulerUtil;

/**
 * 
 * Test to retrieve/validate the last working day of the month in an year for
 * payroll processing.
 * 
 * @author kalyanchakravarthyv
 * 
 */

@RunWith(Parameterized.class)
public class PayrollSchedulerTest {

	private static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	private int year;
	private int month;
	private String expectedLastWorkingDay;

	@Test
	public void test() {

		String actuallastWorkingDay = dateFormat.format(PayrollSchedulerUtil.getLastWorkingDayofTheMonth(year, month));

		assertEquals(expectedLastWorkingDay, actuallastWorkingDay);
	}

	/**
	 * 
	 * @param year like 1999, 2024, 1970 etc.,
	 * @param month has to be set in the form of {@link java.util.Calendar#MARCH}
	 * @param expectedLastWorkingDay formatted date with "dd-MM-yyyy" 
	 */
	public PayrollSchedulerTest(int year, int month, String expectedLastWorkingDay) {
		this.year = year;
		this.month = month;
		this.expectedLastWorkingDay = expectedLastWorkingDay;
	}

	/***
	 * 
	 * @return An array of array objects where each array acts as a param to the
	 *         test object constructor in that order
	 * 
	 */
	@Parameters
	public static Collection<Object[]> sampleTestData() {

		/*
		 * Following test cases have been validated with the corresponding year
		 * calendars
		 */
		
		return Arrays.asList(new Object[][] { 
				{ 2012, Calendar.MARCH, "30-03-2012" }, 
				{ 2008, Calendar.FEBRUARY, "29-02-2008" },
				{ 1970, Calendar.AUGUST, "31-08-1970" },
				{ 1985, Calendar.MAY, "31-05-1985" },
				{ 2100, Calendar.FEBRUARY, "26-02-2100" },
				{ 2000, Calendar.FEBRUARY, "29-02-2000" },
				{ 2012, Calendar.JUNE, "29-06-2012" },
				{ 1986, Calendar.FEBRUARY, "28-02-1986" },
				{ 2014, Calendar.DECEMBER, "31-12-2014" } });
		
	}
}
