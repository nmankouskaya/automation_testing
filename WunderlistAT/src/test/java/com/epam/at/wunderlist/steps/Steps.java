package com.epam.at.wunderlist.steps;

import com.epam.at.wunderlist.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;

import com.epam.at.wunderlist.pages.LoginPage;
import com.epam.at.wunderlist.pages.MainPage;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Steps class contains main task to perform for automating testing
 * @author Nastassia_Dubovik@epam.com
 */
public class Steps
{
	/**
	 * WebDriver (in our case Fire Fox)
	 */
	private WebDriver driver;

	/**
	 * Init browser
	 */
	public void initBrowser()
	{
		driver = DriverSingleton.getDriver();
	}

	/**
	 * Close driver
	 */
	public void closeDriver()
	{
		driver.quit();
	}

	/**
	 * Login to www.wunderlist.com
	 * @param username String
	 * @param password String
	 */
	public void login(String username, String password)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(username, password);
	}

	/**
	 * Check if we have logged in
	 * @param username String
	 * @return true if we have logged in, false - in other case
	 */
	public boolean checkLoggedIn(String username)
	{
		LoginPage loginPage = new LoginPage(driver);
		return (loginPage.getLoggedInUserName().trim().toLowerCase().equals(username.toLowerCase()));
	}

	/**
	 * Create new list
	 * @param listName String
	 */
	public void createNewList(String listName)
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.createNewList(listName);
	}

	/**
	 * Check if we have created new list by listName.
	 * @param listName
	 * @return
	 */
	public boolean checkCreatedList(String listName)
	{
		MainPage mainPage = new MainPage(driver);
		List<WebElement> listSpan = mainPage.getLists();
		for(WebElement el : listSpan) {
			if(el.getText().equals(listName)){
				return true;
			}
		}
		return false;
	}

	/**
	 * Edit list title
	 * @param oldTitle
	 * @param newTitle
	 * @throws Exception
	 */
	public void editListTitle(String oldTitle, String newTitle) throws Exception
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.renameList(oldTitle, newTitle);

	}

	/**
	 * Delete list by title
	 * @param title
	 * @throws Exception
	 */
	public void deleteList(String title) throws Exception
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.deleteList(title);
	}

	/**
	 * Duplicate list by title
	 * @param title
	 * @throws Exception
	 */
	public void duplicateList(String title) throws Exception
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.duplicateList(title);
	}
}
