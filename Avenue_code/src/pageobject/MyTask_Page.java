package pageobject;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyTask_Page {

//Method to locate MyTask link in the home page	
	public static WebElement myTask_Link(WebDriver driver,WebElement element){
	    element = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/a[1]"));
	    return element;
	}
	
	public static boolean isMyTask_LinkPresent(By by){	  
	    try {
	    	By.xpath("//ul[@class='nav navbar-nav']/li[2]/a");
	    	return true;
	    } catch (NoSuchElementException e) {
	    	System.out.println ("My Task Link not present on navigation bar" +e.getMessage());
	    	return false;
	    }
	  
	}
	
	
}


