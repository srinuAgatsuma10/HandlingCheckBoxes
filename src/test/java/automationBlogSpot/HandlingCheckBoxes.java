package automationBlogSpot;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/* Test Cases
 * 1) Selecting custom check box
 * 2) Selecting all Check Boxes at once
 * 3) Selecting only last three check boxes
 * 4) Selecting only Starting three checkBoxes
 * 5) UnSelect the selected checkBoxes*/

public class HandlingCheckBoxes {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/checkbox");
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void customCheckBox() {
		
	}
	
	@Test(priority = 2)
	public void selectAllBoxes() {
		
	}
	
	@Test(priority = 3)
	public void lastThreeBoxes() {
		
	}
	
	@Test(priority = 4)
	public void firstTheeBoxes() {
		
	}
	
	@Test(priority = 5)
	public void unselectSelectedBoxes() {
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
