package com.qainfotech.automation.tatoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicCourse {
	
	WebDriver driver;
	
	public BasicCourse(WebDriver driver) {
		this.driver = driver;
		
	}
	
	
	public GridGate isClickOnBasicCourseWorking() {
		driver.findElement(By.linkText("Basic Course")).click();
		return new GridGate(driver);
	}
	
	public boolean IsBasicCoursePAge() {
		return driver.getCurrentUrl().equals("http://10.0.1.86/tatoc");
		
	}
	
	public boolean isErrorByClickingonAdvanceCourseLink() {
		
		driver.findElement(By.linkText("Advanced Course")).click();
		String url = driver.getCurrentUrl();
		driver.navigate().back();
		return url.equals("http://10.0.1.86/tatoc/advanced/hover/menu");
		
	}

}
