//programm for redbus enter kbr in from print auto generate cities in consloe
package Projects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RedBus {

		WebDriver driver;
		@BeforeTest
		public void Web() {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\ASHOK SHANKAR\\Downloads\\chromedriver\\chromedriver.exe");
			ChromeOptions noti = new ChromeOptions();
			noti.addArguments("--disable-notifications");
			driver = new ChromeDriver(noti);
			driver.manage().window().maximize();
	}
		@Test
		public void URL() {
			driver.get("https://www.redbus.in/");
			driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
			WebElement TT = driver.findElement(By.xpath("//input[@id=\"src\"]"));
			TT.click();
			TT.sendKeys("kbr");	
			
		    List<WebElement> mov  = driver.findElements(By.xpath("//div[@id=\"mBWrapper\"]//li//text"));
			    for(int i=0;i<mov.size();i++) {
			    	String str = mov.get(i).getText();
			    	System.out.println(str);
			}			    				    	
		}
           @AfterTest
			public void cl() {
				driver.close();
			}	
		}


