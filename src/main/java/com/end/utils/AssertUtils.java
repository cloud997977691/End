package com.end.utils;

//import static org.testng.Assert.assertEquals;

import org.testng.Assert;

public class AssertUtils {
		Log log = new Log(AssertUtils.class);
		AssertUtils assertUtils ;
		public void checkIntNum(int actual,int expected,String... com){
			try{
				Assert.assertEquals(actual, expected);
				log.info("整数断言  "+"实际结果："+actual+"预期结果："+expected);
		//	assertUtils.checkIntNum(actual, expected);
			}catch(AssertionError e){
				log.info("整数断言  "+"实际结果："+actual+"预期结果："+expected);
				Assert.fail("断言失败");
			}
			}
		public void checkString(String actual,String expected,String... com){
			try{
				Assert.assertEquals(actual, expected);
				log.info("字符串断言  "+"实际结果："+actual+"预期结果："+expected);
				}catch(AssertionError e){
					log.info("字符串断言  "+"实际结果："+actual+"预期结果："+expected);
					Assert.fail("断言失败");
				}
		}
		public  void checkStringContains(String actual,String expected,String... com){
			try{
				Assert.assertEquals(true, actual.contains(expected));
				log.info("包含断言  "+"实际结果："+actual+"预期结果："+expected);
				}catch(AssertionError e){
					log.info("包含断言  "+"实际结果："+actual+"预期结果："+expected);
					Assert.fail("断言失败");
				}
		}
		
		public void checkNotNull(Object actual,String... com){
			try{
				Assert.assertNotNull(actual);
				log.info("非空断言  "+"结果包含："+actual);
				}catch(AssertionError e){
					log.info("非空断言  "+"结果包含："+actual);
					Assert.fail("断言失败");
				}
		}
		
}
