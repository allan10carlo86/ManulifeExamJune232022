package TestCases;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DataObjects.PageObject_Home;
import DataObjects.WebDriverClass;

public class TESTCASE1_Login extends WebDriverClass{

	WebDriver driver;
	WebDriverWait wait;
	PageObject_Home homePage;
	Actions actions;
	
	@Before
	public void before() throws IOException {
		this.driver = super.initializeWebDriver(this.driver);
		this.wait = super.initializeWebDriverWait(this.driver);
		this.actions = super.initializeActions(this.driver);
		super.openWindow(this.driver, super.getValueFromExcel("01_URL", "URL", "login"));
		homePage = new PageObject_Home();
	}
	
	@Test
	public void main() throws IOException {
		homePage.clickSearch(this.driver,this.wait,this.actions);
		homePage.enterInSearchBar(driver, wait, actions, "products");
		homePage.enterPage(driver, wait, actions);
		homePage.validateNumberOfResults(driver,wait,actions);
		homePage.clickManulifeMove(this.driver,this.wait,this.actions,"ManulifeMOVE");
		homePage.clickLanguageStatusBar(this.driver,this.wait,this.actions);
		homePage.validateMoveText(this.driver,this.wait,this.actions);
		
	}	
	
	@After
	public void close() 
	{
		super.closeWindow(this.driver);
	}
}

