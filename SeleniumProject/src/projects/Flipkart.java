package projects;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flipkart {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Documents\\Selenium drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		WebElement userName = driver.findElement(By.xpath("//*[@class='_2IX_2- VJZDxU']"));
		userName.sendKeys("gnrajarajann@gmail.com");
		WebElement pwd = driver.findElement(By.xpath("//*[@class='_2IX_2- _3mctLh VJZDxU']"));
		pwd.sendKeys("Welcome@123",Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			Thread.sleep(3000);		
		String oldWindow =  driver.getWindowHandle();
		//WebElement login = driver.findElement(By.xpath("//*[@class='_2KpZ6l _2HKlqd _3AWRsL']"));
		//login.click();
		WebElement search = driver.findElement(By.xpath("//*[@class='_3704LK']"));
		search.sendKeys("iphone13 pro",Keys.ENTER);
		//Thread.sleep(5000);
		
		WebElement iphone = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='APPLE iPhone 13 Pro (Gold, 256 GB)']")));
		iphone.click();
		Set<String> newWindow =  driver.getWindowHandles();
		for (String string : newWindow) {
			driver.switchTo().window(string);			
		}
		driver.close();
		driver.switchTo().window(oldWindow);
		WebElement account = driver.findElement(By.xpath("//*[text()='My Account']"));
		Actions mouse = new Actions(driver);
		mouse.moveToElement(account).perform();
		WebElement logout = driver.findElement(By.xpath("//*[text()='Logout']"));
		logout.click();
	}

	}


