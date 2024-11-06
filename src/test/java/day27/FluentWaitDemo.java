package day27;

import java.time.Duration;
import java.util.NoSuchElementException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import org.openqa.selenium.By;




public class FluentWaitDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		//Fluent wait declaration
		Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		
		
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();
		
	//	driver.findElement(By.xpath("//input[@placeholder=\"Username\"]")).sendKeys("Admin");
		
		WebElement userNameTxt = mywait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//input[@id='FirstName']"));
			}
			
	  
		});
		
		userNameTxt.sendKeys("Admin");
	;
        driver.close();
	}

}
