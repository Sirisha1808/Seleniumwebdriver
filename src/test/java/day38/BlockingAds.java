package day38;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BlockingAds {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		File file = new File("C:\\Users\\BP061\\AutomationFiles\\uBlock-Origin-Lite-Chrome-Web-Store.crx");
		options.addExtensions(file);
		
	    WebDriver driver = new ChromeDriver(options);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    driver.get("https://text-compare.com/");
	    driver.manage().window().maximize();

	}

}
