package day36;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabsAndWindows {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.opencart.com");
		driver.manage().window().maximize();
		
		//Introduce in SELENIUM4.X versions
		//driver.switchTo().newWindow(WindowType.TAB);//opens the new Tab
		driver.switchTo().newWindow(WindowType.WINDOW);//opens the new Window
		
		driver.get("https://orangehrm.com/");
		

	}

}
