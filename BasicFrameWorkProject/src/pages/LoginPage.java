package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPage {
	WebDriver driver;
	
	public void OpenBrowser() {
		System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	public void CloseBrowser() {
		driver.quit();
	}
	
	public void OpenLoginPage() {
		driver.get("https://authentication.td.com/uap-ui/?consumer=easyweb&locale=en_CA#/uap/login");
	}
	
	public void Login(String a, String b) throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.id("username")).sendKeys(a);
		driver.findElement(By.id("uapPassword")).sendKeys(b);
		driver.findElement(By.xpath("//button[@class='btn btn-block td-button-secondary']")).click(); //This should be working, but something's gone wrong. Please try again soon. [500.GENERIC] 
		Thread.sleep(4000); 
	}
	
	public String ReadGlobalErr() {
		String actualErr = driver.findElement(By.id("error")).getText();
		System.out.println(actualErr);
		return actualErr;
	}
	
	public String ReadEmptyEmailErr() {
		String actualErr = driver.findElement(By.xpath("//span[contains(text(),'Please enter your Username or Access Card number.')]")).getText();
		System.out.println(actualErr);
		return actualErr;
	}
	
	public String ReadPasswordErr() {
		String actualErr = driver.findElement(By.xpath("//span[contains(text(),'Please enter your password')]")).getText();
		System.out.println(actualErr);
		return actualErr;
	}

}