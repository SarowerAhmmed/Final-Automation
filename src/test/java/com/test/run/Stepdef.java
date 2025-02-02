package com.test.run;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdef {
	WebDriver driver;
	
	@Given("Open browser")
	public void open_browser() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    
	}//end

	@Given("Go to application")
	public void go_to_application() {
		
		driver.get("file:///C:/Users/sarow/OneDrive/Desktop/New%20folder/Banking%20Application/Batch%2041/qa_online%20Banking%20monthly_yearly%20statement.html");
	   
	}

	@When("Put user {string}")
	public void put_user(String user) {
	   driver.findElement(By.xpath("//*[@name='username']")).sendKeys(user);
	}

	@When("Put pass {string}")
	public void put_pass(String pass) {
		 driver.findElement(By.xpath("//*[@name='password']")).sendKeys(pass);
	}
	@When("Click login button")
	public void click_login_button() {
		 driver.findElement(By.xpath("//*[@type='submit']")).click();
	}
	@Then("Validate login")
	public void validate_login() {
		
		SoftAssert sa = new SoftAssert();
	    if(driver.findElement(By.xpath("//*[text()='Logout']")).isDisplayed()) {
	    	System.out.println("Login pass");
	    	//assertion
	    	sa.assertTrue(driver.findElement(By.xpath("//*[text()='Logout']")).isDisplayed());
	    }
	    if(!driver.findElement(By.xpath("//*[text()='Logout']")).isDisplayed()) {
	    	System.out.println("Login Failed");
	    	//assertion
	    	sa.assertTrue(!driver.findElement(By.xpath("//*[text()='Logout']")).isDisplayed());
	    }
	    	
	    sa.assertAll();
	    driver.quit();

	}

}
