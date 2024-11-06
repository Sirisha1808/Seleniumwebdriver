package day21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {

	public static void main(String[] args) {
		//ChromeDriver driver = new ChromeDriver();
		//chrome browser
		//WebDriver driver = new ChromeDriver(); //upcasting
		//edge browser
		WebDriver driver = new ChromeDriver();
		
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
