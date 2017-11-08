
package com.end.uiframework;

import java.util.HashMap;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.end.uiframework.Locator.ByType;
import com.end.utils.XmlUtils;

/**
 * @author cloud
 */
public class WebElementUtils extends DriverUtils{

	/**
	 * @param dr
	 */
	 protected HashMap<String,Locator> locatorMap;
	 protected String path;
	public WebElementUtils(WebDriver dr) {
		super(dr);
		path = System.getProperty("user.dir")+"/webelementdata/"
				+this.getClass().getSimpleName()+".xml";
		try {
			locatorMap =XmlUtils.readElementInfo(path);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	// 点击，输入，提交，查找元素，获取元素属性，获取元素文本
	public WebElement getElement(Locator locator){
		WebElement el = null;
		ByType type = locator.getByType();
		try{
		switch(type){
			case id :
			el =  driver.findElement(By.id(locator.getLocatorInfo()));
				break;
			case name:
			el	= driver.findElement(By.name(locator.getLocatorInfo()));
				break;
			case xpath:
			el  =	driver.findElement(By.xpath(locator.getLocatorInfo()));
				break;
			case cssSelector:
			el  =	driver.findElement(By.cssSelector(locator.getLocatorInfo()));
		}
		}catch(Exception e){
			log.error("元素："+locator.getElementName()+"识别异常");
			takeScreenShot("截图保存");
			Assert.fail("查找元素异常，退出当前测试");	
		}
		
		return el;
	}
		public WebElement findElement(Locator locator){
			WebDriverWait wait = new WebDriverWait(driver,locator.getTimeOut());
			WebElement el = wait.until(new ExpectedCondition<WebElement>(){
				public WebElement apply(WebDriver dr){
					return getElement(locator);
				}
			});
			return el;	
		}
		public void click(Locator locator){
			WebElement e = findElement(locator);
			e.click();
			log.info("元素："+locator.getElementName()+" 点击");
		}
		public void input(Locator locator,String content){
			WebElement e = findElement(locator);
			e.sendKeys(content);
			log.info("在元素："+locator.getElementName()+" 提交"+content);
		}
		public void submit(Locator locator){
			WebElement e = findElement(locator);
			e.submit();
		}
		public String getText(Locator locator){
			WebElement e = findElement(locator);
			log.info("获取元素："+locator.getElementName()+" 文本值");
			return  e.getText();
		}
		public String getAttributr(Locator locator,String attribute){
			WebElement e = findElement(locator);
			return e.getAttribute(attribute);
		}
		public Locator getLocator(String locatorName){
				Locator locator = locatorMap.get(locatorName);
				return locator;
		}
			
		
}
