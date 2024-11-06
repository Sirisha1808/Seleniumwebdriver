package day38;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTesting {

	public static void main(String[] args) {
	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");//setting for headless mode of execution
		
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
		driver.quit();
		//driver.close();
		

	}

}
