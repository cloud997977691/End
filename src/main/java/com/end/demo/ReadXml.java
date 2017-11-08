/**
 * author: cloud
 */
package com.end.demo;


import java.util.HashMap;
import org.dom4j.DocumentException;
import com.end.uiframework.Locator;
import com.end.utils.XmlUtils;

/**
 * @author cloud
 *	@date 	2017年10月22日 
 */
public class ReadXml {

	/**
	 * @param args
	 * @throws DocumentException 
	 */
	public static void main(String[] args) throws DocumentException {
		 HashMap<String,Locator>  ls= XmlUtils.readElementInfo("LoginPage.xml");
		 String a = ls.get("fantiLink").getElementName();
		 System.out.println(a);
	}
}
