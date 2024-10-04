package basepkg;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class Baseclassopenherbals {

	public static WebDriver driver;
	String baseUrl = "https://rishiherbalindia.linker.store/";
	
	@BeforeClass
	public void setUp()      //open the chroem browser,open website rishiherbals,maximise the webpage opened
	{
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
}
