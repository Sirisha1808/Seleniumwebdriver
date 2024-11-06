package day47pageObjectModel;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

//WIth out using Page Factory 

public class LogInPage {
	
	WebDriver driver;
	
	//Constractor:This will initiate the WebDriver
	LogInPage(WebDriver driver)//Invoking the constructor
		{
		this.driver=driver;
		
	}
	
	//Locators
	By txt_username_loc=By.xpath("//input[@name=\"username\"]");
	By txt_password_loc=By.xpath("//input[@name=\"password\"]");
	By btn_login_loc=By.xpath("//button[normalize-space()='Login']");
	
	//Action Method
	public void setUsername(String user) {
		driver.findElement(txt_username_loc).sendKeys(user);
	}
	
   public void setPassword(String pwd) {
	   driver.findElement(txt_password_loc).sendKeys(pwd);
   }
   
   public void clickLogin() {
	   driver.findElement(btn_login_loc).click();
   }
}
