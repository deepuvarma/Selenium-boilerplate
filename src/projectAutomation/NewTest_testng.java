package projectAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class NewTest_testng extends Test_code {
	Test_code page = new Test_code();

	@Test(description = "To validate select date popup")
	@Parameters({ "testdatapath", "sheet", "Validation_statement" })

	public void getCellData(String Path, String Sheet, String org_statement) throws Exception {
		page.excel_file(Path, Sheet);
		page.toSelectModeOfTransport("ModeOfTransport");
		page.toSelectDeparturePlace("Departure");
		page.toSelectArrivalPlace("Arrival");
		page.toClickButton("button");
		String statement = page.toValidateMessage();
		Assert.assertEquals(org_statement, statement, "Passed");
	}

	// passing browser value from xml and opening the URL
	@Parameters({ "browser" })
	@BeforeTest(description = "to open web application in specified browser")
	public void beforeTest(String browser) throws Exception {
		page.open_browser(browser);
	}

	// To close the browser
	@AfterTest
	public void afterTest() {
		page.toclose_browser();

	}
}
