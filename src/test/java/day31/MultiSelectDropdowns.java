package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiSelectDropdowns {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();//open dropdown options
		
		//Select single option
		driver.findElement(By.xpath("//input[@value='Java']")).click();
		
		//Capture all the options and find the size
		List<WebElement> options= driver.findElements(By.xpath("//ul//label"));
		
		System.out.println(options.size());
		
		for(WebElement option:options)
		{
			System.out.println(option.getText());

		}
		
		//Select multiple options
		
		for(WebElement option:options)
		{
			String course = option.getText();
			if(course.equals(" Java") || course.equals("MySQL")){
				option.click();
			}
			

		}
	}

}
