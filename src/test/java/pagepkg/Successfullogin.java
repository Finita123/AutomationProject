package pagepkg;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Successfullogin {

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
	@FindBy(xpath = "//*[@id=\"menu\"]/ul/li[9]/a")
	WebElement homeButton;
	@FindBy(xpath = "//*[@id=\"content\"]/div[3]/div[2]/div/div/div[1]/div/a")
	WebElement reqProduct;
	@FindBy(xpath = "//*[@id=\"button-cart\"]")
	WebElement addCartBtn;
	String expName = "ADD TO CART";
	@FindBy(xpath = "//*[@id=\"cart-btn-toggle\"]")
	WebElement cartBtn;
	@FindBy(xpath = "//*[@id=\"cart-dropdown\"]/div/div/div[2]/a")
	WebElement checkoutBtn;
	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div[3]/div/a[1]")
	WebElement prcdChckutBtn;
	@FindBy(xpath = "//*[@id=\"deliveryAddress\"]/div/div[1]/div[1]/div/input")
	WebElement formFname;
	@FindBy(xpath = "//*[@id=\"deliveryAddress\"]/div/div[1]/div[2]/div/input")
	WebElement formLname;
	@FindBy(xpath = "//*[@id=\"deliveryAddress\"]/div/div[2]/div/div/input")
	WebElement formLoc;
	
	
	public Successfullogin(WebDriver driver)
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
	
	public void setValues(String eMail, String passWrd) throws InterruptedException //Passing values to email and password
	{
		Thread.sleep(3000);
		email.clear();
		email.sendKeys(eMail);
		password.clear();
		password.sendKeys(passWrd);
	}
	
	public void clickLogin()
	{
		loginButton.click();
	}
	
	public void selectItem()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(homeButton)).click();
		wait.until(ExpectedConditions.elementToBeClickable(reqProduct)).click();
		getCartBtnName(expName);
		addCartBtn.click();
	}
	
	public boolean getCartBtnName(String expName)
	{
		try
		{
			String actName = addCartBtn.getText();
			Assert.assertEquals(actName, expName,"Add to cart:Name Not Verified");
			return true;
		}
		catch(AssertionError e)
		{
			System.out.println("Assertion failed: " + e.getMessage());
		    return false;
		}
	}
	
	public void proceedToCheckout()
	{
		cartBtn.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
		prcdChckutBtn.click();
	}
	
	public void fillFormCheckOut()
	{
		formFname.sendKeys("Arya");
		formLname.sendKeys("George");
		formLoc.sendKeys("Thrissur");
	}
	
	public void screenShotForm() throws IOException
	{
		File formFillScreen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(formFillScreen, new File("./Screenshots/screenshotbutton.png"));
	}
}
