package Projects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CricBuzz {
	WebDriver driver;
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ASHOK SHANKAR\\Downloads\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public void ULR() {
		driver.manage().window().maximize();
		driver.get("https://www.jetairways.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String name = driver.getTitle();
		Assert.assertEquals(name,"Jet Airways");
		System.out.println("Open Window title is  " + name);
	}
	@Test
	public void actionClass() {
		driver.manage().window().maximize();
		driver.get("https://www.cricbuzz.com/");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement News = driver.findElement(By.xpath("//div[@id=\"newsDropDown\"]"));
		Actions cat = new Actions(driver);
		cat.moveToElement(News).build().perform();
		
		List<WebElement> options = driver.findElements(By.xpath("//div[@id=\"newsDropDown\"]//a"));
		
		for(int i=0;i<options.size();i++) {
			System.out.println(options.get(i).getText());
		}
		
	}
	@AfterTest
	public void close() {
		driver.close();
	}
	
}
