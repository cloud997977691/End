/**
 * author: cloud
 */
package com.end.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

/**
 * @author cloud
 *	@date 	2017年10月22日 
 */
public class RetryListener implements  IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass,
			Constructor testConstructor, Method testMethod) {
		IRetryAnalyzer retry = annotation.getRetryAnalyzer();
		if(retry == null){
			annotation.setRetryAnalyzer(TestngRetry.class);
		}
	}
		
}
