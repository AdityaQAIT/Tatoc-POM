package com.qainfotech.automation.tatoc;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class CookieHandling {
	
	WebDriver driver;
	
	public CookieHandling(WebDriver driver)
	{
		this.driver = driver;
	}
	
	

	public void isCookieHandlingPAgeDisplayed() {
		Assert.assertTrue(driver.findElement(By.cssSelector(".page>h1")).getText().equals("Cookie Handling"));
		
		
	}

	public void ClickProdeedWithoutgeneratingTakenLAndsOnErrorpage() {
		driver.findElement(By.linkText("Proceed")).click();
		Assert.assertTrue(driver.findElement(By.className("error")).getText().equals("Error"));
		
	}

	public void navigateNack() {
		driver.navigate().back();
		
	}

	public void ClickProceedAfterGeneratingTaken() {
		 driver.findElement(By.linkText("Generate Token")).click();
		    String token_text = driver.findElement(By.id("token")).getText();
		    String token = token_text.substring(token_text.indexOf(":")+2);
		    Cookie cookie = new Cookie("Token",token);
		    driver.manage().addCookie(cookie);
		    driver.findElement(By.linkText("Proceed")).click();
		   Assert.assertTrue(driver.findElement(By.className("finish")).getText().equals("End"));
		
	}

}
