package day35;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickAction {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
        driver.manage().window().maximize();
        
        WebElement button = driver.findElement(By.xpath("//span[text()='right click me']"));
        
        Actions act = new Actions(driver);
        
        //Right click action
        act.contextClick(button).perform();
        
        //Click on copy
        driver.findElement(By.xpath("//span[text()='Copy']")).click();
        Thread.sleep(5000);
        
        //close the alert box
        driver.switchTo().alert().accept();
        
		
	}

}
