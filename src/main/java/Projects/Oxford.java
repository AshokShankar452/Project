package Projects;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Oxford {
	
	WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ASHOK SHANKAR\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    
	    driver.get("https://academic.oup.com/");
	    driver.manage().getCookies();
	    driver.findElement(By.id("accept-button")).click();
	    String parentTab = driver.getWindowHandle();
	    
	    driver.findElement(By.xpath("(//li[@id=\"site-menu-item-1554360\"])[2]")).click();
	    List<WebElement> list = driver.findElements(By.xpath("//nav[@class=\"tree-browse js-tree-browse-nodes display-columns\"]"));
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    int total =0;
	    for(int k=0;k< list.size();k++) {	    
	    	System.out.println(list.get(k).getText());
	    	total++;
	    }
	    System.out.println(total);
	    
	    
	    driver.findElement(By.className("tree-node-arrow")).click();
	    JavascriptExecutor down = (JavascriptExecutor) driver;
	    down.executeScript("window.scrollTo(0,200)");
	    List<WebElement> names = driver.findElements(By.xpath("//nav[contains(@class,'tree-browse js-tree-browse-nodes display-columns')]"
	    		+ "//div[contains(@class,'tree-node-item js-tree-node-item animate active fade')]//a"));
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    int count =0;
	   for(int i=0;i< names.size();i++) {
		   System.out.println(names.get(i).getText());
		   count++;
	   }
	   System.out.println(count);	    
 
	   driver.findElement(By.xpath("//div[contains(@class,'tree-node-item js-tree-node-item animate active fade')][1]")).click();
	   List<WebElement> medica = driver.findElements(By.xpath("//nav[contains(@class,'tree-browse js-tree-browse-nodes display-columns')]"
	   		+ "//div[contains(@class,'tree-node-item js-tree-node-item animate active fade')]//a"));
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    int nos =0;
	   for(int i=0;i< medica.size();i++) {
		   System.out.println(medica.get(i).getText());
		   nos++;
	   }
	   System.out.println(nos);
	   for(int i=0;i<medica.size();i++) {
		   String open = Keys.chord(Keys.CONTROL, Keys.ENTER);
		   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		   medica.get(i).sendKeys(open);
	   }
	   Set<String> openTabs = driver.getWindowHandles();
	   for( String tab:openTabs) {
			System.out.println(tab);
			if(!tab.equalsIgnoreCase(parentTab)) {
				driver.switchTo().window(parentTab);
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				System.out.println(driver.getTitle());
				driver.close();
			}
			driver.switchTo().defaultContent();
	   }
	   Thread.sleep(1000);
	   driver.quit();
	}	
}
