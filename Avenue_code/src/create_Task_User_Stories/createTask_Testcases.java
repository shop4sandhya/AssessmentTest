package create_Task_User_Stories;
import org.testng.annotations.Test;
import userLogin.userLogin_Testcase;
import pageobject.Home_Page;
import pageobject.MyTask_Page;
import pageobject.ToDo_Task_Page;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.Assert;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

public class createTask_Testcases {
	public WebDriver driver;
	public static WebElement element = null;
	public By by;
	List<String> taskNames=null;;
	
//Click MyTask Link
 @Test(priority=1)
  public void verify_MyTask_Link() {
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  MyTask_Page.isMyTask_LinkPresent(by);
	  System.out.println("Link is present, going to click..");
	  File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  try {
		FileUtils.copyFile(scrFile, new File("C:\\workspace\\Avenue_code\\ScreenShots\\mytaskscreen.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			  
			  
  }
  
 //To check if the user is able to see the tasks created so far
  @Test(priority=2)
  public void verify_Records() throws Exception{
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  MyTask_Page.myTask_Link(driver,element).click();
	  //Thread.sleep(3000);
	  System.out.println("Link is present, going to click..");
	  Assert.assertEquals(driver.getCurrentUrl(), "http://qa-test.avenuecode.com/tasks");
	  int numberOfRecords=ToDo_Task_Page.count_Records( driver);
	  if(numberOfRecords<1)
		  System.out.println("No records created so far");
	  else
		  System.out.println("Records created so far: " + numberOfRecords);
	  File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  try {
		FileUtils.copyFile(scrFile, new File("C:\\workspace\\Avenue_code\\ScreenShots\\RecordsInMytask.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  //2nd Testcase Check for the Message Users ToDo List
  @Test(priority=3)
  public void verify_User_Message() {
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  String todoString = ToDo_Task_Page.Logged_User_Message( driver);
	  System.out.println(todoString);
	  String username = ToDo_Task_Page.Logged_Welcome_User(driver);
	  String checkString= username+"'s ToDo List";
	  if (todoString.equals(checkString)) {
		  System.out.println("Display message belongs to the logged user");
		  
	  }
	  File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  try {
		FileUtils.copyFile(scrFile, new File("C:\\workspace\\Avenue_code\\ScreenShots\\UserMessage.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }
  
  @Test(priority=4)//create a new task by entering the task name and click 'ADD'
  public void checkNewTaskEntryWithADD() throws InterruptedException {
	  Thread.sleep(2000);
	  ToDo_Task_Page.newTaskEntryTest( driver, element).sendKeys("TestcasewithBtn");
	  ToDo_Task_Page.newTaskAdd(driver,element).click();
	  System.out.println("new task created");
	  List<String> getRecords= ToDo_Task_Page.available_Records(driver,element,taskNames);
	  if(getRecords!=null && getRecords.size()>0){
		  for(String record:getRecords ){
			  if(record.equals("Testcase2")) 
				  System.out.println("Created record found in the entered list");
			  
		  }
	  }
	  File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  try {
		FileUtils.copyFile(scrFile, new File("C:\\workspace\\Avenue_code\\ScreenShots\\CreateTaskWith_ADD.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

//create a new task by entering the task name and click 'Enter Key'
  @Test(priority=5)//create a new task by entering the task name and click 'Enter Key'
  public void checkNewTaskEntryWithEnter() throws InterruptedException {
	  Thread.sleep(2000);
	  ToDo_Task_Page.newTaskEntryTest( driver, element).sendKeys("TestcaseWithEnter");
	  Actions toEnter= new Actions(driver);
	  toEnter.sendKeys(Keys.ENTER).perform();
	  System.out.println("new task created");
	  List<String> getRecords= ToDo_Task_Page.available_Records(driver,element,taskNames);
	  if(getRecords!= null && getRecords.size()>0){
		  for(String record:getRecords ){
			  if(record.equals("Testcase2")) 
				  System.out.println("Created record found in the entered list");
			  
		  }
	  }
	  File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  try {
		FileUtils.copyFile(scrFile, new File("C:\\workspace\\Avenue_code\\ScreenShots\\CreateTaskWith_ENTER.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  //To check that Task has atleast 3 chars so the user can create the task
  @Test(priority=6,dataProvider="getData")
  public void checkNewTaskEntrysize(String passData01, String passsData02,String passsData03,String passsData04,String passsData05) throws InterruptedException {
	  Thread.sleep(2000);
	System.out.println(" Data coming in CheckNewTaskEntrysize .. " + passData01 + passsData02 +passsData03 + passsData04 + passsData05);
	String[] passVaraiables = {passData01,passsData02, passsData03 , passsData04 , passsData05};
  	
	for(int j=0; j<passVaraiables.length;j++){ 
  		  if (passVaraiables[j].length()<3){
  			  ToDo_Task_Page.newTaskEntryTest( driver, element).sendKeys(passVaraiables[j]);
  			  ToDo_Task_Page.newTaskAdd(driver,element).click();
  			  File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  			  try {
  				FileUtils.copyFile(scrFile, new File("C:\\workspace\\Avenue_code\\ScreenShots\\TaskName.png"));
  			  } catch (IOException e) {
  				  // TODO Auto-generated catch block
  				  e.printStackTrace();
  			  }
  			  System.out.println("Length of the task name is less than 3, Task shouldnot be entered" + "Task Name Taken: "+ passVaraiables[j]);
  		  	  
  		  }
		  else
		    	  ToDo_Task_Page.newTaskEntryTest( driver, element).sendKeys(passVaraiables[j]);
  	} 
  }

  //the Task cannot have more then 250 chars 
  // Task is created with more than 250 chars, Bug to be logged
  @Test(priority=7)
   public void limitNewTaskcharsize()throws Exception {
	  String maxchar="cwfrlmnkdfgelystzjzgrjrolsykeknxzhppzpmecmmmlwgynfzalfjihrydlvylaiqaiarksvzoqcbugwedenvlzamijstgupfdxjjrilwlgbfjhxzagyfhogqloqldlsktbuxrwfapcvmufxncisifiidhodmbcqrhxmfvfmbtmobsvafaucmvqjdjgvmyjuabujppakevgjwjsgpvxpmksysatzttmxtfseyybdeyssobdzdfixrjqdvitagdpxyzuzcudkawrbrrhkpretxypkmakzrdkouhqylxcjgn";
	  if(maxchar.length()>250){
		 ToDo_Task_Page.newTaskEntryTest( driver, element).sendKeys(maxchar);
		 ToDo_Task_Page.newTaskAdd(driver,element).click();
		 System.out.println("Taskname is taking more than 250 characters, need to log a bug");
		// throw new Exception("Taskname is taking more than 250 characters");
	  }
  }
  
  // Check :when created, new records are being appended to the list of created tasks
  @Test(priority=8)
  public void checkRecordAppended()throws Exception {
  int recordsTotalBeforeCreate=ToDo_Task_Page.count_Records( driver);
  ToDo_Task_Page.newTaskEntryTest( driver, element).sendKeys("Testcase2");
  ToDo_Task_Page.newTaskAdd(driver,element).click();
  int recordsTotalAfterCreate=ToDo_Task_Page.count_Records( driver);
  if(recordsTotalAfterCreate==recordsTotalBeforeCreate+1)
	  System.out.println("when created, new  records are being appended to the list of created tasks");
  }
  
  @DataProvider
  public static  String[][] getData()
  {
	  String[][] passData=new String[1][5];
	  passData[0][0]="";
	  passData[0][1]="a";
	  passData[0][2]="ab";
	  passData[0][3]="abd";
	  passData[0][4]="abcd";
	  return passData;
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
 
