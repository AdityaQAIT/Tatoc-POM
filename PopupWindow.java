package com.qainfotech.automation.tatoc;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PopupWindow {
	
	WebDriver driver;
	
	public PopupWindow(WebDriver driver) {
		this.driver = driver;
	}
	
	public CookieHandling ClickOnPopupAndFilltheField() {
driver.findElement(By.linkText("Launch Popup Window")).click();
	    
	    String parentwindow = driver.getWindowHandle();
	    String subWindow = null;
	    Set<String> windows = driver.getWindowHandles();
	    Iterator itr = windows.iterator();
	    while(itr.hasNext()){
	    	subWindow = (String) itr.next();
	    }
	    driver.switchTo().window(subWindow);
	    driver.findElement(By.id("name")).sendKeys("Aditya");
	    driver.findElement(By.id("submit")).click();
	    driver.switchTo().window(parentwindow);
	    driver.findElement(By.linkText("Proceed")).click();
	    return new CookieHandling(driver);
	}
	
	public boolean isPopUpPage() {
		return driver.getCurrentUrl().equals("http://10.0.1.86/tatoc/basic/windows");
	}
	

}
