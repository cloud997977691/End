 /**
 * 
 */
package com.end.pages;


import org.openqa.selenium.WebDriver;
import com.end.uiframework.BasePage;
import com.end.uiframework.Locator;


/**
 * @author cloud
 *	@date 	2017年10月21日下午4:04:37 
 */
public class MainPage extends BasePage {
		public MainPage(WebDriver dr) {
			super(dr);
			// 点击用户名
			//userMenu = driver.findElement(By.cssSelector("#userMenu"));
		}
		Locator userMenu = getLocator("userMenu");
		public String getLoginText(){
			// 返回用户名的值
			wait(2);
			return getText(userMenu);
		}
}
