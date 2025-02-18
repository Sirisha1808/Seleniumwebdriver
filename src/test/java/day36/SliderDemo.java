package day36;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {

	public static void main(String[] args) {
	  
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
	   Actions act= new Actions(driver);
	   
	   
		//Min Slider
		WebElement min_slider = driver.findElement(By.xpath("//div[@class=\"price-range-block\"]//span[1]"));
		
		System.out.println("Location  of min slider before moving:"+min_slider.getLocation());//(59, 250)=(x,y);
		
		act.dragAndDropBy(min_slider, 100, 250).perform();

		System.out.println("Locatino  of min slider after moving:"+min_slider.getLocation());//(160, 250)=(x,y);
		
		//max Slider
       WebElement max_slider = driver.findElement(By.xpath("//div[@class=\"price-range-block\"]//span[2]"));
		
		System.out.println("Location  of min slider before moving:"+max_slider.getLocation());//(542, 250)=(x,y);
		
		act.dragAndDropBy(max_slider, -142, 250).perform();
		System.out.println("Location  of min slider after moving:"+max_slider.getLocation());
	}

}
