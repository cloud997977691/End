package com.end.pages;


import org.openqa.selenium.WebDriver;
import com.end.config.LocalConfig;
import com.end.uiframework.BasePage;
import com.end.uiframework.Locator;


/**
 * 
 * @author cloud
 *	@date 	2017年10月21日下午4:32:53
 */
public class LoginPage extends BasePage {
//			private WebElement usernameInputbox;
//			private WebElement passwordInputbox;
//			private WebElement loginButton;
			
			
			public LoginPage(WebDriver dr) {
				super(dr);	
				openUrl(LocalConfig.URL);
				//usernameInputbox = findElement("css","input#account"); 
				//		driver.findElement(By.cssSelector("input#account"));
				//passwordInputbox = findElement("css","input[name='password']");
				//		driver.findElement(By.cssSelector("input[name='password']"));
				//loginButton =  findElement("css","button#submit"); 
				//		driver.findElement(By.cssSelector("button#submit"));
			}
			
			
			Locator usernameInputbox = getLocator("usernameInputbox"); 		
			Locator passwordInputbox = getLocator("passwordInputbox");
			Locator loginButton = getLocator("loginButton");
			
			public void inputUserName(String name){
				input(usernameInputbox,name);
			}
			
			public void inputPassword(String password){
				input(passwordInputbox,password);
			}
			
			public void clickLoginButton(){
				click(loginButton);
			}
			
			
//			public MainPage login(String username,String password) {
//				// 输入用户名密码
//				
//				input(usernameInputbox,username);
//				input(passwordInputbox,password);
//				click(loginButton);
////				usernameInputbox.sendKeys(username);
////				passwordInputbox.sendKeys(password);				
////				loginButton.click();
//				// 跳转到主页面MainPage
//				return new MainPage(driver);
//			}
//			public String failLogin(String username,String password){
//				//输入错误用户名密码
//				
//				input(usernameInputbox,username);
//				input(passwordInputbox,password);
//				click(loginButton);
////				usernameInputbox.sendKeys(username);
////				passwordInputbox.sendKeys(password);
////				loginButton.click();
//				wait(3);
//				// 跳转并获取值javaScript值
//				
////				alert  = driver.switchTo().alert();
////				String value = alert.getText();
////				alert.accept();
//				String value = alertGetText();
//				alertAccept();
//				return value;
//			}
//			// 鼠标事件
//		public void aaa(){
//			mouse.doubleClick(findElement(usernameInputbox));
//		}
			
}
