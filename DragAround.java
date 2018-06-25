package com.qainfotech.automation.tatoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DragAround {
	
	WebDriver driver;
	
	public DragAround(WebDriver driver) {
		this.driver = driver;
	}
	
	

	public void ClickProceedWithoutDraggingTheBoxLandsOnErrorPage() {
		driver.findElement(By.linkText("Proceed")).click();
		Assert.assertTrue(driver.findElement(By.className("error")).getText().equals("Error"));
		
	}

	public void isDragAroundPageDisplayed() {
		   Assert.assertTrue(driver.findElement(By.cssSelector(".page>h1")).getText().equals("Drag Around"));
	}

	public void navigateBack() {
		driver.navigate().back();
		
	}

	public PopupWindow ProceedAfterDragAndDropLAndsOnPopupWindowPage() {
		WebElement dragbox = driver.findElement(By.id("dragbox"));
		WebElement dropbox = driver.findElement(By.id("dropbox"));
		Actions actions  = new Actions(driver);
		actions.dragAndDrop(dragbox, dropbox).build().perform();
		driver.findElement(By.linkText("Proceed")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector(".page>h1")).getText().equals("Popup Windows"));
		return new PopupWindow(driver);
	}
	
	

}
