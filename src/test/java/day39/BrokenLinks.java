package day39;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("http://www.deadlinkcity.com/");
        driver.manage().window().maximize();
        
        //Capture all links fro website
        List<WebElement> links = driver.findElements(By.tagName("a"));

        System.out.println("Total number of links: " + links.size());
        
        int numofBrokenLinks=0;
        for (int i = 0; i < links.size(); i++) {
            WebElement link = links.get(i);
            String hrefAttributeValue = link.getAttribute("href");
            
            if (hrefAttributeValue == null || hrefAttributeValue.isEmpty()) {
                System.out.println("Link with index " + i + " has an empty or null href attribute.");
                continue;
            }
            //hit url to the server
            try {

          URL linkURL = new URL(hrefAttributeValue);//Converted href value into String to URL format
          HttpURLConnection conn=(HttpURLConnection) linkURL.openConnection();// open connection to the server
          conn.connect();//connect to server and sent request the server
          
          if(conn.getResponseCode()>=400) {
        	  System.out.println(hrefAttributeValue+"=======>It is a broken link");
        	  numofBrokenLinks++;
          }else {
        	  System.out.println(hrefAttributeValue+"=======>It is not a broken link");
          }
            }catch(Exception e) {
            }
            }
        System.out.println("Number of broken links:"+ numofBrokenLinks);
          
        }
        }
        
     
    