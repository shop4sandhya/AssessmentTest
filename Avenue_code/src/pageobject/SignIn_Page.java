package pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Methods to Locating Web Elements in the SignIn page which are used in the User stories
public class SignIn_Page {
	
	public static WebElement Email_Txtbx(WebDriver driver,WebElement element){
	    element = driver.findElement(By.xpath("//input[@id='user_email']"));
	return element;
	}
	 	 
	 public static WebElement Password_txtbx(WebDriver driver,WebElement element){	 
		 element = driver.findElement(By.xpath("//input[@id='user_password']"));	 
	 return element;
	 }
	 
	 public static WebElement SignIn_btn(WebDriver driver,WebElement element){	 
		 element = driver.findElement(By.xpath("//input[@name='commit']"));
		 
	 return element;
	 }
	 
	

}


