package day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalStatements {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//		driver.get("https://parabank.parasoft.com/parabank/index.htm");
       
		//isDisplayed
//		WebElement logo = driver.findElement(By.xpath("//img[@alt='ParaBank']"));
//		System.out.println(logo.isDisplayed());
		
//		boolean status = driver.findElement(By.xpath("//img[@alt='ParaBank']")).isDisplayed();
//		System.out.println(status);
		
		driver.get("https://demo.nopcommerce.com/register");
		Thread.sleep(5000);
		System.out.println("Appliaction is opened");
		
		System.out.println("Bafore Selecting Male....");
		WebElement male_rd = driver.findElement(By.xpath("//input[@id=\"gender-male\"]"));//false
		System.out.println(male_rd.isSelected());
		
		WebElement female_rd = driver.findElement(By.xpath("//input[@id=\"gender-female\"]"));//true
		female_rd.click();//Selected femaleradio button
		Thread.sleep(5000);
		
		System.out.println("After Selecting Female....");
		System.out.println(female_rd.isSelected());
		
		boolean newsletter_checkbox = driver.findElement(By.xpath("//input[@id=\"Newsletter\"]")).isSelected();
		System.out.println("NewsLetter Checkbox status :"+newsletter_checkbox);
		
		
		
		
		
		
		driver.quit();
		
	}

}
