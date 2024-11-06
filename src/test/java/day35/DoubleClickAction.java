package day35;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickAction {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();

		
		//Switch to frame
		driver.switchTo().frame("iframeResult");
		
		WebElement box1=driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement box2=driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement button=driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		
		box1.clear();
		box1.sendKeys("WELCOME");
		
		//Double click action on button
		Actions act = new Actions(driver);
		
		act.doubleClick(button).perform();
		
		//validate the box2 should contains as WELCOME
		
		String textBox2 =box2.getAttribute("value");
		System.out.println(textBox2);
		
		if(textBox2.equals("WELCOME")) {
			System.out.println("Text should copied properly");
		}else {
			System.out.println("Text not copied properly");
		}
		

	}

}
