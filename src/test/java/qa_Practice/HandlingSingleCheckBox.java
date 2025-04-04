package qa_Practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingSingleCheckBox {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.qa-practice.com/elements/checkbox/single_checkbox");
		driver.manage().window().maximize();
	}
	
	@Test
	public void singleCheckBox() {
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
