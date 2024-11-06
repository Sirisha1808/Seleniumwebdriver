package day38;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshots {

	public static void main(String[] args) throws InterruptedException {
     WebDriver driver = new ChromeDriver();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     
     driver.get("https://www.advantageonlineshopping.com/");
     driver.manage().window().maximize();
     Thread.sleep(5000);
     
     
     //1)Full page Screenshot
     TakesScreenshot ts = (TakesScreenshot)driver;//we can using type casting
     File sourcefile = ts.getScreenshotAs(OutputType.FILE);//it will return file type of object
    // File targetfile = new File("C:\\Users\\BP061\\seleniumwebdriver\\screenshots\\fullpage.png");
     
     File targetfile = new File(System.getProperty("user.dir")+"\\screenshots\\fullpage.png");//Screenshot will save dynamically
     sourcefile.renameTo(targetfile);//copy sourcefile to targetfile 
     
     
     //Screenshot of specific section
     WebElement popularItems = driver.findElement(By.xpath("//article[@id=\"popular_items\"]"));
     File sourcefile1 = popularItems.getScreenshotAs(OutputType.FILE);
     
	 File targetfile1 = new File(System.getProperty("user.dir")+"\\screenshots\\Specificsection.png");
     sourcefile1.renameTo(targetfile1);
    
     
     //Capture the screenshot of webelement
     WebElement logo = driver.findElement(By.xpath("//div[@class=\"logo\"]"));
     File sourcefile2 = logo.getScreenshotAs(OutputType.FILE);
     
	 File targetfile2 = new File(System.getProperty("user.dir")+"\\screenshots\\Specificelement.png");
     sourcefile2.renameTo(targetfile2);
     
     driver.quit();
     
	}

}
