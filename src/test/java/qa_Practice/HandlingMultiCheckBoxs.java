package qa_Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingMultiCheckBoxs {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.qa-practice.com/elements/checkbox/mult_checkbox");
		driver.manage().window().maximize();
	}

	@Test
	public void multipleCheckBoxs() {
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//div[@id='div_id_checkboxes']//div//div"));
		for (WebElement box : checkBoxes) {
			box.click();
		}
		driver.findElement(By.xpath("//input[@id='submit-id-submit']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='result']")).getText());
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
