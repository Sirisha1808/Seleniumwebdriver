package day30;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Frame1
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame1);//passed frame as a WebElement //Switch into frame 1
		
		driver.findElement(By.xpath("//input[@name=\"mytext1\"]")).sendKeys("Welcome");
		
		driver.switchTo().defaultContent();//go back to page
		
		//Frame2
		WebElement frame2 = driver.findElement(By.xpath("//frame[@src=\"frame_2.html\"]"));
		driver.switchTo().frame(frame2);//passed frame as a WebElement //Switch into frame 2
		
		driver.findElement(By.xpath("//input[@name=\"mytext2\"]")).sendKeys("Selenium");
		driver.switchTo().defaultContent();//go back to page
		
		//Frame3
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src=\"frame_3.html\"]"));
		driver.switchTo().frame(frame3);//passed frame as a WebElement //Switch into frame 2
		
		driver.findElement(By.xpath("//input[@name=\"mytext3\"]")).sendKeys("Java");
	
		//Handle with inner iframe it is part of frame3
		driver.switchTo().frame(0);//switching the frame using index
		
//		driver.findElement(By.xpath("//div[@id=\"i5\"]//div[@class=\"AB7Lab Id5V1\"]")).click();
//		driver.switchTo().defaultContent();//go back to page
		
		WebElement rdbutton = driver.findElement(By.xpath("//div[@id=\"i5\"]//div[@class=\"AB7Lab Id5V1\"]"));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("argument[0].click();", rdbutton);
		

	}

}
