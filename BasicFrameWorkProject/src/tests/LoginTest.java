package tests;

import org.testng.annotations.Test;

import data.DataFile;
import pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

		
public class LoginTest {
   
	WebDriver driver;
	LoginPage lp = new LoginPage();
	DataFile df = new DataFile();
			
	@BeforeMethod
	public void beforeMethod() {
	  lp.OpenBrowser();
	  lp.OpenLoginPage();
  }
	
  @AfterMethod
  public void afterMethod() {
	  lp.CloseBrowser();
  }

  @Test (priority = 1)
  public void loginWithWrongEmailPasswordTest() throws InterruptedException {
	  	lp.Login(df.Email, df.Password);
	   	String expecteErr = df.GlobalErr;
	   	String actualErr = lp.ReadGlobalErr();
		Assert.assertEquals(actualErr, expecteErr);
  }

	@Test (priority = 2)
	public void loginWithEmptyEmailTest() throws InterruptedException {
		lp.Login("", df.Password);		  	  
		String expecteErr = df.EmptyEmailErr;
		String actualErr = lp.ReadEmptyEmailErr();
		Assert.assertEquals(actualErr, expecteErr);
	}

	@Test (priority = 3)
	public void loginWithEmptyPasswordTest() throws InterruptedException {
		lp.Login(df.Email, "");	  
		String expecteErr = df.EmptyPasswordErr;
		String actualErr = lp.ReadPasswordErr();	  
		Assert.assertEquals(actualErr, expecteErr);
	}
	
}