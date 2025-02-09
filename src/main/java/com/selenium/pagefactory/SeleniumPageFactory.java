package com.selenium.pagefactory;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPageFactory {
	// to handle driver null = constructor
	
	 public SeleniumPageFactory(WebDriver driver){
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	//selenium PF + Java OOPS encapsulation
	@FindBy(xpath="//*[@name='username']")
	private WebElement user;
	
	@FindBy(xpath="//*[@name='password']")
	private WebElement pass;
	
	@FindBy(xpath="//*[@type='submit']")
	private WebElement loginBtn;

	public WebElement getUser() {//Static =No
		return user;
	}

	public WebElement getPass() {
		return pass;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	
	
	

}
