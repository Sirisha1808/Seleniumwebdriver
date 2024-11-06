package day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSLocators {

	public static void main(String[] args) {
	 
		WebDriver driver= new ChromeDriver();
		
//		driver.get("https://www.advantageonlineshopping.com/#/");
//		driver.manage().window().maximize();//Maximize the browser window
	
		//Id- tag#Id (or) #ID
//		driver.findElement(By.cssSelector("svg#menuSearch")).click();
		
     	//driver.findElement(By.cssSelector("#menuSearch")).click();
		
		//ClassName as class="roboto-regular ng-pristine ng-valid ng-touched"
//		driver.findElement(By.cssSelector("input.roboto-regular")).sendKeys("Laptops");
//		//driver.findElement(By.cssSelector(".roboto-regular ")).sendKeys("Laptops");
		
		//tag attribute- tag[attribute="value"]
		driver.findElement(By.cssSelector("svg#menuSearch")).click();
		driver.findElement(By.cssSelector("input[placeholder=\"Search AdvantageOnlineShopping.com\"]")).sendKeys("Laptops");
		
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		driver.manage().window().maximize();
		
		//tag class attribute- tag.className[attribute="value"]
		//driver.findElement(By.cssSelector("input.oxd-input[placeholder='Username']")).sendKeys("Hello");
		
		

	}

}
