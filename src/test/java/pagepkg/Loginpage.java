package pagepkg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loginpage {

	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[1]/a/i")
	WebElement myAccDrpDwn;
	@FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[1]/ul/li[5]/a")
	WebElement logIn;
	@FindBy(xpath = "//*[@id=\"cont-login-with-email\"]/form/div[1]/input")
	WebElement email;
	@FindBy(xpath = "//*[@id=\"cont-login-with-email\"]/form/div[2]/input")
	WebElement password;
	@FindBy(xpath = "//*[@id=\"cont-login-with-email\"]/form/button[1]")
	WebElement loginButton;
	@FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[1]/ul/li[3]/a")
	WebElement logOutButton;
	
	public Loginpage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void getLogin() throws InterruptedException //Traverse through MyAccount to get Login click
	{
		myAccDrpDwn.click();
		Thread.sleep(2000);
		logIn.click();
	}
	
	public void setValues(String eMail, String passWrd) //Passing values to email and password
	{
		email.clear();
		email.sendKeys(eMail);
		password.clear();
		password.sendKeys(passWrd);
	}
	
	public void clickLogin()
	{
		loginButton.click();
	}
	
	public boolean logOutVisibleValidation() throws InterruptedException
	{
		Thread.sleep(3000);
		myAccDrpDwn.click();
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(logOutButton));
			return true;
		}
		catch(Exception e)
		{
			 return false;
		}
	}
}
