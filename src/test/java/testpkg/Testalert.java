package testpkg;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import basepkg.Baseclassopenherbals;
import pagepkg.Alertpage;


public class Testalert extends Baseclassopenherbals{
	

	@Test(priority = 1)
	public void verifyAddingWshlist()
	{
		Alertpage objAdWish = new Alertpage(driver);
		objAdWish.addToWishList();
	}
	
	@Test(priority = 2)
	public void verifyWishlistItem()
	{
		Alertpage objItemWshList = new Alertpage(driver);
		objItemWshList.checkWishlist();
	}
	
	@Test(priority = 3)
	public void verifyAlerthandling()
	{
		Alertpage objAlrt = new Alertpage(driver);
		objAlrt.handlingAlertWishlist();
	}
	
}
