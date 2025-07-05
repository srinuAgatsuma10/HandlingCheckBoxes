package tutorialsPoint;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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

	// Main level 1

	@Test(priority = 1)
	public void clickRootCheckboxes1() {
		driver.findElement(By.xpath("//input[@id='c_bs_1']")).click();
		driver.findElement(By.xpath("//li[@id='bs_1']//span[@class='plus']")).click();
		WebElement subLevel1 = driver.findElement(By.xpath("//input[@id='c_bf_1']"));
		WebElement subLevel2 = driver.findElement(By.xpath("//input[@id='c_bf_2']"));
		if(subLevel1.isSelected() && subLevel2.isSelected()) {
			Assert.assertTrue(true);
		}
	}

//	@Test(priority = 2)
	public void clickLastLevelBoxes1() {

	}

	// Main level 2

//	@Test(priority = 3)
	public void clickRootCheckboxes2() {

	}

//	@Test(priority = 4)
	public void clickLastLevelBoxes2() {

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
