//programm for cricBuzz All teams print in consloe

package Projects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CricBuzz2 {

	WebDriver driver;
	@BeforeTest
	public void Web() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ASHOK SHANKAR\\Downloads\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@BeforeClass
	public void login() {
		driver.get("https://www.cricbuzz.com/");
		driver.manage().window().maximize();
	}
	@Test
	public void  move() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement names = driver.findElement(By.xpath("//div[@title=\"Cricket Teams\"]"));
		Actions cls = new Actions(driver);
		cls.moveToElement(names).build().perform();	
		
//		List<WebElement> fu = driver.findElements(By.xpath("//div[@id=\"teamDropDown\"]"));
//		for (int j=0;j<fu.size();j++) {
//			System.out.println(ful.get(j).getText());
//		}
	}
	@AfterClass
	public void tab() {
		List<WebElement> ful = driver.findElements(By.xpath("//div[@id=\"teamDropDown\"]"));
		for (int j=0;j<ful.size();j++) {
			System.out.println(ful.get(j).getText());
		}
	}
	@AfterTest
	public void clo() {
		driver.quit();
	}
	}
	
