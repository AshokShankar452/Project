package Projects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CricBuzzlinks {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
			System.setProperty("webdriver.chrome.driver","C:\\Users\\ASHOK SHANKAR\\Downloads\\chromedriver\\chromedriver.exe");
		    driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    
		    driver.get("https://www.cricbuzz.com/");
		    WebElement RRR = driver.findElement(By.xpath("//div[@id=\"newsDropDown\"]"));
//		    RRR.click();
		    Thread.sleep(3000);
		    for(int i=0; i<=RRR.findElements(By.tagName("a")).size();i++) {
				String open = Keys.chord(Keys.CONTROL, Keys.ENTER);
				RRR.findElements(By.tagName("a")).get(i).sendKeys(open);
			}
	}
}