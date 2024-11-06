package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test3 {
	WebDriver driver;
	  int numberOfTrains;
	   
    @BeforeClass
    void openApp() {
    	driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.railyatri.in/live-train-status");
		driver.manage().window().maximize();
    }
    
    @Test(priority = 1) 
    void availabletrains() throws InterruptedException {
    	// Ensure the header is visible
        boolean isHeaderVisible = driver.findElement(By.xpath("//h1[text()='Check Train Status']")).isDisplayed();
        System.out.println("Train Status Text is visible: " + isHeaderVisible);
        
        //Click on Seat availability
        driver.findElement(By.xpath("(//ul/li/a[text()='Seat Availability'])[1]")).click();
        System.out.println("Seat Availability Text is clicked");
        
        //Ensure the header is visible
        boolean isHeader1Visible = driver.findElement(By.xpath("//h1[@class='title']")).isDisplayed();
        System.out.println("Check Seat Available Text is visible::  "+ isHeader1Visible);
        
        driver.findElement(By.xpath("//input[@id='from_stn_name']")).sendKeys("Secunderabad");
        
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
         
        //actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        driver.findElement(By.xpath("//ul/li//span[text()='Secunderabad Jn']")).click();
        
        driver.findElement(By.xpath("//input[@id='to_stn_name']")).sendKeys("RJY");
        
        driver.findElement(By.xpath("//ul/li//span[text()='Rajamundry']")).click();
        
        driver.findElement(By.id("station_submit")).click();
        System.out.println("Clicked on Check Trains button"); 
        WebElement numoftrains = driver.findElement(By.xpath("//div[@class='MuiBox-root css-d0okpx']/div[1]"));
        
       // Get the full text
        String fullText = numoftrains.getText();
        System.out.println("Full text: " + fullText);

        // Use regex to extract the number of trains
        String numberOfTrainsString = fullText.replaceAll("[^0-9]", ""); // Remove all non-numeric characters
        numberOfTrains = Integer.parseInt(numberOfTrainsString);
        System.out.println("Num of trains in this route: " + numberOfTrains);
        
       // Fetch the elements once before starting the loop
       List<WebElement> elements = driver.findElements(By.xpath("//div[@class='MuiTypography-root MuiTypography-body1 css-xc540o']//a[1]"));

        // Iterate through the elements using the number of trains
        for (int i = 0; i < numberOfTrains; i++) {
            System.out.println(elements.get(i).getText());
        }
        }
    
    
    @Test(priority=2)
    void getalltraindetails() {
        // Limit to the first 26 elements
        int limit = Math.min(driver.findElements(By.xpath("//div[@class='MuiTypography-root MuiTypography-body1 css-xc540o']//a[1]")).size(), numberOfTrains);
        System.out.println("Limited trains: " + limit);
        
        Assert.assertEquals(limit, numberOfTrains);
        
        for (int i = 0; i < limit; i++) { 
        	int j=i+1;
        	System.out.println("J Value:"+j);
        	
       //WebElement exp_starttime = driver.findElement(By.xpath("(//div[@class='MuiBox-root css-i9gxme']//p)["+j+"]//span[2]"));
      //System.out.println("Expected StartTime: "+ exp_starttime.getText());
        	
        // Re-fetch the elements each time before clicking
        	WebElement train =driver.findElement(By.xpath("(//div[@class='MuiTypography-root MuiTypography-body1 css-xc540o'])["+j+"]//a[1]"));
        	train.click();
        	

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement trainName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
            System.out.println("Name of the station: "+ i + " _ " +trainName.getText());
             
            WebElement act_starttime = driver.findElement(By.xpath("(//div[@class='MuiBox-root css-8mg22s'])[1]"));
            System.out.println("Actual StartTime: "+ act_starttime.getText());    
           
            driver.navigate().back();
            System.out.println("Navigated back to the previous page.");
            
        }
       
    }
    @AfterClass
    void shutdown(){
    	driver.quit();
    }

}
