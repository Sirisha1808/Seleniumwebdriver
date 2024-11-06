package day29;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckboxes {

	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	 
		 driver.get("https://testautomationpractice.blogspot.com/");
		 driver.manage().window().maximize();
		 
		 //Select specific checkbox
		// driver.findElement(By.xpath("//input[@id='tuesday']")).click();	 
		 //Select the all checkboxes
		 List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class=\"form-check-input\" and @type=\"checkbox\"]"));
		 
		 //apporach index for loop
//		 for(int i=0;i<checkboxes.size();i++) {
//			 checkboxes.get(i).click();
//			 
//		 }
		  
		 //apporach enhanced for loop
//		 for(WebElement checkbox:checkboxes) {
//			 checkbox.click();
//		 }
		 
		 //Select the last checkboxes
//		 for(int i=4;i<checkboxes.size();i++) {
//			 checkboxes.get(i).click();
//			 
//		 }
		 //select 1st 3 checkboxes
//		 for(int i=0;i<3;i++) {
//			 checkboxes.get(i).click();
//			 
//		 }
		 
		 //Unselect checkboxes if they are selected
		 for(int i=0;i<3;i++) {
			 checkboxes.get(i).click();
			 
		 }
		 Thread.sleep(5000);
		 
		 for(int i=0;i<checkboxes.size();i++) {
			 if(checkboxes.get(i).isSelected()) {
			 checkboxes.get(i).click();
			 }
		 }
		 
		 
		}

	}
