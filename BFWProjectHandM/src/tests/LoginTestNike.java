package tests;

import org.testng.annotations.Test;
import data.DataFile;
import pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTestNike {
  WebDriver driver;
  LoginPage lp = new LoginPage();
  DataFile df = new DataFile();
  	  
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  lp.OpenBrowser();
	  lp.OpenLoginPage();
  }

  @AfterMethod
  public void afterMethod() {
	  lp.CloseBrowser();
  }
  
  @Test (priority = 1)
  public void loginwithwrongemailpassword() throws InterruptedException {
	  lp.Login(df.Email, df.Password);
	  String expecteErr = df.LoginError;
	  String actualErr = lp.LoginError();
	  Assert.assertEquals(actualErr, expecteErr);
  }
  
  @Test (priority = 2)
  public void loginwithoutpassword() throws InterruptedException {
	  lp.Login(df.Email, "");
	  String expecteErr = df.PasswordError;
	  String actualErr = lp.PasswordError();
	  Assert.assertEquals(actualErr, expecteErr);
  }

  @Test (priority = 3)
  public void loginwithoutemail() throws InterruptedException {
	  lp.Login("", df.Password);
	  String expecteErr = df.EmailError;
	  String actualErr = lp.EmailError();
	  Assert.assertEquals(actualErr, expecteErr);
  }
  
}
