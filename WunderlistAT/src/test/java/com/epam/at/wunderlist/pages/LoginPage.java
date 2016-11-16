package com.epam.at.wunderlist.pages;

import org.apache.logging.log4j.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * LoginPage
 */
public class LoginPage extends AbstractPage
{
	/**
	 * Sign in button
	 */
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement signInButton;

	/**
	 * Input email
	 */
	@FindBy(xpath = "//input[@type='email']")
	private WebElement inputEmail;

	/**
	 * Input password
	 */
	@FindBy(xpath = "//input[@type='password']")
	private WebElement inputPassword;

	/**
	 * Constructor
	 * @param driver WebDriver
	 */
	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	/**
	 * Login with email and password
	 * @param email String
	 * @param password String
	 */
	public void login(String email, String password)
	{
		inputEmail.sendKeys(email);
		inputPassword.sendKeys(password);
		signInButton.click();
		logger.info("Login is performed");
	}

	/**
	 * Get logged in user name
	 * @return String
	 */
	public String getLoggedInUserName(){
		WebElement sidebarActionDiv = null;
		logger.log(Level.INFO, "Waiting until main page is loaded.");
		try {
			do {
				Thread.sleep(1000L);
				sidebarActionDiv = driver.findElement(By.id("detail"));
			}
			while (sidebarActionDiv == null);
		} catch (InterruptedException ex)
		{
			logger.log(Level.ERROR, ex);
		}
		logger.log(Level.INFO, "Main page is loaded.");
		WebElement userNameSpan = driver.findElement(By.className("user-name"));
		return userNameSpan.getText();
	}

}
