package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//	//Methods to locating Web Elements in the Model Dialog page which are used in the User stories 
public class ModelDialog_Page {
	
	 public static String readOnlytxt(WebDriver driver, By by){
	    	String readonlytxt = driver.findElement(By.xpath("//h3[@class='modal-title ng-binding']")).getText();
	    return  readonlytxt ;
	    }
	 
	 public static WebElement  enterSubTask(WebDriver driver, WebElement element){
		 WebElement element1 = driver.findElement(By.xpath("//input[@id='new_sub_task']"));
	    return   element1 ;
	    }
	 public static WebElement  enterSubTaskDate(WebDriver driver, WebElement element){
		 WebElement element1 = driver.findElement(By.xpath("//input[@id='dueDate']"));
	    return   element1 ;
	    }
	 public static WebElement  addSubTask(WebDriver driver, WebElement element){
		 WebElement element1 = driver.findElement(By.xpath("//button[@id='add-subtask']"));
	    return   element1 ;
	    }
	 public static List<WebElement> available_SubTaskRecords(WebDriver driver, WebElement element){	
	    	
			List<WebElement> subtasks=driver.findElements(By.xpath("//table[@class='table']/tbody/tr"));
	
	        
		return subtasks;
	    } 

}

