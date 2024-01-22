//CricBuzz print all in console using Action class others 
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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskCricBuzz {
	
	WebDriver driver;
	@BeforeMethod
	public void URL(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ASHOK SHANKAR\\Downloads\\chromedriver\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
}
	@Test
	public void Task() throws InterruptedException {
		driver.get("https://www.cricbuzz.com/");
	/*	System.out.println("1..Starting");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@title=\"Live Cricket Score\"]")).click();
		String CricTT = driver.getTitle();
		Assert.assertEquals(CricTT,"Live Cricket Score | Scorecard | Live Commentary | Cricbuzz.com");
		System.out.println("2..Title is:- " + CricTT);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//a[@title=\"Cricket Schedule\"])[1]")).click();
		String Sch = driver.getTitle();  
		Assert.assertEquals(Sch,"Cricket Schedule - International, domestic and T20 matches - Cricbuzz | Cricbuzz.com");
		System.out.println("3..Title is:- "+ Sch);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@title=\"Cricket Scorecard Archives\"][1]")).click();
		String Arc = driver.getTitle();
		Assert.assertEquals(Arc,"Cricket Archives - Series results, scorecards for | Cricbuzz.com");
		System.out.println("3..Title is:-  " + Arc);
	
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@title=\"Cricket News\"]")).click();
		String n = driver.getTitle();
		Assert.assertEquals(n,"Latest and breaking Cricket News - Cricbuzz | Cricbuzz.com");
		System.out.println("4..Title is:- "+ n); */
		
		System.out.println("News options Are Below:-");
		WebElement mov = driver.findElement(By.xpath("(//div[@class=\"cb-subnav cb-hm-mnu-itm feature-button cursor-pointer\"])[6]"));
		
		Actions cat = new Actions(driver);
		cat.build().perform();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		List<WebElement> options = driver.findElements(By.tagName("(//nav[@class=\"cb-sub-navigation\"])[5]"));
		//List<WebElement> options = driver.findElements(By.xpath("(//nav[@class=\"cb-sub-navigation\"])[5]"));
		for(int i=0;i<options.size();i++) {
			System.out.println(i);
			String lis = options.get(i).getText();
			System.out.println(lis);		
		}
	}			
	@AfterTest
	public void Sche() {
		driver.quit();
	}
}
