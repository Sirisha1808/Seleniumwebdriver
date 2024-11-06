package day45dataprovider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamTest {
WebDriver driver;
	
	@BeforeTest
	@Parameters({"browser","url"})
	void setup(String br, String url) throws InterruptedException {
		
		switch(br.toLowerCase()) {
		case"chrome": driver = new ChromeDriver(); break;
		case "edge" : driver = new EdgeDriver(); break;
		case "firefox": driver = new FirefoxDriver(); break;
		default: System.out.println("Invalid Browser"); return;
		}
		
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(6000);
		
	}
	
	@Test(priority=1)
	void testLogo() {
		
		boolean imgLogo= driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(imgLogo, true);
		
		
	}
	
	@Test(priority=2)
	void testTitle() {
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
		
	}
	
	@Test(priority=3)
	void testURL() throws InterruptedException {
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
	}

	@AfterTest
	
	void tearDown() {
		driver.quit();
	}
}
