package day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitCommand {

	public static void main(String[] args) {
    WebDriver driver = new ChromeDriver();
    
    WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));//declaration
		
		
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();
		
	    WebElement femalecheckbox = mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='gender-female']")));
	    femalecheckbox.click();
		
		WebElement firstnametxt = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='FirstName']")));
		firstnametxt.sendKeys("Sirisha");
		
        WebElement lastnametxt = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='LastName']")));
        lastnametxt.sendKeys("Alluri");
         
         
		
	 	 driver.close();
		
	}

}
