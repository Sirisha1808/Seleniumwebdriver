package day37;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPage {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
//		
//		 //1)  Scroll down page by pixel number
//        js.executeScript("window.scrollBy(0,1500)");
//        Thread.sleep(5000);
//        
//        // Print the current vertical scroll position
//        Object yOffset = js.executeScript("return window.pageYOffset;");
//        System.out.println("Current vertical scroll offset: " + yOffset);//1500
		
		//2)Scroll the page till element is visible
		 // Scroll the page until the element is visible
//        WebElement ele = driver.findElement(By.xpath("//h2[normalize-space()='Resizable']"));
//        js.executeScript("arguments[0].scrollIntoView(true);", ele);
//        // Print the new vertical scroll position
//        System.out.println("New vertical scroll offset: " + js.executeScript("return window.pageYOffset;"));//1694
        
        //3)Scroll page till end of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        System.out.println(js.executeScript("return window.pageYOffset;"));
        Thread.sleep(5000);
        
        //4)Scrolling upto initial position
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
        
	}

}
