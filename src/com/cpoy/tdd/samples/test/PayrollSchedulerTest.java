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
		 * TODO For now, fill the formatted date(the last param of the
		 * constructor) as 30 March 2012 and let the tests fail until we find
		 * out the LWD of the respective cases
		 */
		return Arrays.asList(new Object[][] { 
				{ 2012, Calendar.MARCH, "30-03-2012" }, 
				{ 1970, Calendar.AUGUST, "30-03-2012" },
				{ 1985, Calendar.MAY, "30-03-2012" }, 
				{ 2014, Calendar.DECEMBER, "30-03-2012" } });
	}
}
