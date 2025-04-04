package theInternetHerokuApp;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		List<WebElement> boxes = driver.findElements(By.xpath("//form[@id='checkboxes']//input"));
		for(WebElement box : boxes) {
			if(box.isSelected()) {
				System.out.println("The box is alredy selected");
			}
			else {
				box.click();
			}
		}			
	}

	@Test
	public void testCaseTwo() {

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
