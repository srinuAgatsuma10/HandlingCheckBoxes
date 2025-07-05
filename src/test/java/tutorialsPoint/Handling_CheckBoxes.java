package tutorialsPoint;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Handling_CheckBoxes {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.tutorialspoint.com/selenium/practice/check-box.php");
		driver.manage().window().maximize();
	}

	// Main level one
	
	@Test(priority = 1)
	public void clickRootCheckboxes1() {
		
	}
	
	@Test(priority = 2)
	public void clickLastLevelBoxes1() {
		
	}
	
	// Main level 2
	
	@Test(priority = 3)
	public void clickRootCheckboxes2() {
		
	}
	
	@Test(priority = 4)
	public void clickLastLevelBoxes2() {
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
