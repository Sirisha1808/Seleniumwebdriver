package day22;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		//Name as a Locator
		//driver.findElement(By.name("search")).sendKeys("Mac");
		
		//id
		boolean logoDisplaystatus = driver.findElement(By.id("logo")).isDisplayed();
		System.out.println(logoDisplaystatus);
		
		//link Text
		//driver.findElement(By.linkText("Tablets")).click();
		
		//Partial linkText
//		driver.findElement(By.partialLinkText("Tabl")).click();
		
		//Group of web elemenets
		
//		List<WebElement> headerLinks = driver.findElements(By.className("list-inline-item"));
//		System.out.println("Number of hearder links:"+ headerLinks.size());
		
		//tagname -To get group of webElements
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Num of links:"+links.size());
		
		
		
		

	}

}
