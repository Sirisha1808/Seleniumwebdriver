package day38;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EnableExtensionsAtRunTime {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		File file = new File("C:\\Users\\BP061\\AutomationFiles\\SelectorsHub-XPath-Helper-Chrome-Web-Store.crx");
		options.addExtensions(file);
				
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Open the Url
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		
		//Validate Title
		String act_title= driver.getTitle();
		
		if(act_title.equals("Text Compare! - Find differences between two text files")) {
			System.out.println("Testcase Passes");
		}
		else {
			
			System.out.println("Testcase Failed");
		}
	}

}
