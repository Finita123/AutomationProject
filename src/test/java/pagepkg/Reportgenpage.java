package pagepkg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reportgenpage {

	WebDriver driver;
	@FindBy(xpath = "//*[@id=\"menu\"]/ul/li[5]/a")
	WebElement personalTab;
	@FindBy(xpath = "//*[@id=\"filterForm\"]/div[2]/div[2]/div[1]")
	WebElement txtPrdctAvailabilty;
	@FindBy(xpath = "//*[@id=\"outOfStockFilter\"]")
	WebElement chkboxInstock;
	
	public Reportgenpage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectPersonalTab()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(personalTab)).click();
	}
	
	public void textProductAvailability()
	{
		String actProductAvailTxt = txtPrdctAvailabilty.getText();
		String expProductAvailTxt = "PRODUCT AVAILABILITY";
		if(actProductAvailTxt.equals(expProductAvailTxt))
		{
			System.out.println("Proper Text Displayed");
		}
		else
		{
			System.out.println("Improper text displayed");
		}
	}
	
	public void chckBoxClick()
	{
		chkboxInstock.click();
	}
}
