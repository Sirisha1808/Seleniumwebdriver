package day36;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpenTheLinkInNewTab {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.orangehrm.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		WebElement regLink = driver.findElement(By.xpath("(//button[text()='Book a Free Demo'])[2]"));
	
		Actions act = new Actions(driver);
		
		//Control+RegLink
		act.keyDown(Keys.CONTROL).click(regLink).keyUp(Keys.CONTROL).perform();
		
		//Switching to Free Demo page
		List<String> ids = new ArrayList(driver.getWindowHandles());
		 
		
		driver.switchTo().window(ids.get(1));
		
		driver.findElement(By.xpath("//input[@name=\"FullName\"]")).sendKeys("Sirisha");
		
		driver.switchTo().window(ids.get(0));
		
		driver.findElement(By.xpath("(//button[text()='Contact Sales'])[2]")).click();
		
	
	}

}
