package com.epam.at.wunderlist.pages;

import org.apache.logging.log4j.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * MainPage
 * @author Nastassia_Dubovik@epam.com
 */
public class MainPage extends AbstractPage
{
	/**
	 * Input listName
	 */
	@FindBy(xpath = "//input[@aria-label='List Name']")
	private WebElement inputListName;

	/**
	 * Button save
	 */
	@FindBy(xpath = "//button[contains(text(), 'Save')]")
	private WebElement buttonSave;

	/**
	 * Constructor
	 * @param driver WebDriver
	 */
	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	/**
	 * Create new list
	 * @param listName String
	 */
	public void createNewList(String listName) {
		logger.log(Level.INFO, "Creating new list with name " + listName);
		WebElement createNewListButton = driver.findElement(By.className("sidebarActions-addList"));
		createNewListButton.click();
		inputListName.sendKeys(listName);
		buttonSave.click();
		logger.log(Level.INFO, "List is created");
	}

	/**
	 * Get created lists
	 * @return list of WebElement
	 */
	public List<WebElement> getLists(){
		WebElement listDiv = driver.findElement(By.className("lists-collection"));
		return listDiv.findElements(By.className("title"));
	}
}
