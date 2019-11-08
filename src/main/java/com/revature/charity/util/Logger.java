package com.revature.charity.util;

public final class Logger {
public static final String LEVEL = "DEBUG";
public static final String LEVEL1 = "ERROR";
public static final String LEVEL2 = "INFO";
public enum MyEnum {
	LEVEL;
	}

	public static  void debug(Object message)
	{
		if(LEVEL.equals("DEBUG"))
		{
			System.out.println(message);
			
		}
	}
	
	public static void error(Object message)
	{
		if(LEVEL1.equals("ERROR"))
		{
			System.out.println(message);
		}
	}
	
	public static void info(Object message)
	{
		if(LEVEL2.equals("INFO"))
		{
			System.out.println(message);
		}
	}

	public static void getInstance() {
		// TODO Auto-generated method stub
		
	}

	

}
