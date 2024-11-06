package day45dataprovider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	
	WebDriver driver;
	
	
	@BeforeClass
	void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Test(dataProvider="dp")
	void testLogin(String email, String pwd) throws InterruptedException {
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		Thread.sleep(3000);
		boolean statustxt= driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
		if(statustxt=true) {
			driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Logout']")).click();
			Assert.assertTrue(true);
		}else {
			Assert.fail();
		}

		
	}
	
	@AfterClass
	void tearDown() {
		driver.close();
		
	} 
	
	@DataProvider(name="dp",indices= {0,2,4})
	Object[][] loginData() {
		Object data[][]= {
				{"abcdtest@gmail.com","test@123"},
				{"xyz96@gmail.com","test012"},
				{"john96@gmail.com","test123"},
				{"pavan96@gmail.com","test@123"},
				{"johncanedy96@gmail.com","test"},
				
		};
		return data;
	}

}
