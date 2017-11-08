package com.end.uiframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseUtils {
		private Actions action ;
		public MouseUtils(WebDriver dr){
			action = new Actions(dr);
		}
		public void rightClick(WebElement e){
			action.contextClick(e).perform();
		}
		
		public void doubleClick(WebElement e){
			action.doubleClick(e).perform();
		}
		
}
