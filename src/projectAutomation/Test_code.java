package projectAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.*;

public class Test_code {
	Excelutilities file = new Excelutilities();
	helper call = new helper();
	public WebDriver driver;
	public String name = "kishore";

	public void open_browser(String browser) throws Exception {
		call.go_to(browser);
		driver = call.getDriver();
		System.out.println("Testing application in :" + browser);
	}

	public void toclose_browser() {
		call.close();
		System.out.println("Browser closed");
	}

	public void click_on_menu(String para1, String para2) throws InterruptedException {
		call.navigate_to(para1, para2);
		Thread.sleep(10);
	}

	public void click_on_menu(String para1) throws InterruptedException {
		Thread.sleep(10);
		call.navigate_to(para1);

	}

	public void excel_file(String Path, String Sheetname) throws Exception {
		file.getExcelFile(Path, Sheetname);
	}

	public void toSelectDeparturePlace(String Place) throws Exception {
		String dep_Place = file.getCellData(Place);
		System.out.println("Depature place: " + dep_Place);
		WebElement departure_field = driver.findElement(By.xpath("//Input[@placeholder='Select a Departure City']"));
		departure_field.sendKeys(dep_Place);
	}

	public void toSelectArrivalPlace(String Place) throws Exception {
		String arr_Place = file.getCellData(Place);
		System.out.println("Arrival place: " + arr_Place);
		WebElement arrival_field = driver.findElement(By.xpath("//Input[@placeholder='Select an Arrival City']"));
		arrival_field.sendKeys(arr_Place);
	}

	public void toSelectModeOfTransport(String mode) throws Exception {
		String mode_Transport = file.getCellData(mode);
		// WebDriver driver = call.getDriver();
		System.out.println(driver);
		WebElement checkbox = driver.findElement(By.xpath("//Input[@name='" + mode_Transport + "']"));
		checkbox.click();
	}

	public void toClickButton(String buttonName) throws InterruptedException {
		WebElement button = driver.findElement(By.xpath(".//*[@id='BookSearchSubmit']"));
		button.click();
		Thread.sleep(2000);
		System.out.println("Button clicked");
	}

	public String toValidateMessage() {
		// Alert alert = driver.switchTo().alert();
		// String alertMsg = alert.getText();
		// String popupHandler = driver.getWindowHandle();
		// driver.switchTo().window(popupHandler);
		String alertMsg = driver.findElement(By.xpath("html/body/div[13]/div/div/div[1]/div/span")).getText();
		System.out.println(alertMsg);
		return alertMsg;
	}

}
