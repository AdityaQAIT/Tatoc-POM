package com.qainfotech.automation.tatoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameDungeon {
	
	WebDriver driver;
	
	
	public FrameDungeon(WebDriver driver) {
		this.driver = driver;
	}
	
	public DragAround MatvhtheColorInBoxes() {
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
	   return new DragAround(driver);
	}
	
	
	public Boolean isFrameDungeonPage() {
		
		return driver.getCurrentUrl().equals("http://10.0.1.86/tatoc/basic/frame/dungeon");
	}

}
