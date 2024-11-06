package day33;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DyanamicTablewithPagination {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.scrapingcourse.com/ecommerce/");
		driver.manage().window().maximize();
		
//		String s= "Showing 1–16 of 188 results";
//		System.out.println(s.substring(16,19));
//		
//		int startIndex = s.indexOf("f") + 2;
//		int endIndex = s.indexOf("r") - 1;
//
//		// Print the result
//		System.out.println(s.substring(startIndex, endIndex));
		
		String text = driver.findElement(By.xpath("(//p[@id='result-count'])[1]")).getText();
		int startIndex = text.indexOf("f") + 2;
		int endIndex = text.indexOf("r") - 1;
	
		int total_pages =Integer.parseInt(text.substring(startIndex, endIndex));
		System.out.println(total_pages);
		
		for(int p=2;p<=total_pages;p++) {
			if(p>1) {
				WebElement activePage = driver.findElement(By.xpath("(//ul//li//a[text()=" + p + "])[1]"));
				activePage.click(); 
			}
			//reading data from the data
			int numOfItems = driver.findElements(By.xpath("//ul[@id=\"product-list\"]//li")).size();
			System.out.println(numOfItems);
			
			for(int i=1;i<=numOfItems;i++) {
				 String productName = driver.findElement(By.xpath("(//ul[@id='product-list']//li)[" + i + "]//h2")).getText();
			        System.out.println("Product Name: " + productName);
			      
			}
			
		}
		
	}

}
