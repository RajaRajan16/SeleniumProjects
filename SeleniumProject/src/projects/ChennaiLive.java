package projects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChennaiLive {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\Documents\\Selenium drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.livechennai.com/gold_silverrate.asp");
		WebElement table = driver.findElement(By.xpath("(//table[@class='table-price'])[2]"));
		List<WebElement> row = table.findElements(By.tagName("tr"));
		// System.out.println(row.size());
		for (int i = 0; i < row.size(); i++) {
			List<WebElement> column = row.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < column.size(); j++) {
				String text = column.get(j).getText();
				System.out.print(text + " ");
			}
			System.out.println();
		}
		System.out.println("\n");
		// WebElement table2 =
		// driver.findElement(By.xpath("(//table[@class='table-price'])[4]"));
		WebElement silver = driver.findElement(By.xpath("(//table[@class='table-price'])[4]"));
		// for (WebElement webElement : column) {
		// System.out.println(webElement.getText());
		System.out.println(silver.getText());
	}

}
