package day46Listeners;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


//@Listeners(day46Listeners.MyListners.class)
public class OrangeHRM {
	
	WebDriver driver;
	

	@BeforeClass
	void setup() throws InterruptedException {
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		
	}
	@Test(priority=1)
	void testLogo() {
		
		boolean imgLogo= driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(imgLogo, true);
		
		
	}
	
	
	@Test(priority=2)
	void testURL() throws InterruptedException {
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/");
		
	}
	
	@Test(priority=3,dependsOnMethods= {"testURL"})
	void testTitle() {
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
		
	}

	@AfterTest
	
	void tearDown() {
		driver.quit();
	}
}
