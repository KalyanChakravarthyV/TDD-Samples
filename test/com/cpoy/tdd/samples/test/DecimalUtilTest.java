package com.cpoy.tdd.samples.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.cpoy.tdd.samples.util.DecimalUtil;

public class DecimalUtilTest {

	@Test
	public void testAbsoluteMin()	{
		assertEquals(1,DecimalUtil.getAbsoluteMinimum(new int[]{ -8, 3, 11, 2, 1, 4, 21, -3, -2 }));
	}
	
	@Test
	public void testEquiDistant()	{
		assertEquals(2,DecimalUtil.getAbsoluteMinimum(new int[]{ -8, 3, 11, 2, 4, 21, -3, -2 }));
	}
	
	@Test
	public void testNullOrEmpty()	{
		
		try{
			DecimalUtil.getAbsoluteMinimum((int[])null);
			fail("This should not have happenned");
		}catch(IllegalArgumentException iae){
			assertEquals("Must have a valid input",iae.getMessage());
		}
		
		
	}
	
}