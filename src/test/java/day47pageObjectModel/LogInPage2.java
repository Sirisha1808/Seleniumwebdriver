package day47pageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

//Using PageFactory
public class LogInPage2 {
	
	WebDriver driver;
	
	//Constractor:This will initiate the WebDriver
	LogInPage2(WebDriver driver)//Invoking the constructor
		{
		this.driver=driver;
		PageFactory.initElements(driver,this); //Mandatory;
		
	}
	
	//Locators
	/*By txt_username_loc=By.xpath("//input[@name=\"username\"]");
	By txt_password_loc=By.xpath("//input[@name=\"password\"]");
	By btn_login_loc=By.xpath("//button[normalize-space()='Login']");*/
	
	//@FindBy(xpath="//input[@name='username']") 
	@FindBy(how=How.XPATH,using="//input[@name='username']")
	WebElement txt_username;
	
	@FindBy(xpath="//input[@name='password']") 
	WebElement txt_password;
	
	@FindBy(xpath="//button[normalize-space()='Login']") 
	WebElement btn_login;
	
	//Capture groupof elements in a webpage
	@FindBy(tagName="a")
	List<WebElement> Links;
	
	
	//Action Method
	public void setUsername(String user) {
		txt_username.sendKeys(user);
	}
	
   public void setPassword(String pwd) {
	   txt_password.sendKeys(pwd);
   }
   
   public void clickLogin() {
	   btn_login.click();
   }
   public void allEle() {
	   System.out.println(Links.size());
	   for (WebElement link : Links) {
	        String linkText = link.getText(); // Get the visible text of the link
	        String linkHref = link.getAttribute("href"); // Get the URL of the link
	        System.out.println("Link Text: " + linkText + ", URL: " + linkHref);
	    }
	   
   }
}
