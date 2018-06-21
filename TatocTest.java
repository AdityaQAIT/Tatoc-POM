package com.qainfotech.automation.tatoc;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TatocTest {

	WebDriver driver;
	BasicCourse basic;
	GridGate gridgate;
	FrameDungeon framedungeon;
	DragAround dragaround;
	PopupWindow popupwindow;
	CookieHandling cookiehandling;
	
	@BeforeClass
	public void Launch_driver() {
		System.setProperty("webdriver.chrome.driver","//home//qainfotech//Downloads//chromedriver");
		this.driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		basic = new BasicCourse(driver);
	}
	
	@Test()
	public void NotClickOnBasicCourse() {
		Assert.assertTrue(basic.ClickonAdvanceCourseLink());
	}
	
	@Test(dependsOnMethods= {"NotClickOnBasicCourse"})
	public void ClickOnBasicCourse() {
		gridgate = basic.isClickOnBasicCourseWorking();
        Assert.assertFalse(basic.IsBasicCoursePAge());
	}
	
	@Test(dependsOnMethods= {"ClickOnBasicCourse"})
	public void ClickOnRedBoxinGridGate() {
		Assert.assertTrue(gridgate.ClickOnRedbox());
	}
	
	@Test(dependsOnMethods= {"ClickOnRedBoxinGridGate"})
	public void ClickOnGreenboxInGridGAte() {
		framedungeon = gridgate.ClickOnGreenBox();
		Assert.assertFalse(gridgate.isGridGatePage());
		
	}
	
	@Test(dependsOnMethods= {"ClickOnGreenboxInGridGAte"})
	public void MatchColorInBoxes() {
		dragaround = framedungeon.MatvhtheColorInBoxes();
		Assert.assertFalse(framedungeon.isFrameDungeonPage());
	}
	
	@Test(dependsOnMethods= {"MatchColorInBoxes"})
	public void DragAndDropBoxToCorrectDropbox() {
		popupwindow  = dragaround.DragAndDropBox();
		Assert.assertFalse(dragaround.isDragAroundPage());
	}
	
	@Test(dependsOnMethods= {"DragAndDropBoxToCorrectDropbox"})
	public void ClickOnPopupLinkAndFillTheName() {
		cookiehandling = popupwindow.ClickOnPopupAndFilltheField();
		Assert.assertFalse(popupwindow.isPopUpPage());
		
	}
	
	@Test(dependsOnMethods= {"ClickOnPopupLinkAndFillTheName"})
	public void CreateCookieOnpage() {
		Assert.assertTrue(cookiehandling.isCookieSuccessfullyAdded());
	}
	
	
	
	
	
	

}
