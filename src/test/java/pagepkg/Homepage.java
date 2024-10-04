package pagepkg;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Homepage {

	WebDriver driver;
	@FindBy(id = "logo")
	WebElement logo;
	String[] tabLocators = {
            "//*[@id=\"menu\"]/ul/li[1]/a",   
            "//*[@id=\"menu\"]/ul/li[2]/a",
            "//*[@id=\"menu\"]/ul/li[3]/a",
            "//*[@id=\"menu\"]/ul/li[4]/a",
            "//*[@id=\"menu\"]/ul/li[5]/a",
            "//*[@id=\"menu\"]/ul/li[6]/a",
            "//*[@id=\"menu\"]/ul/li[7]/a",
            "//*[@id=\"menu\"]/ul/li[8]/a",
            "//*[@id=\"menu\"]/ul/li[9]/span/a"
        };
	@FindBy(id = "cart-btn-toggle")
	WebElement cartButton;
	@FindBy(xpath = "//*[@id=\"cart-dropdown\"]/div/p")
	WebElement placeholderMsg;
	@FindBy(name = "query")
	WebElement searchInput;
	@FindBy(xpath = "//*[@id=\"content\"]/p")
	WebElement unAvailable;
	@FindBy(xpath = "//*[@id=\"input-sort\"]")
	WebElement sortBy;
	String searchText = "Baby products";
	String searchUnavailable = "Mobilephone";
	
	
	
	public Homepage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void getTitleRishiHerbals()//Title verification
	{
		String expectedTitle = "Rishi Herbal India";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        System.out.println("Title verified: " + actualTitle);
	}
	
	public boolean getLogoRishiHerbals()//logo display verification
	{
		return logo.isDisplayed();	 
	}
	
	public void checkTabs()//check if all the main tabs are present in the main page
	{
		for (String locator : tabLocators) {
            List<WebElement> tabs = driver.findElements(By.xpath(locator));//iterating through the locators
            if (!tabs.isEmpty()) {
                System.out.println("Tab with locator " + locator + " is present.");
            } else {
                System.out.println("Tab with locator " + locator + " is NOT present.");
            }
        }
	}
	
	public void emptyCart()//check message is displaying for an empty cart
	{
		cartButton.click();
		try { 
            if (placeholderMsg.isDisplayed()) {
                System.out.println("Placeholder message is displayed: " + placeholderMsg.getText());
            } else {
                System.out.println("Placeholder message is not displayed.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Placeholder message element not found.");
        }
	}
	
	//checking search functionality gives results by giving a random input, printing the text also
	public void searchInput() throws InterruptedException
	{
		searchInput.sendKeys(searchText);
		searchInput.submit();
		Thread.sleep(3000);
		List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='row row_category']"));
		if (!searchResults.isEmpty()) {
            System.out.println("Search results found.");
            for (WebElement result : searchResults) {
                System.out.println(result.getText());  // Print each result's text
            }
        } else {
            System.out.println("No search results found.");
        }
	}
	
	//checking the search functionality for a product not available in the site
	public boolean unAvailablePrdctSrch() throws InterruptedException
	{
		searchInput.clear();
		searchInput.sendKeys(searchUnavailable);
		searchInput.submit();
		Thread.sleep(3000);
		return unAvailable.isDisplayed();
	}
	
	//dropdown selection
	public void dropDownSelection()
	{
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.navigate().back();
		searchInput.clear();
		searchInput.sendKeys(searchText);
		Select prctDetails = new Select(sortBy);
		prctDetails.selectByValue("alphabet-desc");
	}
}
