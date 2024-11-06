package day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitDemo {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//Implicit Wait
		
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id=\"FirstName\"]")).sendKeys("Sirisha");
		
		
        driver.close();
	}

}
