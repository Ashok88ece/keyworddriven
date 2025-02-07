package com.lao.utilities;

import org.openqa.selenium.By;

public class Locators {
	
	public static By getId(String locatorvalue) 
		
	{
	    return	By.id(locatorvalue);
	}
    public static By getName(String locatorvalue)
    {
    	return By.name(locatorvalue);
		
	}
    public static By getXpath(String locatorvalue)
    {
	     return  By.xpath(locatorvalue);
} 

}
