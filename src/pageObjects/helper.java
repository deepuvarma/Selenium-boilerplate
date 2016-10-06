package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class helper {
	public WebDriver driver = null;

	// To open the website
	public void go_to(String browser) throws InterruptedException {
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser == "chrome") {
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://www.railnewzealand.com");

	}

	public WebDriver getDriver() {
		return driver;
	}

	// To navigate to menu with submenu
	public void navigate_to(String menuItem, String subMenu) {
		WebElement element = driver.findElement(By.id("navbar")).findElement(By.partialLinkText(menuItem));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.partialLinkText(subMenu)).click();
	}

	// To navigate to menu without submenu
	public void navigate_to(String menuItem) {
		WebElement element = driver.findElement(By.id("navbar")).findElement(By.partialLinkText(menuItem));
		element.click();
	}

	// To close the browser
	public void close() {
		driver.quit();
	}

}
