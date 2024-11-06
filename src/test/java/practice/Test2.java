package practice;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Test2 {
    WebDriver driver;
   
    String trainnum = "17255";
    LocalDate today = LocalDate.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	String formattedDate = today.format(formatter);
	
    @BeforeClass
    void openApp() {
    	driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.railyatri.in/live-train-status");
		driver.manage().window().maximize();
    }

    @Test(priority = 1) 
    void liveTracking() throws InterruptedException {
        // Ensure the header is visible
        boolean isHeaderVisible = driver.findElement(By.xpath("//h1[text()='Check Train Status']")).isDisplayed();
        System.out.println("Check Train Status Text is visible: " + isHeaderVisible);

        // Input train number and check status
        driver.findElement(By.xpath("//input[@placeholder='Select Train No.']")).sendKeys(trainnum);
        Thread.sleep(4000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(7000); 

        // Extract train name
        WebElement act_trainName = driver.findElement(By.xpath("(//div[@class='message_temp2__nRBhk']//div//div/p)[1]"));
        System.out.println("Train Name: " + act_trainName.getText());
        AssertJUnit.assertTrue((act_trainName.getText()).contains("NS LPI EXP"));
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        boolean continueLoop = true;
        int currentRowIndex = 0;

        while (continueLoop) {
            // Wait for the table to load and fetch rows
            WebElement tableBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody")));
            List<WebElement> rows = tableBody.findElements(By.xpath("./tr"));
            System.out.println(rows.size());

            // Check if we've processed all rows
            if (currentRowIndex >= rows.size()) {
                System.out.println("No more rows to table then Exiting loop.");
                break; // Exit if there are no more rows
            }

            // Click the first column of the current row
            WebElement firstColumn = rows.get(currentRowIndex).findElement(By.xpath("./td[1]")); // Access the first cell
            firstColumn.click();
            System.out.println("Clicked on row: " + (currentRowIndex + 1));
            
            WebElement station_Name = driver.findElement(By.xpath("//h1[1]"));
            System.out.println("Name of the Station: " + station_Name.getText());
            
            // Navigate back to the previous page
            driver.navigate().back();
            System.out.println("Navigated back to the previous page.");

            // Increment the row index to move to the next row
            currentRowIndex++;
        }
    }
    
    @AfterClass
    void testlogout() {
	driver.quit();
	
} 
}

