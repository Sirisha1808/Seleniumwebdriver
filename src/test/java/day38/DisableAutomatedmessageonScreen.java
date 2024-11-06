package day38;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DisableAutomatedmessageonScreen {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});//remove the automated msg
		
		WebDriver driver = new ChromeDriver(options);
		
		//Open the Url
		driver.get("https://demo.opencart.com/");
		
		//Validate Title
		String act_title= driver.getTitle();
		
		if(act_title.equals("Your Store")) {
			System.out.println("Testcase Passes");
		}
		else {
			
			System.out.println("Testcase Failed");
		}
		//close the browser
		//driver.quit();
	}

}
