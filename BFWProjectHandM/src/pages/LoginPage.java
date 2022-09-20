package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver;

//WebElement Email = driver.findElement(By.xpath("//input[@placeholder='Email address']"));
//WebElement Password = driver.findElement(By.xpath("//input[@placeholder='Password']"));

@FindBy(xpath = "//input[@placeholder='Email address']")
public WebElement Email;

@FindBy(xpath = "//input[@placeholder='Password']")
public WebElement Password;

@FindBy(xpath = "//input[@value='SIGN IN']")
public WebElement SignIn;

@FindBy(xpath = "//li[contains(text(),'We are unable to connect to our servers right now.')]")
public WebElement LoginError;

@FindBy(xpath = "//div[@class='error'][contains(text(),'Please enter a password.')]")
public WebElement PasswordError;

@FindBy(xpath = "//div[@class='error'][contains(text(),'Please enter a valid email address.')]")
public WebElement EmailError;

	public void OpenBrowser() throws IOException {
		FileInputStream f = new FileInputStream("C:\\Testing\\porp.Properties");
		Properties prop = new Properties();
		prop.load(f);
		
		String browser = prop.getProperty("browser");
		//String browser = "Chrome"; // this will run all test on chrome
		
		if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver(); 
		}else if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver(); 
		}else {
			System.setProperty("webdriver.safari.driver", "C:\\SeleniumJars\\safaridriver.exe");
			driver = new SafariDriver(); 
		}
	PageFactory.initElements(driver, this);
	}
	public void OpenLoginPage() {
		driver.get("https://www.nike.com/ca/member/profile/login?continueUrl=https://www.nike.com/ca/");
	  }
	
	public void CloseBrowser() {
		  driver.quit();
	  }
	
	public void Login(String a, String b) throws InterruptedException {
		Thread.sleep(4000);
		 Email.sendKeys(a);
		 Password.sendKeys(b);
		 SignIn.click();
		  Thread.sleep(4000);
	}
	
	public String LoginError() {
		String actualErr = LoginError.getText();
		  System.out.println(actualErr);
		return actualErr;
	}
	
	public String PasswordError() {
		String actualErr = PasswordError.getText();
		  System.out.println(actualErr);
		return actualErr;
	}
	
	public String EmailError() {
		String actualErr = EmailError.getText();
		  System.out.println(actualErr);
		return actualErr;
		
	}
	
}
