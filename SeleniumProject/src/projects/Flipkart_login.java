package projects;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flipkart_login {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Documents\\Selenium drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		WebDriverWait expwait=new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions actions=new Actions(driver);
		WebElement username=driver.findElement(By.xpath("//*[@class='IiD88i _351hSN']//input[@type='text']"));
		actions.sendKeys(username, "gnrajarajann@gmail.com").perform();
		WebElement password=driver.findElement(By.xpath("//*[@class='IiD88i _351hSN']//input[@type='password']"));
		actions.sendKeys(password, "Welcome@123").perform();

		WebElement login=driver.findElement(By.xpath("//*[@class='_2KpZ6l _2HKlqd _3AWRsL']"));
		actions.click(login).perform();

		expwait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@class='go_DOp']"), 4));

		WebElement searchtab= expwait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
		WebElement search_button=driver.findElement(By.xpath("//*[@class='L0Z3Pu']"));
		actions.sendKeys(searchtab, "iphone13 pro").click(search_button).build().perform();

		WebElement selectproduct= expwait.until(ExpectedConditions
				.elementToBeClickable(By.xpath
						("//*[@class='_36fx1h _6t1WkM _3HqJxg']/div[1]/div[2]/div[2]/descendant::a")));
		actions.click(selectproduct).perform();

		Set<String> new_window= driver.getWindowHandles();
		for (String to_new_window : new_window) {
			driver.switchTo().window(to_new_window);
		}

		WebElement myprofile=expwait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@class='go_DOp'][1]")));
		actions.clickAndHold(myprofile).perform();

		WebElement logout=expwait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@class='pO9syL undefined']/li[last()]/a")));
		actions.click(logout).perform();
	}

}


