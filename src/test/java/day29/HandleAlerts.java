package day29;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		//Normal alert with ok button
//		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
//		Thread.sleep(5000);
//		
////		driver.switchTo().alert().accept();
//		
//		Alert myalert=driver.switchTo().alert();
//	    System.out.println(myalert.getText());
//	    myalert.accept();
	    
	    //Confirmation Alert with ok and cancel button
	    
//	    driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
//	    Thread.sleep(5000);
//	  //  driver.switchTo().alert().accept();//click on Ok button
//	    driver.switchTo().alert().dismiss();//click on cancel button
		

		//Prompt Alert with Input box
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		
		Alert mypromtalert = driver.switchTo().alert();
		mypromtalert.sendKeys("welcome guys");
		Thread.sleep(3000);
		mypromtalert.accept();

	}

}
