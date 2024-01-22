package FreeCRM;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import testNGBasics.Assert;

public class CRM_Xpath {

	WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ASHOK SHANKAR\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
		
	    //ULR
		driver.get("https://freecrm.com/");
		
//Test-Case-0
	   //Homepage
		//WebElement Home = driver.findElement(By.xpath("//li[@class=\"active\"]"));
		//Home.click();
	    //System.out.println(HomeID);
	   //Hard-Assert
	    String HomeTitle = driver.getTitle();
    	//System.out.println("HomeTitle is :--  " + HomeTitle);
 //   	Assert.assertEquals(HomeTitle, "Free CRM software for customer relationship management, sales, and support.");
		
//Test-Case-1
	   //cogmento header link
		WebElement congmento_header_element = driver.findElement(By.xpath("(//a[@href=\"https://cogmento.com\"])[1]"));
		String open_tabs = Keys.chord(Keys.CONTROL,Keys.ENTER);
		String parent_ID = driver.getWindowHandle();
		
		congmento_header_element.sendKeys(open_tabs);
		
		Set<String> child_ID = driver.getWindowHandles();
		for(String ID : child_ID) {
			
			if(!parent_ID.equals(child_ID)) {
				driver.switchTo().window(ID);
				System.out.println(driver.getTitle());
			driver.close();
			}
			
		
		}
		

		
	
		
/*	    
		JavascriptExecutor down = (JavascriptExecutor) driver;
		down.executeScript("window.scrollTo(0,8000)");
		
//Test-Case-2		
	   //cogmento footer link
		WebElement congmento_footer = driver.findElement(By.xpath("(//a[@href=\"https://cogmento.com\"])[2]"));
		String congmento_footer_open = Keys.chord(Keys.CONTROL,Keys.ENTER);
		congmento_footer.sendKeys(congmento_footer_open);
		Set<String> congmento_footerID = driver.getWindowHandles();
	    System.out.println(congmento_footerID);
	    
//Test-Case-3
		//Privacy Policy 
		WebElement Policy  = driver.findElement(By.xpath("//a[@href=\"/privacy.html\"]"));
		String Policy_open = Keys.chord(Keys.CONTROL,Keys.ENTER);
		Policy.sendKeys(Policy_open);
		Set<String> PolicyID = driver.getWindowHandles();
	    System.out.println(PolicyID);
	    
//Test-Case-4
		//Terms & Conditions
		WebElement Conditions = driver.findElement(By.xpath("//a[@href=\"/terms.html\"]"));
		String Conditions_open = Keys.chord(Keys.CONTROL,Keys.ENTER);
		Conditions.sendKeys(Conditions_open);
		Set<String> ConditionsID = driver.getWindowHandles();
	    System.out.println(ConditionsID);
	    
//Test-Case-5
		//English footer link
	    WebElement English = driver.findElement(By.xpath("//ul[@class=\"list-unstyled\"]//a"));
	    String english_open = Keys.chord(Keys.CONTROL,Keys.ENTER);
		english.sendKeys(english_open);
		Set<String> englishID = driver.getWindowHandles();
	    System.out.println(englishID);
*/
    //driver.close();
	}
}
