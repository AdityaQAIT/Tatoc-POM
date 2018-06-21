package com.qainfotech.automation.tatoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GridGate {
	
	WebDriver driver;
	
	public GridGate(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public FrameDungeon ClickOnGreenBox() {
		driver.findElement(By.className("greenbox")).click();
		return new FrameDungeon(driver);

	}
	
	public boolean isGridGatePage() {
		return driver.getCurrentUrl().equals("http://10.0.1.86/tatoc/basic/grid/gate");
	}
	
	public boolean ClickOnRedbox() {
		driver.findElement(By.className("redbox")).click();
		String url = driver.getCurrentUrl();
		driver.navigate().back();
		return url.equals("http://10.0.1.86/tatoc/error");
		
	}
	

}
