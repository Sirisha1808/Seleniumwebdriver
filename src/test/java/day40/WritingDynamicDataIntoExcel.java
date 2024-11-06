package day40;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDynamicDataIntoExcel {

	public static void main(String[] args) throws IOException {
    FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myfile_dynamic.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("Data");
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter how many Rows?");
			int numofRows = sc.nextInt();
			
			System.out.println("Enter how many Cells?");
			int numofCells = sc.nextInt();
			
			for(int r=0;r<=numofRows;r++) {
				XSSFRow currentRow = sheet.createRow(r);
				
				for(int c=0;c<=numofCells;c++) {
					XSSFCell cell = currentRow.createCell(c);
					cell.setCellValue(sc.next());
					
				}
				
				
			}
		}
		workbook.write(file);//attached workbook to file
		 workbook.close();
	    file.close();
			
		System.out.println("File is created successfully......");
			
		

	}

}
