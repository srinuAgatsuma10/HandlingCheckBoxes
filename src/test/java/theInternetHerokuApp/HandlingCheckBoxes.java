package theInternetHerokuApp;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingCheckBoxes {

	/* Test Cases
	 * 1) Select all check boxes and get their name.
	 * 2) If box is selected then return "Box is already Selected."*/
	
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		driver.manage().window().maximize();
	}

	@Test
	public void testCaseOne() {

	}

	@Test
	public void testCaseTwo() {

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
