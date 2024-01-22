package Projects;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Jet {
	WebDriver driver;
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ASHOK SHANKAR\\Downloads\\chromedriver\\chromedriver.exe");
		ChromeOptions p = new ChromeOptions();
		p.addArguments("--disable-notifications");
		driver = new ChromeDriver(p);
	}
	//@Test
	public void URL() {
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String name = driver.getTitle();
		Assert.assertEquals(name,"YouTube");
		System.out.println("Open Window title is  " + name);
	}	
	@Test
	public void upto() {
		driver.get("https://www.spicejet.com/");	
		driver.manage().window().maximize();
 		
	    driver.findElement(By.xpath("(//input[@class=\"css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu\"])[1]")).sendKeys("HY");   
	    driver.findElement(By.xpath("(//input[@class=\"css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu\"])[2]")).click();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//div[text()=\"International\"]")).click();
	    driver.findElement(By.xpath("//div[text()=\"Suvarnabhumi Airport\"]")).click();	
	}
	@Test
	 public void Date() {
		
	    List<WebElement> Date = driver.findElements(By.xpath("//div[@data-testid=\"undefined-month-September-2023\"]"));
	    int day = Date.size();
        System.out.println(day);
   
    for(int i=0;i<day;i++) {
    	System.out.println("day.get(i).getText()");
			if(Date.get(i).getText().equalsIgnoreCase("7")) {
				Date.get(i).click();		    
	          }	    
         }
	}
}

