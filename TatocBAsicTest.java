package com.qainfotech.automation.tatoc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TatocBAsicTest {
	

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
	
	
	@Test
	public void TestBasicPage() {
		basic.IsBasicPageDisplayed();
		gridgate = basic.isClickOnBAsicCourseWorking();
	}
	
	@Test(dependsOnMethods= {"TestBasicPage"})
	public void TestGridGate() {
		gridgate.isGridGatePAgeDisplayed();
		gridgate.ClickOnRedboxLandsOnErrorPage();
		gridgate.navigateBAck();
		framedungeon=gridgate.ClickOnGreenBoxLandsOnFrameDungeonPage();
	}
	
	@Test(dependsOnMethods= {"TestGridGate"}) 
	public void TestFrameDungeon() {
		framedungeon.isFrameDungeonPAgeDisplayed();
		framedungeon.ClickProceedWithoutMAtchingColorLandsOnErrorPage();
		framedungeon.navigateBack();
		dragaround=framedungeon.MatchColorAndClickOnProceedLandsOnDragAroundPAge();
		
	}
	
	@Test(dependsOnMethods= {"TestFrameDungeon"})
	public void TestDragAndDrop() {
		dragaround.isDragAroundPageDisplayed();
		dragaround.ClickProceedWithoutDraggingTheBoxLandsOnErrorPage();
		dragaround.navigateBack();
		popupwindow=dragaround.ProceedAfterDragAndDropLAndsOnPopupWindowPage();
	
	}
	
	@Test(dependsOnMethods= {"TestDragAndDrop"})
	public void TestPopupWindow() {
		popupwindow.isPopupWindowPAgeDisplayed();
		popupwindow.ClickProceedWithoutClickingPopupWindowLink();
		popupwindow.navigateBack();
		cookiehandling = popupwindow.ClickProceedAfterFIllingCorrectVAluesInPopupWindow(); 
		
	}
	
	@Test(dependsOnMethods= {"TestPopupWindow"})
	public void  TestCookieHAndling() {
		cookiehandling.isCookieHandlingPAgeDisplayed();
		cookiehandling.ClickProdeedWithoutgeneratingTakenLAndsOnErrorpage();
		cookiehandling.navigateNack();
		cookiehandling.ClickProceedAfterGeneratingTaken();
		
	}
	
	

}
