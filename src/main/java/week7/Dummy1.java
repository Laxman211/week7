package week7;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Dummy1 {
	public void user_enters_valid_username_and_password() throws Exception {
		File src = new File("C:\\Users\\laxmanb\\Desktop\\Selenium"); 
	    FileInputStream fis = new FileInputStream(src);
	    XSSFWorkbook xsf = new XSSFWorkbook(fis); 
	    XSSFSheet sheet = xsf.getSheetAt(0);
	    String entry1 = sheet.getRow(1).getCell(1).getStringCellValue();
	    
	    System.out.println("The Data in the box"+ entry1);
	    xsf.close();
	}

}
