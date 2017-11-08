/**
 * 
 */
package com.end.config;

import com.end.utils.PropertiesUtils;

/**
 * @author cloud
 *	@date 	2017年10月21日下午9:05:39 
 */
public class LocalConfig {
		static PropertiesUtils propertiesUtils = new PropertiesUtils("local.properties");
		
		public static final String URL = propertiesUtils.getPropertieValue("url");
		public static final String CHROME_PATH = propertiesUtils.getPropertieValue("chromePath");
		public static final String SHOT_PATH =  propertiesUtils.getPropertieValue("shotPath");
}
