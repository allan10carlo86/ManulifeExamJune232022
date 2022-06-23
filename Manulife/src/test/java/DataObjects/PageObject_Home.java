package DataObjects;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Verify;
import org.junit.Assert;

public class PageObject_Home{

	//By field_search = By.xpath("//button[@class='cmp-header__nav-search-button']");
	By field_search = By.xpath("(//button//span[contains(text(),'Search')])[last()]");
	By input_search = By.xpath("//input[@class='cmp-search__field-input']");
	By strong_product = By.xpath("//strong[text()='products']");
	Double products2 = 2.00;
	Double numberOfResults = 17.00;
	By manulifeMOVE_SearchResult = By.xpath("//span[contains(text(),'About ManulifeMOVE  | ManulifeMOVE | Manulife HK')]");
	By languageID_Selection = By.id("cmp-header__nav-languages-title");
	By languageID_English_Selection = By.xpath("(//a[contains(text(),'English')])[2]");
	By moveUpto_String = By.xpath("//p[contains(text(),'MOVE up and step into a world of healthy living')]");
	
	public void clickSearch(WebDriver driver, WebDriverWait wait, Actions actions) {
		System.out.println("***** CLICK SEARCH START *****");
		wait.until(ExpectedConditions.visibilityOfElementLocated(field_search));
		actions.click(driver.findElement(field_search)).build().perform();
		System.out.println("***** CLICK SEARCH END *****");
	}
	
	public void enterInSearchBar(WebDriver driver, WebDriverWait wait, Actions actions, String input) {
		System.out.println("***** CLICK ENTER SEARCH BAR START *****");
		wait.until(ExpectedConditions.visibilityOfElementLocated(input_search));
		driver.findElement(input_search).sendKeys(input);
		System.out.println("***** CLICK ENTER SEARCH BAR END *****");
	}
	
	
	public void validateSearchModal(WebDriver driver, WebDriverWait wait, Actions actions, String input) {
		System.out.println("***** CLICK ENTER SEARCH BAR START *****");
		wait.until(ExpectedConditions.visibilityOfElementLocated(strong_product));
		double sizeOfStrongProduct = driver.findElements(strong_product).size();
		Assert.assertTrue(sizeOfStrongProduct==products2);
		System.out.println("***** CLICK ENTER SEARCH BAR END *****");
	}
	
	public void enterPage(WebDriver driver, WebDriverWait wait, Actions actions) {
		driver.findElement(input_search).sendKeys(Keys.ENTER);
	}
	
	public void validateNumberOfResults(WebDriver driver, WebDriverWait wait, Actions actions) {
		System.out.println("***** CLICK ENTER SEARCH BAR START *****");
		double numberOfResultsFromPage = driver.findElements(strong_product).size();
		Assert.assertTrue(numberOfResultsFromPage==numberOfResults);
		System.out.println("***** CLICK ENTER SEARCH BAR END *****");
	}
		
	public void clickManulifeMove(WebDriver driver, WebDriverWait wait, Actions actions, String input) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(manulifeMOVE_SearchResult));
		driver.findElement(manulifeMOVE_SearchResult).sendKeys(input);
	}
	
	public void clickLanguageStatusBar(WebDriver driver, WebDriverWait wait, Actions actions) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(languageID_Selection));
		actions.click(driver.findElement(languageID_Selection)).click(driver.findElement(languageID_English_Selection)).build().perform();
	}
	
	
	public void validateMoveText(WebDriver driver, WebDriverWait wait, Actions actions) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(languageID_Selection));
		String moveUpResults = driver.findElement(moveUpto_String).getText();
		boolean hasTheText  = moveUpResults.contains("MOVE up and step into a world of healthy living");
		Assert.assertEquals(hasTheText, "MOVE up and step into a world of healthy living");

	}
	
	

}
