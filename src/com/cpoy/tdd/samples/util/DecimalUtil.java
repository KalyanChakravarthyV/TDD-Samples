package com.cpoy.tdd.samples.util;

import java.math.BigDecimal;

public class DecimalUtil 
{

	public static int getAbsoluteMinimum(int[]inputArray) {
		
		if(inputArray == null || inputArray.length == 0) throwException();
		
		BigDecimal[] absoluteValues = new BigDecimal[inputArray.length];

		for(int i =0 ; i<inputArray.length; i++){
			absoluteValues[i] = new BigDecimal(inputArray[i]);
		}
		
		return getAbsoluteMinimum(absoluteValues).intValue();

	}
	
	private static void throwException() {
			throw new IllegalArgumentException("Must have a valid input");
		
	}

	public static BigDecimal getAbsoluteMinimum(BigDecimal[] inputArray) {
		
		if(inputArray == null || inputArray.length == 0) throwException();
		
		BigDecimal[] absoluteValues = new BigDecimal[inputArray.length];
		
		for(int i =0 ; i<inputArray.length; i++){
			absoluteValues[i] = inputArray[i].abs();
		}
		
		for(int i=1; i< absoluteValues.length; i++){
			if(absoluteValues[0].compareTo(absoluteValues[i]) > 0) {
				BigDecimal t = absoluteValues[0];
				absoluteValues[0] = absoluteValues[i];
				absoluteValues [i] = t;
			}
		}
		
//		Arrays.sort(absoluteValues);
		
		return absoluteValues[0];
	}

}
