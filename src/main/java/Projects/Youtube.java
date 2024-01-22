//programm for youtube enter sle in from print auto generate items in consloe
package Projects;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Youtube {
		
	WebDriver driver;
	@BeforeTest
	public void URL(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ASHOK SHANKAR\\Downloads\\chromedriver\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	}
	@Test
	public void Search() {
		driver.get("https://www.youtube.com/");
	    WebElement Ent = driver.findElement(By.xpath("//input[@id=\"search\"]"));
		Ent.click();
		Ent.sendKeys("Selenium");
	
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		List<WebElement> sugg = driver.findElements(By.xpath("//ul[@role=\"listbox\"]"));
		for(int j=0;j<sugg.size();j++) {
			String list = sugg.get(j).getText();
			System.out.println(list);
		}
	}
	@AfterTest
	public void clo() {
		driver.close();
	}
}	
	