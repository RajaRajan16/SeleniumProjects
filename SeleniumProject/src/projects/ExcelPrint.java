// Author --> G.N.RajaRajan
// Description --> requirment to store gold & silver datas in excel format from live chennai.com

package projects;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelPrint {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Documents\\Selenium drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.livechennai.com/gold_silverrate.asp");
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet1=workbook.createSheet("Gold Rate");
		XSSFSheet sheet2=workbook.createSheet("Sliver Rate");
		WebElement table = driver.findElement(By.xpath("(//table[@class='table-price'])[2]"));
		List<WebElement> row = table.findElements(By.tagName("tr"));
		//System.out.println(row.size());
		for(int i =0; i<row.size();i++) {
			XSSFRow rowvalue=sheet1.createRow(i);
			List<WebElement> column = row.get(i).findElements(By.tagName("td"));
			for(int j=0;j<column.size();j++) {
				String text  = column.get(j).getText();
				rowvalue.createCell(j).setCellValue(text);
}
			
		}
		WebElement table1 = driver.findElement(By.xpath("(//table[@class='table-price'])[4]"));
		List<WebElement> row1 = table1.findElements(By.tagName("tr"));
		//System.out.println(row.size());
		for(int i =0; i<row1.size();i++) {
			XSSFRow rowvalue=sheet2.createRow(i);
			List<WebElement> column1 = row1.get(i).findElements(By.tagName("td"));
			for(int j=0;j<column1.size();j++) {
				String text  = column1.get(j).getText();
				rowvalue.createCell(j).setCellValue(text);
			}
		}
		File file= new File("C:\\Users\\admin\\Desktop\\output.xlsx");
		FileOutputStream outputStream= new FileOutputStream(file);
		workbook.write(outputStream);
		workbook.close();
		driver.quit();
	}

}
	
