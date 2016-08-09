package pageobject;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

// Methods to Locating Web Elements in the MyTask page which are used in the User stories 
public class ToDo_Task_Page {
	public static int count_Records(WebDriver driver){	
		List<WebElement> records = driver.findElements(By.xpath("//table[@class='table']/tbody/tr"));
		return records.size();
		}
	
    public static String  Logged_User_Message(WebDriver driver){
    	String user_message = driver.findElement(By.tagName("h1")).getText();
    	System.out.println("In Logged_User_Message : " + user_message);
    return user_message;
    }
    
    public static String  Logged_Welcome_User(WebDriver driver){
    	String user_name = driver.findElement(By.xpath("//a[@href='#']")).getText();
    	int end = user_name.indexOf("!");
		String withWelcome = user_name.substring(0,end);
		int pos= user_name.indexOf(",");
		String user= withWelcome.substring(pos+2,end);
    return user;
    }
    
    public static WebElement newTaskEntryTest(WebDriver driver, WebElement element){
   	   element = driver.findElement(By.xpath("//form[@name='task_form']/div[2]/input"));
	return element;
	}
   
    public static WebElement newTaskAdd(WebDriver driver, WebElement element){
      	element = driver.findElement(By.xpath("//span[@class='input-group-addon glyphicon glyphicon-plus']"));
	return element;
    }
    
    public static List<String> available_Records(WebDriver driver, WebElement element,List<String> taskNames){	
    	
		List<WebElement> tasks=driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td[2]/a"));
			if (tasks != null ){
				for  (int i=1; i>=tasks.size(); i++) {
					element=tasks.get(i);
					String taskNam=element.getText();
					  taskNames.add(taskNam);
					}
	
	
	         }
	return taskNames;
    } 
    public static boolean  manageSubtasksLink_Present(By by){	  
	    try{
	    	By.xpath("//button[@class='btn btn-xs btn-primary ng-binding']");
	    	return true;
	    } catch (NoSuchElementException e) {
	    	System.out.println ("Manage Subtasks Task Link not present ");
	    	return false;
	    }
    }
   	  
    public static String manageSubTasks_Text(WebDriver driver){
      	String  subtasks_string= driver.findElement(By.xpath("//button[@class='btn btn-xs btn-primary ng-binding']")).getText();
      	return subtasks_string;
    }
        
    public static WebElement managesubTask_Link(WebDriver driver,WebElement element){
	    element = driver.findElement(By.xpath("//button[@class='btn btn-xs btn-primary ng-binding']"));
	    return element;
	}
   
	
}
