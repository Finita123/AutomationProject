package testpkg;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import basepkg.Baseclassopenherbals;
import pagepkg.Homepage;

public class Testsbasicafterlogin extends Baseclassopenherbals{

	@Test(priority = 1)
	public void verifyTitle()
	{
		Homepage hp = new Homepage(driver);
		hp.getTitleRishiHerbals();
	}
	
	@Test(priority = 2)
	public void verifyLogo()
	{
		Homepage hpObj = new Homepage(driver);
		if(hpObj.getLogoRishiHerbals())
		{
			System.out.println("Logo is present");
		}
		else
		{
			System.out.println("Logo not present");
		}
	}
	
	@Test(priority = 3)
	public void verifyTabs()
	{
		Homepage hpObjTabs = new Homepage(driver);
		hpObjTabs.checkTabs();
	}
	
	@Test(priority = 4)
	public void verifyEmptyCart()
	{
		Homepage hpObjEmpCart = new Homepage(driver);
		hpObjEmpCart.emptyCart();
	}
	
	@Test(priority = 5)
	public void verifySearchFunctionality() throws InterruptedException
	{
		Homepage hpObjSrch = new Homepage(driver);
		hpObjSrch.searchInput();
	}
	
	@Test(priority = 6)
	public void verifyUnavailableSearch() throws InterruptedException
	{
		Homepage hpObjUnSrch = new Homepage(driver);
		if(hpObjUnSrch.unAvailablePrdctSrch())
		{
			System.out.println("Unavailability is displayed in proper text");
		}
		else
		{
			System.out.println("Unavailable message is not present");
		}
	}
	
	@Test(priority = 7)
	public void verifyDropDown()
	{
		Homepage hpObjDrpDwn = new Homepage(driver);
		hpObjDrpDwn.dropDownSelection();
	}
	
}
