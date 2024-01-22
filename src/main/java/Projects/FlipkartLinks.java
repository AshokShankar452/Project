package Projects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartLinks {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ASHOK SHANKAR\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize(); 
		
		// Navigate to the demoqa website
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		Thread.sleep(8000);
		driver.findElement(By.xpath("//div[@class=\"_2QfC02\"]//button")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,8000)");
		
		WebElement hehe = driver.findElement(By.xpath("(//div[@class=\"_2Brcj4\"])[1]"));
		System.out.println(hehe.findElements(By.tagName("a")).size());
		
		for(int i=0; i<hehe.findElements(By.tagName("a")).size();i++) {
			String open = Keys.chord(Keys.CONTROL, Keys.ENTER);
			hehe.findElements(By.tagName("a")).get(i).sendKeys(open);
			//System.out.println(driver.getTitle());
		}
	
	//driver.quit();
	}
}