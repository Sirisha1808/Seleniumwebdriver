package day41;

import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FDCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
		driver.manage().window().maximize();
		
		String filePath = System.getProperty("user.dir")+"\\testdata\\caldata.xlsx"; 
		
		int rows=ExcelUtils.getRowCount(filePath, "Sheet1");
		System.out.println("Number of rows:"+rows);
		 for (int i = 1; i <= rows; i++) {
             // Read data from excel
             String princiAmount = ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
             String rateofInterest = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
             String per1 = ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
             String per2 = ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
             String fre = ExcelUtils.getCellData(filePath, "Sheet1", i, 4);
             String exp_mvalue = ExcelUtils.getCellData(filePath, "Sheet1", i, 5);
             
             // Pass data into application
             driver.findElement(By.id("principal")).sendKeys(princiAmount);
             driver.findElement(By.id("interest")).sendKeys(rateofInterest);
             driver.findElement(By.id("tenure")).sendKeys(per1);
             
             Select perdrp = new Select(driver.findElement(By.id("tenurePeriod"))); 
             perdrp.selectByVisibleText(per2);
             
             Select fredrp = new Select(driver.findElement(By.id("frequency")));
             fredrp.selectByVisibleText(fre);
             
             // Click on Calculate button
             WebElement calculateButton = driver.findElement(By.xpath("//div[@class='CTR PT15']//a[1]"));
             ((JavascriptExecutor) driver).executeScript("arguments[0].click();", calculateButton);
             
             // Wait for result to be visible
             WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
             WebElement resultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resp_matval")));
             
             // Validations
             String act_mvalue = resultElement.findElement(By.tagName("strong")).getText();
             if (Double.parseDouble(exp_mvalue) == Double.parseDouble(act_mvalue)) {
                 System.out.println("Test Passed");
                 ExcelUtils.setCellData(filePath, "Sheet1", i, 7,"Passed");
                 ExcelUtils.fillGreenColor(filePath, "Sheet1", i, 7);
             } else {
                 System.out.println("Test Failed");
                 ExcelUtils.setCellData(filePath, "Sheet1", i, 7,"Failed");
                 ExcelUtils.fillRedColor(filePath, "Sheet1", i, 7);
             }

             // Click on the Clear button
             WebElement clearBtn = driver.findElement(By.xpath("//a//img[@class='PL5']"));
             ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clearBtn);
         } // End of loop

     
         driver.quit();
	}
 }
