package com.qainfotech.automation.tatoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FrameDungeon {
	
	WebDriver driver;
	
	
	public FrameDungeon(WebDriver driver) {
		this.driver = driver;
	}
	


	public void isFrameDungeonPAgeDisplayed() {
		Assert.assertTrue(driver.findElement(By.cssSelector(".page>h1")).getText().equals("Frame Dungeon"));
		
	}

	public void ClickProceedWithoutMAtchingColorLandsOnErrorPage() {
		driver.switchTo().frame(0);
		driver.findElement(By.linkText("Proceed")).click();
		Assert.assertTrue(driver.findElement(By.className("error")).getText().equals("Error"));
	}

	public void navigateBack() {
		driver.navigate().back();		
	}

	public DragAround MatchColorAndClickOnProceedLandsOnDragAroundPAge() {

		driver.switchTo().frame(0);
		WebElement box1 = driver.findElement(By.id("answer"));
		String Box1_color = box1.getAttribute("class");
		String Box2_color = "";
	   while(!Box1_color.equals(Box2_color)){
		  
		   driver.switchTo().defaultContent();
		    driver.switchTo().frame(0);
		    driver.findElement(By.cssSelector("a")).click();
		    driver.switchTo().frame(0);
		    Box2_color=driver.findElement(By.id("answer")).getAttribute("class");
		     }
	   driver.switchTo().defaultContent();
	   driver.switchTo().frame(0).findElement(By.linkText("Proceed")).click();
	   Assert.assertTrue(driver.findElement(By.cssSelector(".page>h1")).getText().equals("Drag Around"));
	   return new DragAround(driver);
	}

}
