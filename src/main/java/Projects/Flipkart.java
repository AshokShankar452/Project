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

public class Flipkart {
	
	WebDriver driver;
	@BeforeTest
	public void URL(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ASHOK SHANKAR\\Downloads\\chromedriver\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    System.out.println("Flipcart-Start");
	    driver.get("https://www.flipkart.com/");
	    String currenturl= driver.getCurrentUrl();
	    System.out.println("Current URL:- "   + currenturl);
	    String currenttitle= driver.getTitle();
	    System.out.println("Current title:- " + currenttitle);	    
	}
	  //@Test
	  public void AGrocery() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2doB4z\"]")).click();  //closing popout swindow
		System.out.println("Grocery"); 
		driver.findElement(By.xpath("//img[@alt=\"Grocery\"]")).click();
		String currenturl = driver.getCurrentUrl();
		System.out.println("Current URL:- "   + currenturl);
		String currenttitle= driver.getTitle();
		System.out.println("Current title:- " + currenttitle);
		System.out.println("Closing-Grocery");	
		//driver.navigate().back();
	  }
	 // @Test
	  public void BMobile() {
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//img[@alt=\"Mobiles\"]")).click();
		System.out.println("moblie");
		String currentMurl = driver.getCurrentUrl();
		System.out.println("Current URL:- "   + currentMurl);
		String currentMtitle= driver.getTitle();
		System.out.println("Current title:- " + currentMtitle);
		System.out.println("Closing-Moblie");
		//driver.navigate().back();
	  }
	  @Test
	  public void CFashion() {
		    driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2doB4z\"]")).click();  //closing popout window
		    driver.findElement(By.xpath("//img[@alt=\"Fashion\"]")).click();  
			System.out.println("Fashion");
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			List<WebElement> sugg = driver.findElements(By.xpath("//div[@class=\"_3_Fivj\"]"));
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

