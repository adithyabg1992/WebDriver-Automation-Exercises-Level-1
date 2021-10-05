import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class AutomationDriver {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","D:\\Qualitest\\Selinum\\Introduction\\chromedriver.exe");

		WebDriver driver = new ChromeDriver(); 
		driver.get("http://www.qaclickacademy.com/practice.php"); 

		AutomationDriver.exerciseone(driver); 
		AutomationDriver.exercisetwo(driver);
		AutomationDriver.exercisethree(driver);
		AutomationDriver.exercisefour(driver);
		AutomationDriver.exercisefourPointOne(driver);
		AutomationDriver.exercisefourPointTwo(driver);
		AutomationDriver.exerciseFive(driver);
		AutomationDriver.exerciseSix(driver);
		AutomationDriver.exerciseSeven(driver);
		AutomationDriver.exerciseEight(driver);
		AutomationDriver.exerciseNine(driver);

	}

	static void exerciseone(WebDriver driver) throws InterruptedException {

		driver.findElement(By.xpath("//*[@value='radio1']")).click(); 
		Assert.assertTrue(driver.findElement(By.xpath("//*[@value='radio1']")).isSelected());
		Thread.sleep(1000); 
		driver.findElement(By.xpath("//*[@value='radio2']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@value='radio2']")).isSelected());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@value='radio3']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@value='radio3']")).isSelected());

	}

	static void exercisetwo(WebDriver driver) throws InterruptedException {
		driver.findElement(By.id("autocomplete")).sendKeys("United State");
		List<WebElement> autoSuggest = driver.findElements(By.xpath("//*[@id=\"ui-id-1\"]"));
		Thread.sleep(3000);
		for (WebElement a : autoSuggest) {
			System.out.println("Values are = " + a.getText());
			if (a.getText().equalsIgnoreCase("United State"))
				;
			a.click();
			break;
		}

	}

	static void exercisethree(WebDriver driver) throws InterruptedException {
		driver.findElement(By.name("dropdown-class-example")).click(); 
		driver.findElement(By.xpath("//option[@value='option1']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//option[@value='option1']")).isSelected());
        Thread.sleep(2000);
		driver.findElement(By.xpath("//option[@value='option2']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//option[@value='option2']")).isSelected());
        Thread.sleep(2000);
		driver.findElement(By.xpath("//option[@value='option3']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//option[@value='option3']")).isSelected());
	}

	static void exercisefour(WebDriver driver) throws InterruptedException { 

		driver.findElement(By.name("checkBoxOption1")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("checkBoxOption1")).click();
		Assert.assertFalse(driver.findElement(By.name("checkBoxOption1")).isSelected());

		driver.findElement(By.name("checkBoxOption2")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("checkBoxOption2")).click();
		Assert.assertFalse(driver.findElement(By.name("checkBoxOption2")).isSelected());

		driver.findElement(By.name("checkBoxOption3")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("checkBoxOption3")).click();
		Assert.assertFalse(driver.findElement(By.name("checkBoxOption3")).isSelected());
	}

	static void exercisefourPointOne(WebDriver driver) throws InterruptedException { 

		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

		for (int i = 0; i < checkboxes.size(); i++) {
			checkboxes.get(i).click();

		}
	}

	static void exercisefourPointTwo(WebDriver driver) throws InterruptedException { 

		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

		for (int i = 0; i < checkboxes.size(); i++) {
			checkboxes.get(i).click();

		}
	}

	static void exerciseFive(WebDriver driver) throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"openwindow\"]")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		
		System.out.println(
		driver.findElement(By.xpath("//h3[contains(text(),'An Academy to learn Everything about Testing')]")).getText());
		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(parent);
		System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Practice Page')]")).getText());
		Thread.sleep(2000);
	}

	static void exerciseSix(WebDriver driver) throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\'opentab\']")).click();
		Set<String> windows1 = driver.getWindowHandles();
		// System.out.println(windows);
		Iterator<String> it = windows1.iterator();
		String parent1 = it.next();
		String child1 = it.next();
		driver.switchTo().window(parent1);
		// Set<String> p = driver.getWindowHandles();
		// System.out.println(p);
		driver.switchTo().window(child1);
		Thread.sleep(5000);
		// Set<String> c = driver.getWindowHandles();
		// System.out.println(c);
		driver.close();
		//driver.close();
		driver.switchTo().window(parent1);
		// Assert.assertTrue(windows.equals(p));
	}

	static void exerciseSeven(WebDriver driver) throws InterruptedException {
//	driver.switchTo().alert() ;

		WebElement element = driver.findElement(By.xpath("//*[@id=\"name\"]"));
		element.sendKeys("john");
		System.out.println(element.findElement(By.xpath("//input[@name ='enter-name']")));
		driver.findElement(By.xpath("//*[@id=\"alertbtn\"]")).click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();

	}

	static void exerciseEight(WebDriver driver) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(5000);
		List<WebElement> table = driver.findElements(By.className("table-display"));

		for (int i = 0; i < table.size(); i++) {
			Assert.assertTrue(true, table.get(i).getText());
			System.out.println(table.get(i).getText());

		}

	}

	static void exerciseNine(WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(5000);
		Actions a = new Actions(driver);
		// WebElement move = driver.findElement(By.xpath("//button[@id='mousehover']"));
		// a.moveToElement(move).click().build().perform();

		a.moveToElement(driver.findElement(By.xpath(" //button[@id='mousehover']"))).click().build().perform();
		Thread.sleep(5000);
		// WebElement move1 =
		// driver.findElement(By.id("input[id='twotabsearchtextbox']"));
		a.moveToElement(driver.findElement(By.xpath(" //a[contains(text(),'Top')]"))).click().build().perform();
		;

	}
}
