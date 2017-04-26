package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test1 {
	private WebDriver driver;

	@BeforeTest
	public void initDriver() throws Exception {
		System.out.println("Jenkins run started");
		System.setProperty("webdriver.chrome.driver", "C:/Work/libs/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void test_auto() throws Exception {
		final String searchKey = "Jenkins";
		System.out.println("Search " + searchKey + " in google");
		driver.get("http://www.google.com");
		Thread.sleep(10);
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys(searchKey);
		element.submit();
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h3/a)[1]")));
		//(new WebDriverWait(driver, 10)).until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.name("q"))));
	}

	@AfterTest
	public void quitDriver() throws Exception {
		driver.quit();
	}
}