package pagepkg;

import static org.testng.Assert.assertNotNull;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Securitypage {

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
	
	public Securitypage(WebDriver driver)
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
	
	
	public void printSecureAllCookies()//Print all Cookies
	{
		Set<Cookie> cookies = driver.manage().getCookies();
        // Assert that cookies are not null
        assertNotNull(cookies);
        System.out.println("Number of cookies: " + cookies.size());
        int countofSecureCookie = 0;
        // Print cookie details and checking secure cookies or not
        for (Cookie cookie : cookies) {
        	
            System.out.println("Cookie Name: " + cookie.getName());
            System.out.println("Cookie Value: " + cookie.getValue());
            System.out.println("Cookie Domain: " + cookie.getDomain());
            System.out.println("Cookie Path: " + cookie.getPath());
            System.out.println("Cookie Expiry: " + cookie.getExpiry());
            System.out.println("Is Secure: " + cookie.isSecure());
            if(cookie.isSecure())
            {
            	System.out.println(cookie.getName() + "is secure");
            	countofSecureCookie++;
            }
            System.out.println("Is HttpOnly: " + cookie.isHttpOnly()); 
        }
        System.out.println("Total number of secured cookies are" + countofSecureCookie);
        
        
	}
	
}
