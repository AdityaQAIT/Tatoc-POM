package com.qainfotech.automation.tatoc;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class PopupWindow {
	
	WebDriver driver;
	
	public PopupWindow(WebDriver driver) {
		this.driver = driver;
	}
	
	

	public void ClickProceedWithoutClickingPopupWindowLink() {
		driver.findElement(By.linkText("Proceed")).click();
		Assert.assertTrue(driver.findElement(By.className("error")).getText().equals("Error"));
		
	}

	public void isPopupWindowPAgeDisplayed() {
		Assert.assertTrue(driver.findElement(By.cssSelector(".page>h1")).getText().equals("Popup Windows"));

		
	}

	public void navigateBack() {
		driver.navigate().back();
		
	}

	public CookieHandling ClickProceedAfterFIllingCorrectVAluesInPopupWindow() {
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
		Assert.assertTrue(driver.findElement(By.cssSelector(".page>h1")).getText().equals("Cookie Handling"));

	    return new CookieHandling(driver);
	}
	

}
