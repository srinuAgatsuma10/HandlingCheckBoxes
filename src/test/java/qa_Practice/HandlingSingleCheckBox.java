package qa_Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingSingleCheckBox {
	WebDriver driver;
	JavascriptExecutor jse;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.qa-practice.com/elements/checkbox/single_checkbox");
		driver.manage().window().maximize();
		// Initiate Java Script Executor
		jse = (JavascriptExecutor) driver;
	}
	
	@Test
	public void singleCheckBox() {
		// Approach One
		WebElement checkBox = driver.findElement(By.xpath("//input[@class='form-check-input']"));
		if(checkBox.isSelected()) {
			System.out.println(checkBox.getAttribute("value")+" Box is already Selected");
		}
		else {
			checkBox.click();
			System.out.println(checkBox.getAttribute("value")+" Box is Selected now.");
		}
		
		// Approach Two
//		jse.executeScript("arguments[0].click()", checkBox);
//		System.out.println(checkBox.getAttribute("value")+" Box is Selected now.");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
