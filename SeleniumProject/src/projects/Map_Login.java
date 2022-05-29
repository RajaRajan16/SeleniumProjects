package projects;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Map_Login {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Documents\\Selenium drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://maplogik.com/index.php/admin/login");
		driver.manage().window().maximize();
		WebElement UserName = driver.findElement(By.xpath("//*[@id='login-email']"));
		UserName.sendKeys("admin@gmail.com");
		WebElement password = driver.findElement(By.xpath("//*[@id='login-password']"));
		password.sendKeys("Admin@123",Keys.ENTER);
		WebElement course = driver.findElement(By.xpath("(//*[@class='menu-title text-truncate'])[2]"));
		course.click();
		WebElement addnew = driver.findElement(By.xpath("//*[@class='dt-button create-new btn btn-primary waves-effect waves-float waves-light']"));
		addnew.click();
		WebElement AddCourse = driver.findElement(By.xpath("//*[@id='course_name']"));
		AddCourse.click();
		File list_Course = new File("C:\\Users\\admin\\Desktop\\Map.xlsx");

	}

}
