package DemoQA;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingCheckBoxes {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/checkbox");
//		driver.manage().window().maximize();
	}

	@Test
	public void clickRootCheckBoxes() {
		// Expand root checks
		driver.findElement(By.xpath("//button[@title='Toggle']//*[name()='svg']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();

		List<WebElement> rootBoxes = driver.findElements(By.xpath(
				"//ol//li//ol//li[@class=\"rct-node rct-node-parent rct-node-collapsed\"]//span[@class=\"rct-title\"]"));
		for (WebElement rb : rootBoxes) {
			String selectedBox = null;
			if (rb.isSelected()) {
				selectedBox = rb.getText();
			}
			System.out.println(selectedBox + "is selected box");
		}
	}

	@Test
	public void clickAllCheckBoxes() {
		// Expand all Boxes
		driver.findElement(By.xpath("//button[@title='Expand all']//*[name()='svg']//*[name()='path' and contains(@d,'M19 3H5c-1')]")).click();	
		driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
		List<WebElement> rootBoxes = driver.findElements(By.xpath("//ol//li//ol//li//span[@class=\\\"rct-title\\\"]"));
		for (WebElement rb : rootBoxes) {
			String selectedBox = null;
			if (rb.isSelected()) {
				selectedBox = rb.getText();
			}
			System.out.println(selectedBox + "is selected box");
		}
	}

	@Test
	public void clickSetBySetBoxes() {

	}
	
	@Test
	public void clickBoxWithName() {
		
	}
	
	@Test
	public void clickRandomBox() {
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
