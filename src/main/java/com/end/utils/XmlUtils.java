/**
 * author: cloud
 */
package com.end.utils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.end.uiframework.Locator;
import com.end.uiframework.Locator.ByType;

/**
 * @author cloud
 *	@date 	2017年10月22日 
 */
public class XmlUtils {
	
	public  static  HashMap<String,Locator> readElementInfo(String filePath) throws DocumentException   {
	//	String xfp =System.getProperty("user.dir")+"/webelementdata/"+fileName;
		Map<String,Locator> elementinfos = new HashMap<String,Locator>();
		// 利用dom4j读取这个文件
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(new File(filePath));
		Element root = document.getRootElement();	
		List<Element> childList =root.elements("locator");
		for(Element e:childList){
			String value = e.attributeValue("value").toString();
			int timeOut = Integer.parseInt(e.attributeValue("timeout"));
			String name =e.attributeValue("name").toString();
			String type = e.attributeValue("type").toString();
			Locator locator = new Locator(value,timeOut,getType(type),name);		
			String keyName = e.getText();
			elementinfos.put(keyName, locator);
		}
			return (HashMap<String, Locator>) elementinfos;
}
		public static ByType getType(String value){
			ByType type =null;
			switch(value){
			case "css": 
				type =ByType.cssSelector;
				break;
			case "xpath":
				type = ByType.xpath;
				break;
			}
			return type;
		}

	}

