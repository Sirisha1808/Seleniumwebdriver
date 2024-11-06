package day35;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;



public class ActionsVsAction {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
        driver.manage().window().maximize();
        
        WebElement button = driver.findElement(By.xpath("//span[text()='right click me']"));
        
        Actions act = new Actions(driver);
        
        Action myaction =act.contextClick(button).build();//building/creating an action and stored into a variable
        
        myaction.perform();//we are performing/completing an action
       
	    

	}

}
