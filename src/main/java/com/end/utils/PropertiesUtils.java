
package com.end.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author cloud
 *	@date 	2017年10月21日下午8:54:46 
 */
public class PropertiesUtils {
	private static Properties properties  =null;
	private static String propertiesFileName;
	  public  PropertiesUtils(String path){
		   this.propertiesFileName = path;
	  }
	public static String getPropertieValue(String keyName){
		properties = new Properties();
		InputStream in = PropertiesUtils.class.getClassLoader()
				.getResourceAsStream("com/end/config/"+propertiesFileName);
		String value = null;
		try {
			properties.load(in);
			value = properties.getProperty(keyName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
}
