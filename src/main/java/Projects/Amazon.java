package Projects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Amazon {
	
	static WebDriver driver;
	public static void main(String[] args ){
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ASHOK SHANKAR\\Downloads\\chromedriver\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    System.out.println("Amazon-Start");
	    driver.get("https://www.amazon.com/");
	    String tit = driver.getTitle();
	    Assert.assertEquals(tit,"Amazon.com. Spend less. Smile more");
	    System.out.println("Title is :- "+ tit);
	    String ul = driver.getCurrentUrl();
	    Assert.assertEquals(ul,"https://www.amazon.com/");
	    System.out.println("ULR is :- "+ ul);
	    
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2doB4z\"]")).click();  //closing popout window
		System.out.println("Grocery"); 
		driver.findElement(By.xpath("//img[@alt=\"Grocery\"]")).click();
		String currentGurl = driver.getCurrentUrl();
		System.out.println("Current URL:- "   + currentGurl);
		String currentGtitle= driver.getTitle();
		System.out.println("Current title:- " + currentGtitle);
		System.out.println("Closing-Grocery");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//img[@alt=\"Mobiles\"]")).click();
		System.out.println("moblie");
		String currentMurl = driver.getCurrentUrl();
		System.out.println("Current URL:- "   + currentMurl);
		String currentMtitle= driver.getTitle();
		System.out.println("Current title:- " + currentMtitle);
		System.out.println("Closing-Moblie");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//img[@alt=\"Fashion\"]")).click();
		System.out.println("Fashion");
		
	}
	public void clo() {
		driver.close();
	}
}