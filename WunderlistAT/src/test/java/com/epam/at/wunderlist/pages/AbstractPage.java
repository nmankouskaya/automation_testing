package com.epam.at.wunderlist.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * AbstractPage class is used to perform web page
 */
public abstract class AbstractPage
{
	/**
	 * WebDriver field
	 */
	protected WebDriver driver;

	/**
	 * Logger field
	 */
	protected final Logger logger = LogManager.getRootLogger();

	/**
	 * BaseUrl field
	 */
	private final String BASE_URL = "https://www.wunderlist.com/login?redirect_url=/webapp";

	/**
	 * Open page method
	 */
	public  void openPage()
	{
		driver.navigate().to(BASE_URL);
		logger.info( driver.getCurrentUrl() + " is opened");
	}

	/**
	 * Constructor
	 * @param driver WebDriver
	 */
	public AbstractPage(WebDriver driver)
	{
		this.driver = driver;
	}
}
