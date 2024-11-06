package day39;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDomElements {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://books-pwakit.appspot.com/");
		driver.manage().window().maximize();
		
//		//This element is inside single shadom DOM
//		String cssSelectorForHost1 = "book-app[apptitle='BOOKS']";
//		Thread.sleep(5000);
		
		//Handle Shawdom element // Xpaths can not handle shadow DOMs elements
		SearchContext shadow=driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
		Thread.sleep(5000);
		shadow.findElement(By.cssSelector("#input")).sendKeys("WELCOME");
	
		
		
		

	}

}
