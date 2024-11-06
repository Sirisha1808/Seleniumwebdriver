package day47pageObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
	
	WebDriver driver;
	
	@BeforeClass
	void setup() {
		
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    driver.manage().window().maximize();
	
	}
	
	@Test
	void testLogin() {
		
		//LogInPage lp=new LogInPage(driver);//Invoke the constructor
		LogInPage2 lp=new LogInPage2(driver);
		lp.setUsername("Admin");
		lp.setPassword("admin123");
		lp.clickLogin();
	    lp.allEle();
		
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@AfterClass
	void teardown() {
		driver.quit();
	}

}
