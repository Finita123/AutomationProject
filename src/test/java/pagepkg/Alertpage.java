package pagepkg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alertpage {

	WebDriver driver;
	@FindBy(xpath = "//*[@id=\"menu\"]/ul/li[4]/a")
	WebElement skinTab;
	@FindBy(xpath = "//*[@id=\"content\"]/div[3]/div[1]/div/div/div[1]/div/a")
	WebElement reqProduct;
	@FindBy(xpath = "//*[@id=\"prod_cont\"]/div/div[4]/button[1]")
	WebElement addWishBtn;
	@FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a")
	WebElement wishListChk;
	@FindBy(xpath = "//*[@id=\"content\"]")
	WebElement wishlistContainer;
	@FindBy(xpath = "//*[@id=\"content\"]/table/tbody/tr/td[5]/a")
	WebElement wislistRemove;
	
	public Alertpage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addToWishList()
	{
		skinTab.click();
		reqProduct.click();
		addWishBtn.click();
	}
	
	public void checkWishlist()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(wishListChk)).click();
		List<WebElement> wishlistItems = wishlistContainer.findElements(By.tagName("img"));
		if(wishlistItems.isEmpty())
		{
			System.out.println("Wishlist is empty");
		}
		else
		{
			System.out.println("Wishlist is not empty");
		}
	}
	
	public void handlingAlertWishlist()
	{
		wislistRemove.click();
		Alert a = driver.switchTo().alert();
		System.out.println(a.getText());
		a.accept();
	}
}
