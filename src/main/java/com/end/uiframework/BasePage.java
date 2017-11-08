/**
 * author: cloud
 */
package com.end.uiframework;

import org.dom4j.DocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

/**
 * @author cloud
 *	@date 	2017年10月21日 
 */
public class BasePage extends WebElementUtils{

	/**
	 * @param dr
	 * @throws DocumentException 
	 */
	public BasePage(WebDriver dr)  {
		super(dr);
	}
	public String getPageSource(){
		wait(2);
		return driver.getPageSource();
	}
	public void alertAccept(){
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	public void alertDismiss(){
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	public void inputAlert(String value){
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}
	public String alertGetText(){
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
		
}
