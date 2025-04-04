package automationBlogSpot;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/* Test Cases
 * 1) Selecting custom check box
 * 2) Selecting all Check Boxes at once
 * 3) Selecting only last three check boxes
 * 4) Selecting even placed checkBoxes
 * 5) UnSelect the selected checkBoxes*/

public class HandlingCheckBoxes {
	WebDriver driver;
	JavascriptExecutor jse;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		// Initiate JavaScrip Executer
		jse = (JavascriptExecutor) driver;
	}

	@Test(priority = 1)
	public void customCheckBox() {
		// Approach 1
		WebElement box = driver.findElement(By.xpath("//div[@class='blog-posts hfeed']//div[4]//div[1]"));
		box.click();
		System.out.println("You clicked : " + box.getText());

		// Approach 2 (Using Java Script Executer)
//		jse.executeScript("arguments[0].click()", box);
//		System.out.println("You clicked : "+box.getText());
	}

	@Test(priority = 2)
	public void selectAllBoxes() {
		List<WebElement> checkBoxes = driver
				.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		for (WebElement cb : checkBoxes) {
			cb.click();
			System.out.println("You Clicked : " + cb.getAttribute("id"));
		}
	}

	@Test(priority = 3)
	public void lastThreeBoxes() {
		List<WebElement> checkBoxes = driver
				.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		for (int i = 4; i < checkBoxes.size(); i++) {
			checkBoxes.get(i).click();
			System.out.println("You Clicked : " + checkBoxes.get(i).getAttribute("id"));
		}
	}

	@Test(priority = 4)
	public void evenCheckBoxes() {
		List<WebElement> checkBoxes = driver
				.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		for (int i = 0; i < checkBoxes.size(); i++) {
			if (i % 2 == 0) {
				checkBoxes.get(i).click();
				System.out.println("You Clicked : " + checkBoxes.get(i).getAttribute("id"));
			}
		}
	}

	@Test(priority = 5)
	public void unselectSelectedBoxes() throws Exception {
		List<WebElement> checkBoxes = driver
				.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		for (int i = 0; i < checkBoxes.size(); i++) {
			if (i % 2 != 0) {
				checkBoxes.get(i).click();
			}
		}
		Thread.sleep(3000);
		for (int i = 0; i < checkBoxes.size(); i++) {
			if (checkBoxes.get(i).isSelected()) {
				checkBoxes.get(i).click();
			}
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
