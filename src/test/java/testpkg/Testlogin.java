package testpkg;

import java.time.Duration;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import basepkg.Baseclassopenherbals;
import pagepkg.Loginpage;
import utilitiespkg.Excelutilities;


public class Testlogin extends Baseclassopenherbals {
	
	
	@Test(priority=1)
	public void selectLogin() throws InterruptedException
	{
		Loginpage lpObj = new Loginpage(driver);
		lpObj.getLogin();
		//lpObj.setValues("aryageorge1@yahoo.com", "AryaGeorge@123");
	}
	
	@Test(priority=2)
	public void loginUsingCredentials() throws InterruptedException
	{
		Loginpage lpO = new Loginpage(driver);
		String xl = "C:\\Users\\LENOVO\\Documents\\Finita_Docs\\Luminar\\datadriven\\Mainprojectherbalslogin.xlsx";
		String sheet = "Mainprojectherbalslogin";
		
		int rowCount = Excelutilities.getRowCount(xl, sheet);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println(rowCount);
		for(int i = 1; i<=rowCount; i++)
		{
			
			String userName = Excelutilities.getCellValue(xl, sheet, i, 0);
			System.out.println("Username = "+ userName);
			String passWord = Excelutilities.getCellValue(xl, sheet, i, 1);
			System.out.println("Password = "+ passWord);
			lpO.setValues(userName, passWord);
			Thread.sleep(2000);
			lpO.clickLogin();
			
		}
	}
	
	@Test(priority=3)
	public void validatingLogin() throws InterruptedException
	{
		Loginpage lpvalid = new Loginpage(driver);
		if(lpvalid.logOutVisibleValidation())
		{
			System.out.println("Logout is visible : Valid login");
		}
		else
		{
			System.out.println("Logout is not visible : Invalid login");
		}
	}

}
