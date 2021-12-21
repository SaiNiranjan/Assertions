package com.qa.ExceleRATE.util;
/**
 * 
 * @author SGajula
 *
 */
public class TimeUtil {
	
	/**
	 * Short wait
	 */
	public static void shortWait(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Medium wait
	 */
	public static void mediumWait(){
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Long wait
	 */
	public static void longWait(){
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}