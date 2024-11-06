package practice;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {
	WebDriver driver;
	String trainnum ="17231";
	LocalDate today = LocalDate.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	String formattedDate = today.format(formatter);
	
    @Test(priority=1) 
	void openapp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.railyatri.in/live-train-status");
		driver.manage().window().maximize();
	}
    @Test(priority=2)
    void livetracking() throws InterruptedException {
    	//Thread.sleep(3000);
    	boolean txt1 = driver.findElement(By.xpath("//h1[text()='Check Train Status']")).isDisplayed();
    	System.out.println("Check Train Status Text is visible:"+txt1);
  
    	driver.findElement(By.xpath("//input[@placeholder='Select Train No.']")).sendKeys(trainnum);
    	//click on check status button
    	driver.findElement(By.xpath("//button[@type='submit']")).click();
    	Thread.sleep(7000); 
    	
    	String title = driver.getTitle();  
        Assert.assertTrue(title.contains("Narasapur - Nagarsol Express"));
    	
        WebElement dateElement = driver.findElement(By.xpath("//span[normalize-space()='Start Date " + formattedDate + "']"));
        String dateText = dateElement.getText();
        Assert.assertTrue(dateText.contains(formattedDate));
        Thread.sleep(2000);
        
        List<WebElement> elements = driver.findElements(By.xpath("//div[2]//div//div/div[2]/div[1]"));

        // Use a for loop to iterate through the elements and print their text
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }  
        WebElement presentStation = driver.findElement(By.xpath("(//img[@id=\"trainIcon\"]/following::div//div[2]/p)[1]"));
        System.out.println("PresentStation: "+presentStation.getText());
    	
    }
    
    @Test(priority=3)
    void testlogout() {
    	driver.quit();
    	
    } 

}
