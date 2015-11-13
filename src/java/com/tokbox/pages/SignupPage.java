package com.tokbox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Signup page class, page factory implementation
 * This class has only the element identifications
 * @author chathuri
 *
 */



public class SignupPage {
	private WebDriver driver;

	public SignupPage(WebDriver newdriver){
		this.driver = newdriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user_first_name")
	private WebElement firstName;

	@FindBy(id = "user_last_name")
	private WebElement lastName;
	
	@FindBy(id = "user_email")
	private WebElement userEmail;
	
	@FindBy(id = "user_company_name")
	private WebElement companyName;

	@FindBy(id = "user_password")
	private WebElement password;
	
	@FindBy(id = "user_terms_of_service")
	private WebElement tos;

	@FindBy(id = "submit_form")
	private WebElement next;
	
	@FindBy(xpath = "//*[@id='new_user']//li[1]")
	private WebElement error;
	

	public WebElement getError() {
		return error;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getUserEmail() {
		return userEmail;
	}

	public WebElement getCompanyName() {
		return companyName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getTos() {
		return tos;
	}

	public WebElement getNext() {
		return next;
	}
	

}
