package day28;

import java.time.Duration;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserWindows {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		
		Set<String> windowIDs = driver.getWindowHandles();
		
		//How to get these IDs individually
		
		//Approach1: List collection prefered only 2 to 3 browser windows
		
	/*  List<String> windowList = new ArrayList(windowIDs);
		String parentID = windowList.get(0);
		String childID = windowList.get(1);
		
		//Before switch to driver that driver focus on parent window
		System.out.println(driver.getTitle());
		
		//Switch to child window
		driver.switchTo().window(childID);
		System.out.println(driver.getTitle());//By capture the ID's of browser windows we can switch from one browser to another browser
		
		//Switch to Parent window
		driver.switchTo().window(parentID);
	    System.out.println(driver.getTitle());    */
		
		//Approach2: By using statements for multiple browser windows(using enhanced for loop)
		
		for(String windowID:windowIDs) {
			String title = driver.switchTo().window(windowID).getTitle();
			
			if(title.equals("OrangeHRM")) {
				System.out.println(driver.getCurrentUrl());
			}
		}
		
		

	}

}
