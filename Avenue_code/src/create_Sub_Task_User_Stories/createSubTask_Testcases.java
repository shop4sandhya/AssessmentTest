package create_Sub_Task_User_Stories;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import userLogin.userLogin_Testcase;
import pageobject.Home_Page;
import pageobject.ModelDialog_Page;
import pageobject.MyTask_Page;
import pageobject.ToDo_Task_Page;


public class createSubTask_Testcases {
	public WebDriver driver;
	public static WebElement element = null;
	public By by;
	List<String> subtaskNames=null;
	
 //click MyTask Link to view the Tasks
	@Test(priority=1)
	  public void verify_Records() throws Exception{
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  MyTask_Page.myTask_Link(driver,element).click();
	}
//to check if Manage SubTask button is present
	@Test(priority=2)
	 public void verify_Manage_SubTasks_btn() {
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  ToDo_Task_Page.manageSubtasksLink_Present(by);
		  File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  try {
			FileUtils.copyFile(scrFile, new File("C:\\workspace\\Avenue_code\\ScreenShots\\MAnageTask_Button.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  System.out.println("Manage SubTask Button is Present");
	}
	
// To check if Manage subtask button shows the number of subtask created	
	@Test(priority=3)
	public void verify_Manage_SubTasks_Include_Number() throws Exception {
	Thread.sleep(3000);
	 String manageSubTasksGetText =  ToDo_Task_Page.manageSubTasks_Text(driver);
	 System.out.println(manageSubTasksGetText);
	 int pos=manageSubTasksGetText.indexOf("Manage");
	 String subtaskNumber = manageSubTasksGetText.substring(0,pos);
	 System.out.println(subtaskNumber + "SubTasks created so far");
	 
	}

//To click Manage subtask button 	
	@Test(priority=4)
	  public void click_subtask_Link() throws Exception{
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  ToDo_Task_Page.managesubTask_Link(driver,element).click();
	}

//To check the read only task id and task description
	@Test(priority=5)
	public void getHeadingTxt() throws Exception{
		Thread.sleep(2000);
		String pageHeading = ModelDialog_Page.readOnlytxt(driver,by);
		if(pageHeading!= null)
		System.out.println(pageHeading);
		File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  try {
			FileUtils.copyFile(scrFile, new File("C:\\workspace\\Avenue_code\\ScreenShots\\ReadOnlyPageText.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//Entering the subtask description with Max length 250 characters and date MM/DD/YYYY
	@Test(priority=6)
	public void enterSubTaskDetails() throws Exception{
		Thread.sleep(2000);
		String maxTaskDesp="udmbmnswzcsvhjzopoty hcozlhhoclyqxfwzfzua dpbmlbavmfuotdormiow wzixihgjuwhnukloewyl vwggpvqqmcwsvepqlhwx dzurzhmazxqpfypylnhj ubfukjfsgrwgttgnutzz buzwrrqhhdhlgrjmkrts jbydwjxerzxmnigycvap lhmmzkywsnijgrbltfwf";
		 ModelDialog_Page.enterSubTask(driver,element).sendKeys(maxTaskDesp);
		 ModelDialog_Page.enterSubTaskDate(driver,element).clear();
		 ModelDialog_Page.enterSubTaskDate(driver,element).sendKeys("05/24/2016");
		 File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  try {
			FileUtils.copyFile(scrFile, new File("C:\\workspace\\Avenue_code\\ScreenShots\\SubtaskDescription.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Thread.sleep(3000);
	}

//To create subtask by entering the subtask description and date MM/DD/YYYY and click "ADD"
	@Test(priority=7)
	public void SubTaskAddBtn() throws Exception{
		ModelDialog_Page.enterSubTask(driver,element).sendKeys("SubTask1");
		 ModelDialog_Page.enterSubTaskDate(driver,element).clear();
		 ModelDialog_Page.enterSubTaskDate(driver,element).sendKeys("05/24/2016");
		 File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  try {
			FileUtils.copyFile(scrFile, new File("C:\\workspace\\Avenue_code\\ScreenShots\\SubTaskDate.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 ModelDialog_Page.addSubTask(driver,element).click();
		 Thread.sleep(2000);
		
	}
// To create empty task	without the mandatory fields- Subtask tescription and Date
	@Test(priority=8)
	public void emptySubTaskAddBtn() throws Exception{
		ModelDialog_Page.enterSubTask(driver,element).clear();;
		 ModelDialog_Page.enterSubTaskDate(driver,element).clear();
		 ModelDialog_Page.addSubTask(driver,element).click();
		 System.out.println("Empty subtask is created");
		 Thread.sleep(2000);
	}
	
	//Checking if the subtask is being added to the bottom of the modal dialog
	@Test(priority=9)
	public void numberofSubTaskRecords() throws Exception{
		List<WebElement> getrecordsbefore=ModelDialog_Page.available_SubTaskRecords( driver, element);
		int subrecordsizebefore=getrecordsbefore.size();
		ModelDialog_Page.enterSubTask(driver,element).clear();;
		 ModelDialog_Page.enterSubTaskDate(driver,element).clear();
		 ModelDialog_Page.addSubTask(driver,element).click();
		 List<WebElement> getrecordsafter=ModelDialog_Page.available_SubTaskRecords( driver, element);
		 int subrecordsizeafter=getrecordsafter.size();
		 if(subrecordsizeafter>subrecordsizebefore)
			 System.out.println("Subtask before adding: "+  subrecordsizebefore);
			 System.out.println("Subtask after adding: "+ subrecordsizeafter);
			 driver.findElement(By.xpath("//div[@class='modal-footer ng-scope']/button")).click();
			 File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  try {
				FileUtils.copyFile(scrFile, new File("C:\\workspace\\Avenue_code\\ScreenShots\\SubTaskAdd.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 
	}
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		driver=new ChromeDriver();
	  userLogin_Testcase mytask = new  userLogin_Testcase();
	  try {
		mytask.begin_Todo(driver, by,element);
	} catch (Exception e) {
		System.out.println("Exception occured in beforeTest()"+ e.getMessage());
		e.printStackTrace();
	}
  }
  
   @AfterTest
   public void afterTest() throws InterruptedException {
	   Home_Page.SignOut_MyTask_Page_link(driver,element).click();
	   Thread.sleep(1000);
	   driver.close();
	   driver.quit();
   }
}
