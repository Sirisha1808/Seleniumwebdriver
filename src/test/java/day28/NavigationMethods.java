package day28;


import java.net.MalformedURLException;
//import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethods {

	
	public static void main(String[] args) throws MalformedURLException {
		
		WebDriver driver = new ChromeDriver();
		
//		driver.get("https://demo.nopcommerce.com/");//accepts URL only in the String format
//		driver.manage().window().maximize();
		
		//naviagte().to() method accepts URL both formates like String and URL object format
	
//		URL myurl =new URL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		driver.navigate().to(myurl);
		

		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.navigate().to("https://www.advantageonlineshopping.com/");
		
		driver.navigate().back();
		
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().forward();
		
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().refresh();
		
		


	}

}
