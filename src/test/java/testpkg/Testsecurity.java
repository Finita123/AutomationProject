package testpkg;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import basepkg.Baseclassopenherbals;
import pagepkg.Securitypage;
import pagepkg.Successfullogin;

public class Testsecurity extends Baseclassopenherbals{

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
	public void verifyPrintCookies()
	{
		Securitypage objPrintCookies = new Securitypage(driver);
		objPrintCookies.printSecureAllCookies();
	}
	
}
