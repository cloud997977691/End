/**
 * author: cloud
 */
package com.end.utils;

import java.util.Iterator;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * @author cloud
 *	@date 	2017年10月22日 
 */
public class TestNGListener extends TestListenerAdapter {
	Log log = new Log(TestNGListener.class);
	// testng 初始化
	@Override
	public void onStart(ITestContext testContext){
		log.info("测试初始化");
		super.onStart(testContext);
	}
	// case开始
	@Override
	public void onTestStart(ITestResult tr){
		log.info("【"+tr.getName()+"】测试用例开始执行");
		super.onTestStart(tr);
	}
	@Override
	public void onTestSuccess(ITestResult tr){
		log.info("【"+tr.getName()+"】测试用例执行成功");
		super.onTestSuccess(tr);	
	}
	@Override
	public void onTestFailure(ITestResult tr){
		log.info("【"+tr.getName()+"】测试用例执行失败");
		super.onTestFailure(tr);	
	}
	@Override
	public void onTestSkipped(ITestResult tr){
		log.info("【"+tr.getName()+"】测试用例执行跳过");
		super.onTestSkipped(tr);	
	}
	
	
	public  void onFinish(ITestContext testContext){
		Iterator<ITestResult> listOfFailedTests =
		testContext.getFailedTests().getAllResults().iterator();
		while(listOfFailedTests.hasNext()){
			ITestResult failedTest = listOfFailedTests.next();
			ITestNGMethod method =failedTest.getMethod();
			if(testContext.getFailedTests().getResults(method).size()>1){
				listOfFailedTests.remove();
			}else{
				if(testContext.getPassedTests().getResults(method).size()>0){
					listOfFailedTests.remove();
				}
			}
		}
	}
	
	
	
}
