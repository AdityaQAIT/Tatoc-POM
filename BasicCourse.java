package com.qainfotech.automation.tatoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BasicCourse {
	
	WebDriver driver;
	
	public BasicCourse(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void IsBasicPageDisplayed() {
		Assert.assertTrue(driver.findElement(By.linkText("Basic Course")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.linkText("Advanced Course")).isDisplayed());
	}
	
	public GridGate isClickOnBAsicCourseWorking()
	{
		driver.findElement(By.linkText("Basic Course")).click();
		Assert.assertTrue(driver.findElement(By.className("greenbox")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.className("redbox")).isDisplayed());
		return new GridGate(driver);
	}
	
	
	
	

}
