package FreeCRM;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CRM {

	public static void main(String[] args) throws IOException, InterruptedException {
		
	 Properties pro = new Properties();
	 FileInputStream file = new FileInputStream ("C:\\Users\\ASHOK SHANKAR\\eclipse-workspace\\POM-Project\\src\\main\\java\\FreeCRM\\CMR.properties");		
	 pro.load(file);
	 
	 WebDriver driver =null;
	 System.setProperty("webdriver.chrome.driver","C:\\Users\\ASHOK SHANKAR\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	    
	 driver.get(pro.getProperty("loginURL"));
	 
	 //login
	 driver.findElement(By.xpath(pro.getProperty("Email_Xpath"))).sendKeys(pro.getProperty("Email"));
	 driver.findElement(By.xpath(pro.getProperty("Pwd_Xpath"))).sendKeys(pro.getProperty("Pwd"));
	 driver.findElement(By.xpath(pro.getProperty("login_button"))).click();
	 
	 //Main menu 
	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 driver.findElement(By.xpath(pro.getProperty("main_menu")));
	 driver.findElement(By.xpath(pro.getProperty("contact"))).click();
	 driver.findElement(By.xpath(pro.getProperty("new_contact"))).click();
	 
	 //Details
	 driver.findElement(By.name(pro.getProperty("Fname_Xpath"))).sendKeys(pro.getProperty("Fname"));
	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 driver.findElement(By.xpath(pro.getProperty("Lname_Xpath"))).sendKeys(pro.getProperty("Lname"));
	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 driver.findElement(By.xpath(pro.getProperty("Mname_Xpath"))).sendKeys(pro.getProperty("Mname"));
	 	
	 //Search Box    
	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 driver.findElement(By.xpath("//div[@name=\"company\"]")).click(); 
	 driver.findElement(By.xpath("(//input[@class='search'])[1]")).sendKeys("Accenture");
	 
     //P&P Button 
	 driver.findElement(By.xpath(pro.getProperty("Access_button"))).click();
	 
//-->	 //Tags-  Not Working
//	 driver.findElement(By.xpath("(//div[@role=\"combobox\"])[2]")).click();	 
//	 WebElement Tag = driver.findElement(By.xpath("WebElement Tag = driver.findElement(By.xpath(\"(//div[@role=\\\"combobox\\\"])[2]\"));"));
//	 Tag.sendKeys("SoftWare");
 
	 //Category
	 driver.findElement(By.xpath(pro.getProperty("Category"))).click();
	 WebElement category = driver.findElement(By.xpath("//div[@class=\"visible menu transition\"]"));
	 Actions categoryOptions = new Actions (driver);
	 categoryOptions.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN);
	 categoryOptions.sendKeys(Keys.ENTER);
	 categoryOptions.build().perform();
	 
	//Status
	 driver.findElement(By.xpath("(//div[@name=\"status\"])[1]")).click();
	 WebElement Status = driver.findElement(By.xpath("//div[@class=\"visible menu transition\"]"));
	 Actions StatusOptions = new Actions (driver);
	 StatusOptions.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN);
	 StatusOptions.sendKeys(Keys.ENTER);
	 StatusOptions.build().perform(); 
	 
	 //Description
	 WebElement Description = driver.findElement(By.xpath(pro.getProperty("Description_Xpath")));
	 Description.click();
	 Description.sendKeys(pro.getProperty("Description_Matter"));
	 
	 //Channel_Xpath
	 driver.findElement(By.xpath(pro.getProperty("Channel_Xpath"))).click();
	 WebElement Channel = driver.findElement(By.xpath(pro.getProperty("Channel_OptionList")));
	 Actions ChannelOptions = new Actions (driver);
	 ChannelOptions.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN);
	 ChannelOptions.sendKeys(Keys.ENTER);
	 ChannelOptions.build().perform();          
	 
	 //SocialMedia
	 WebElement SocialMedia = driver.findElement(By.xpath(pro.getProperty("Social_channels")));
	 SocialMedia.click();
	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 driver.findElement(By.xpath("(//input[@name=\"value\"])[2]")).sendKeys("KCPD,KCMD");
	 
	 //Address                                                                           
	 WebElement Address = driver.findElement(By.xpath(pro.getProperty("Street")));
	 Address.click();
	 Address.sendKeys(pro.getProperty("StreetName"));
	 
	 //City
	 WebElement City = driver.findElement(By.xpath(pro.getProperty("city")));
	 City.click();
	 City.sendKeys(pro.getProperty("StreetName"));
	 
	//State
	 WebElement State = driver.findElement(By.xpath(pro.getProperty("State")));
	 State.click();
	 State.sendKeys(pro.getProperty("StateName"));
	 
	//PinCode
	 WebElement Pin = driver.findElement(By.xpath(pro.getProperty("PinCode")));
	 Pin.click();
	 Pin.sendKeys(pro.getProperty("PinCodeNo"));                          
	 
//-->	 //Country  -  Not Working
	 driver.findElement(By.xpath(pro.getProperty("Country"))).click();
	 driver.findElement(By.xpath(pro.getProperty("CountrySearch"))).sendKeys(pro.getProperty("CountryName"));
	 driver.findElement(By.xpath(pro.getProperty("CountryList")));
	 Actions country = new Actions(driver);	
	 country.sendKeys(Keys.ARROW_UP);
	 country.sendKeys(Keys.ENTER); 
	 country.build().perform(); 
	                                                                      
	 //Phone
	 driver.findElement(By.xpath(pro.getProperty("CountryPhone"))).click();
	 driver.findElement(By.xpath(pro.getProperty("CountryPhoneSearch"))).sendKeys(pro.getProperty("CountryName"));
	 driver.findElement(By.xpath(pro.getProperty("NumberEnter"))).sendKeys(pro.getProperty("Number"));
	 driver.findElement(By.xpath(pro.getProperty("NumberEnter2"))).sendKeys(pro.getProperty("Number2"));
	                                                                                                      
	 //Position
	 driver.findElement(By.xpath(pro.getProperty("Position"))).sendKeys(pro.getProperty("PositionName"));
	 //Department
	 driver.findElement(By.xpath(pro.getProperty("Department"))).sendKeys(pro.getProperty("DepartmentName"));
	 //Supervisor
	 driver.findElement(By.xpath(pro.getProperty("Supervisor"))).click();
	 driver.findElement(By.xpath(pro.getProperty("SupervisorBox"))).sendKeys(pro.getProperty("AssistantName"));
	//Referred
	 driver.findElement(By.xpath(pro.getProperty("Referred"))).click();
	 driver.findElement(By.xpath(pro.getProperty("ReferredBox"))).sendKeys(pro.getProperty("ReferredName"));	
	//Source
	 driver.findElement(By.xpath(pro.getProperty("Source"))).click();
	 WebElement Source = driver.findElement(By.xpath(pro.getProperty("SourceList")));
	 Actions SourceOptions = new Actions (driver);
	 SourceOptions.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN);
	 SourceOptions.sendKeys(Keys.ENTER);
	 SourceOptions.build().perform();                                                            
	 
	  
	 JavascriptExecutor moveto =  (JavascriptExecutor)driver;
	 moveto.executeScript("window.scrollTo(0,2000)");
	 //Buttons
	 driver.findElement(By.xpath(pro.getProperty("Call"))).click();
	 //driver.findElement(By.xpath(pro.getProperty("Emails"))).click();
	 //driver.findElement(By.xpath("(//div[@class=\"ui toggle checkbox\"])[2]")).click();

	 //
	 driver.findElement(By.xpath(pro.getProperty("Identifier"))).click();
	 driver.findElement(By.xpath(pro.getProperty("IdentifierBox"))).sendKeys(pro.getProperty("IdentifierName"));	
		
	 driver.quit();
	 
	 
		 }

}
