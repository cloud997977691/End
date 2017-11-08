package com.End;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.end.actions.LoginOperate;
import com.end.uiframework.DriverFactory;
import com.end.utils.AssertUtils;
import com.end.utils.ExeclUtils;
import com.end.utils.TestCase;
/**
 * 
 * @author cloud
 *	@date 	2017年10月21日下午5:01:54
 */
public class LoginTest {
		WebDriver driver; 
		AssertUtils assertUtils ;;
		@BeforeMethod
		public void setUp(){
			try{
		 assertUtils = new AssertUtils();	
		 driver = DriverFactory.getChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}catch(Exception e){
				Assert.fail("测试初始化报错");
			}		
			}
					
	@Test
  public void loginTest() throws DocumentException{
		List<TestCase> testcases = ExeclUtils.getUITestData("UITest.xlsx");
		HashMap<String,String> testdata = (HashMap<String, String>) testcases.get(0).getTestdata();
		LoginOperate.setDriver(driver);
		String value= LoginOperate.getLoginName(testdata.get("username"), testdata.get("password"));
		assertUtils.checkStringContains(value,testcases.get(0).getExpectedResult(), "测试失败");
	//	Assert.assertEquals(value.contains("admin"),true,"测试失败");
  }
	@Test
	public void failLogin() throws DocumentException {
		LoginOperate.setDriver(driver);
		String value = LoginOperate.loginFail("admin","123456");
		assertUtils.checkStringContains(value, "失败", "测试失败");
//	    Assert.assertEquals(value.contains("失败"), true,"测试失败");
	}
	@AfterMethod
	public void closeUrl() {
		driver.close();
	}
}
