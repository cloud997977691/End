/**
 * author: cloud
 */
package com.end.actions;

import org.openqa.selenium.WebDriver;
import com.end.pages.LoginPage;
import com.end.pages.MainPage;

/**
 * @author cloud
 *	@date 	2017年10月23日 
 */
public class LoginOperate {
	private static WebDriver driver;
	public static WebDriver getDriver(){
		return driver;
	}
	public static void setDriver(WebDriver driver){
		LoginOperate.driver = driver;
	}
	public static LoginPage loginPage;
	public static MainPage mainPage;
	public static MainPage LoginSuccess(String name,String password){
		loginPage = new LoginPage(getDriver());
		loginPage.inputUserName(name);
		loginPage.inputPassword(password);
		loginPage.clickLoginButton();
		return new MainPage(getDriver());
	}
	public static String getLoginName(String name,String password){
		 mainPage = LoginSuccess(name,password);
		 return mainPage.getLoginText();
	}
	
	//登录失败
	public static String loginFail(String username,String password) {
		loginPage = new LoginPage(getDriver());
		loginPage.inputUserName(username);
		loginPage.inputPassword(password);
		loginPage.clickLoginButton();
		loginPage.wait(3);
		String value =loginPage.alertGetText();
		loginPage.alertAccept();
		return value;
	}

	
	
}
