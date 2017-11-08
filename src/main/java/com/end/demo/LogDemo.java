package com.end.demo;


import org.openqa.selenium.WebDriver;

import com.end.uiframework.DriverFactory;
import com.end.utils.PropertiesUtils;

public class LogDemo {
	public static void main(String args[]){
//	PropertiesUtils propertisUtils = new PropertiesUtils("local.properties");
//	String a =	PropertiesUtils.getPropertieValue("chromePath");
//	System.out.println(a);
	WebDriver driver = DriverFactory.getChromeDriver();
	driver.get("http://www.baidu.com");
	}
}
