
package pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_Page {
	
	//Methods to locate  Web Elements in the Home page which are used in the User stories 
	 public static WebElement SignIn_link(WebDriver driver, WebElement element){
	 
	    element = driver.findElement(By.linkText("Sign In"));
	 
	    return element;
	 
	    }
	 
	 public static WebElement SignOut_MyTask_Page_link(WebDriver driver,WebElement element){
	 
		 element = driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']"));
	 
	 return element;
	 

}
}
