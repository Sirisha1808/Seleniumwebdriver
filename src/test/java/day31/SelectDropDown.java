package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement drpCountryEle = driver.findElement(By.xpath("//select[@id=\"country\"]"));
		Select drpCountry =new Select(drpCountryEle);
		//select option from dropdown
		//drpCountry.selectByVisibleText("France");//anytime we can use
		//drpCountry.selectByValue("india");//We can use only value attribute is present
		//drpCountry.selectByIndex(2);
		
		//captured number of options and all options from dropdown
		List<WebElement>options = drpCountry.getOptions();
		System.out.println("Number of option:"+ options.size());//10
		//printing the all options
		//enhanced for loop
//		for(WebElement option:options)
//		{
//			System.out.println(option.getText());
//		}
		for(int i=0;i<options.size();i++) {
			System.out.println(options.get(i).getText());
		}
		
		

	}

}
