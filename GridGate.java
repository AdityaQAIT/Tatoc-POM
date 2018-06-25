package com.qainfotech.automation.tatoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GridGate {
	
	WebDriver driver;
	
	public GridGate(WebDriver driver) {
		this.driver = driver;
	}
	
	public void isGridGatePAgeDisplayed() {
		Assert.assertTrue(driver.findElement(By.className("redbox")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.className("redbox")).isDisplayed());
		
		
	}

	public void ClickOnRedboxLandsOnErrorPage() {
		driver.findElement(By.className("redbox")).click();
		Assert.assertTrue(driver.findElement(By.className("error")).getText().equals("Error"));
	}
	

	public void navigateBAck() {
		driver.navigate().back();
		
	}

	public FrameDungeon ClickOnGreenBoxLandsOnFrameDungeonPage() {
	driver.findElement(By.className("greenbox")).click();
	Assert.assertTrue(driver.findElement(By.cssSelector(".page>h1")).getText().equals("Frame Dungeon"));
	return new FrameDungeon(driver);
		
	}
	

}
