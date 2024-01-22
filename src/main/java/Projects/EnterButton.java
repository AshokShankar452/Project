//programm for youtube enter java in from  auto generate 1st items is consloe and enter
package Projects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EnterButton {
		
	WebDriver driver;
	@BeforeTest
	public void URL(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ASHOK SHANKAR\\Downloads\\chromedriver\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	}
	@Test
	public void Search() throws InterruptedException {
		driver.get("https://www.youtube.com/");
	    WebElement Ent = driver.findElement(By.xpath("//input[@id=\"search\"]"));
		Ent.click();
		Ent.sendKeys("Java");
		Thread.sleep(2000);
		Actions kvr = new Actions (driver);
		kvr.sendKeys(Keys.ARROW_DOWN);
		kvr.sendKeys(Keys.ENTER);
		kvr.build().perform();
	}
}