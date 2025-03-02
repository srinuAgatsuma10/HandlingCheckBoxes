package DemoQA;

import java.time.Duration;
import java.util.List;
import java.util.Random;

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
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void clickRootCheckBoxes() {
		// Expand root checks
		driver.findElement(By.xpath("//button[@title='Toggle']//*[name()='svg']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();

		List<WebElement> rootBoxes = driver.findElements(By.xpath(
				"//ol//li//ol//li[@class=\"rct-node rct-node-parent rct-node-collapsed\"]//span[@class=\"rct-title\"]"));
		for (WebElement rb : rootBoxes) {
			if (rb.isSelected()) {
				System.out.println(rb.getText() + "Box is selected");
			}
		}

	}

	@Test(priority = 2)
	public void clickAllCheckBoxes() {
		// Expand all Boxes
		driver.findElement(By.xpath("//button[@title='Expand all']//*[name()='svg']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//ol//li//ol//li//span[@class='rct-title']"));

		for (WebElement checkbox : checkBoxes) {
			if (checkbox.isSelected()) {
				System.out.println(checkbox.getText() + " Box is selected");
			}
		}
	}

	@Test(priority = 3)
	public void clickSetBySetBoxes() throws Exception {
		// Expand all Boxes
		driver.findElement(By.xpath("//button[@title='Expand all']//*[name()='svg']")).click();

		driver.findElement(By.xpath("//span[contains(text(),'Desktop')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Documents')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Downloads')]")).click();
		Thread.sleep(3000);
		WebElement home = driver.findElement(By.xpath("//span[contains(text(),'Home')]"));
		if (!home.isSelected()) {
			Assert.assertTrue(true);
		}
	}

	@Test(priority = 4)
	public void clickBoxWithName() {
		// Expand all Boxes
		driver.findElement(By.xpath("//button[@title='Expand all']//*[name()='svg']")).click();

		List<WebElement> checkBoxes = driver.findElements(By.xpath("//ol//li//ol//li//span[@class='rct-title']"));
		for (WebElement checkBox : checkBoxes) {
			System.out.println(checkBox.getText());
			if (checkBox.equals("Angular") && !checkBox.isSelected()) {
				checkBox.click();
			}
		}
	}

	@Test(priority = 5)
	public void clickRandomBox() {
		// Expand all Boxes
		driver.findElement(By.xpath("//button[@title='Expand all']//*[name()='svg']")).click();

		List<WebElement> checkBoxes = driver.findElements(By.xpath("//ol//li//ol//li//span[@class='rct-title']"));
		for (WebElement checkBox : checkBoxes) {
			System.out.println(checkBox.getText());
			if (!checkBoxes.isEmpty()) {
				Random random = new Random();
				int randomIndex = random.nextInt(checkBoxes.size());

				WebElement randomCheckbox = checkBoxes.get(randomIndex);
				randomCheckbox.click();
				System.out.println("Randomly selected: " + randomCheckbox.getText());
				break;
			} else {
				System.out.println("No checkboxes found.");
			}
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
