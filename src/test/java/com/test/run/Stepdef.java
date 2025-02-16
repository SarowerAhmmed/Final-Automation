package com.test.run;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import com.excel.manager.ExcelManager;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.BaseConfig;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdef {
	WebDriver driver;
	SeleniumPageFactory pf;
	BaseConfig bc;
	ExcelManager obj;
	@Given("Open browser")
	public void open_browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}// end

	@Given("Go to application")
	public void go_to_application() {
		bc = new BaseConfig();
		driver.get(bc.getConfig("URL"));

	}

	@When("Put user {string}")
	public void put_user(String user) {
		pf = new SeleniumPageFactory(driver);

		pf.getUser().sendKeys(bc.getConfig(user));
	}

	@When("Put pass {string}")
	public void put_pass(String pass) {

		pf.getPass().sendKeys(bc.getConfig(pass));
	}

	@When("Click login button")
	public void click_login_button() {
		pf.getLoginBtn().click();

		// Found Alert
		// Selenium 3 = isAlertpresent()
		// Selenium 4 = Explicit wait or Web driver wait (isAlertpresent())

		// handle with try catch
		try {// is alert present then go below code
			Alert alertObj = driver.switchTo().alert();
			String alertTextinfo = alertObj.getText();
			System.out.println(alertTextinfo);
			alertObj.accept();// click alert OK btn
			// alertObj.dismiss();// click alert cancel btn
		} catch (NoAlertPresentException ex) {// alert not present
			System.out.println("Alert is NOT Displayed");
		}

	}
	@When("Put user {string} from Excel")
	public void put_user_from_Excel(String rowAndCol) {
		pf = new SeleniumPageFactory(driver);
		 obj = new ExcelManager();
		//rowAndCol=1_0
		String [] myRowAndCol= rowAndCol.split("_");//break into 2 value= Array or Collection
		//1st Value =Row ==>myRowAndCol[0] =string
		//2nd value =Col==>myRowAndCol[1] =string
		// String to int
		int romNum = Integer.parseInt(myRowAndCol[0]);
		int colNum = Integer.parseInt(myRowAndCol[1]);
		
		pf.getUser().sendKeys(obj.readExcel(romNum,colNum));
	}

	@When("Put pass {string} from Excel")
	public void put_pass_from_Excel(String rowAndCol) {
		
		String [] myRowAndCol= rowAndCol.split("_");//break into 2 value= Array or Collection
		//1st Value =Row ==>myRowAndCol[0] =string
		//2nd value =Col==>myRowAndCol[1] =string
		// String to int
		int romNum = Integer.parseInt(myRowAndCol[0]);
		int colNum = Integer.parseInt(myRowAndCol[1]);
		
		pf.getPass().sendKeys(obj.readExcel(romNum,colNum));
	}


	
	@Then("Validate login")
	public void validate_login() {

		SoftAssert sa = new SoftAssert();
		if (driver.findElement(By.xpath("//*[text()='Logout']")).isDisplayed()) {
			System.out.println("Login pass");
			// assertion
			sa.assertTrue(driver.findElement(By.xpath("//*[text()='Logout']")).isDisplayed());
		}
		if (!driver.findElement(By.xpath("//*[text()='Logout']")).isDisplayed()) {
			System.out.println("Login Failed");
			// assertion
			sa.assertTrue(!driver.findElement(By.xpath("//*[text()='Logout']")).isDisplayed());
		}

		sa.assertAll();
		driver.quit();

	}

}
