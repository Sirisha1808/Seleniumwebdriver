package day37;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
	driver.manage().window().maximize();
	
	//Single file upload
	/*driver.findElement(By.xpath("//input[@id=\"filesToUpload\"]")).sendKeys("D:\\PTWebToursProject\\UserReg\\UserReg.csv");
	if(driver.findElement(By.xpath("//ul[@id='fileList']/li")).getText().equals("UserReg.csv")){
		System.out.println("File is sucessfully uploaded");
	}else{
		System.out.println("File is not uploaded");

	}*/
	
	//Multiple files uploaded
	String file1 ="D:\\\\PTWebToursProject\\\\UserReg\\\\UserReg.csv";
	String file2 ="D:\\PTWebToursProject\\UserAndNav\\LoginAndNav_Credentials.csv";
	
	driver.findElement(By.xpath("//input[@id=\"filesToUpload\"]")).sendKeys(file1+"\n"+file2);
	
	int numofFilesUploaded = driver.findElements(By.xpath("//ul[@id=\"fileList\"]/li")).size();
	//Validation 1: num of files
	if(numofFilesUploaded==2) {
		
		System.out.println("All files are uploaded");

	}else {
		System.out.println("Files are not uploaded or incorrect files uploaded");

	}
	
	//validation 2: file names
	if(driver.findElement(By.xpath("//ul[@id=\\\"fileList\\\"]/li[1]")).getText().equals("UserReg.csv")
			&& 	driver.findElement(By.xpath("//ul[@id=\\\"fileList\\\"]/li[2]")).getText().equals("LoginAndNav_Credentials.csv"))
	{
		System.out.println("File names are matching............");
	}
	else
	{
		System.out.println("File names are not matching............");
	}
	}
	}
	
	

