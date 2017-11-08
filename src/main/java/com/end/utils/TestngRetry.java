/**
 * author: cloud
 */
package com.end.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author cloud
 *	@date 	2017年10月22日 
 */
public  class TestngRetry implements IRetryAnalyzer{
		Log log = new Log(TestngRetry.class);
		private static int maxRetryCount = 2;
		private int retryCount = 1;
		@Override
		public boolean retry(ITestResult result) {	
			if(retryCount <= maxRetryCount){
				String message ="测试类：'" + this.getClass().getName()
						+"' 中的测试方法：'" + result.getName()+"'测试失败，请重试"
						+ retryCount + " 次";
				log.info(message);
				retryCount++;
				return true;
			}
			return false;
		}
				
}
