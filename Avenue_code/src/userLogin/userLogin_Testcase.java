package userLogin;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobject.Home_Page;
import pageobject.SignIn_Page;

//Initiating testcases getting the Home page and signing in successfully
public class userLogin_Testcase {
	public void begin_Todo(WebDriver driver,By by, WebElement element) throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		driver.get("http://qa-test.avenuecode.com/"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		driver.get("http://qa-test.avenuecode.com/");
		Home_Page.SignIn_link(driver,element).click();
		SignIn_Page.Email_Txtbx(driver,element).sendKeys("test4expert@gmail.com");
		SignIn_Page.Password_txtbx(driver,element).sendKeys("achieve123");
		SignIn_Page.SignIn_btn(driver,element).click();
		Thread.sleep(2000);
		System.out.println(" Signed in  Successfully");	
		
	  
	}

}
