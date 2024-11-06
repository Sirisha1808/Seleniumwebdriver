package day32;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//find total number of rows in table
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println(rows);
		
		//find total number of columns in table
		int cols = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println(cols);
		
		//Read data from specific row and column
		String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
		Thread.sleep(2000);
		System.out.println(bookName);
		
		//Read data from all rows and all Columns
		System.out.println("BookName"+"\t"+"Author"+"\t"+"Subject"+"\t"+"Price");
		for(int r = 2; r <= rows; r++) {  // Start from 2 because the first row is usually the header
            for(int c = 1; c <= cols; c++) {
                String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[" + c + "]")).getText();
                System.out.print(value + "\t");  // Use print instead of println for tab-separated values
            }
            System.out.println();  // Move to the next line after each row
        }
		
		//Print bookName whose author is Mukesh
		for(int r=2;r<=rows;r++) {
			String authorName = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr[" + r + "]//td[2]")).getText();
			//System.out.println(authorName);
			if(authorName.equals("Mukesh")) {
				String bookname = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[1]")).getText();
				System.out.println(bookname+"\t"+authorName);
			}
		}
		
		//find total price of all books
		int total = 0;
		for(int r=2;r<=rows;r++) {
			String price = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr[" + r + "]//td[4]")).getText();
			//System.out.println(price);
			total =total+Integer.parseInt(price);
		}
		
		System.out.println("Total price:" + total);
	}

}
