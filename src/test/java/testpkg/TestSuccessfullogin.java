package testpkg;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import basepkg.Baseclassopenherbals;
import pagepkg.Successfullogin;

public class TestSuccessfullogin extends Baseclassopenherbals{

	
	@Test(priority = 1)
	public void slcLogin() throws InterruptedException
	{
		Successfullogin objSlcLgn = new Successfullogin(driver);
		System.out.println("login click");
		objSlcLgn.getLogin();
		
		objSlcLgn.setValues("aryageorge1@yahoo.com", "AryaGeorge@123");
		objSlcLgn.clickLogin();
	}
	
	@Test(priority = 2)
	public void productToCart()
	{
		Successfullogin objPrdctCart = new Successfullogin(driver);
		objPrdctCart.selectItem();
	}
	
	@Test(priority = 3)
	public void verifyCheckout()
	{
		Successfullogin objCheckout = new Successfullogin(driver);
		objCheckout.proceedToCheckout();
	}
	
	@Test(priority = 4)
	public void verifyFillForm()
	{
		Successfullogin objFormFill = new Successfullogin(driver);
		objFormFill.fillFormCheckOut();
	}
	
	@Test(priority = 5)
	public void verfiyByScrShot() throws IOException
	{
		Successfullogin objFormScrshot = new Successfullogin(driver);
		objFormScrshot.screenShotForm();
	}
	
}
