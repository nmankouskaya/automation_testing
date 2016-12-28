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
	 * Collection of Lists
	 */
	@FindBy(xpath = "//ul[@class='lists-collection']")
	private WebElement listCollection;

	/**
	 * Set value to listCollection
	 */
	public void setListCollection(){
		listCollection = driver.findElement(By.className("lists-collection"));
	}

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
	 * Get lists
	 * @return list of WebElement
	 */
	public List<WebElement> getLists(){
		WebElement listDiv = driver.findElement(By.className("lists-collection"));
		return listDiv.findElements(By.className("title"));
	}

	/**
	 * Get list by title
	 * @param title
	 * @return list
	 * @throws Exception
	 */
	public WebElement getListByTitle(String title) throws Exception{
		logger.log(Level.INFO, "In getListByTitle method");
		if (listCollection == null){
			setListCollection();
		}
		logger.log(Level.INFO, "Lists-Collection element is obtained");
		WebElement requiredList = null;
		for(WebElement el : listCollection.findElements(By.className("title")))
		{
			if(el.getText().equals(title)){
				requiredList = el;
			}
		}
		if (requiredList == null){
			throw new Exception("No lists in list collection.");
		}
		return requiredList;
	}

	/**
	 * Rename list title
	 * @param oldTitle
	 * @param newTitle
	 * @throws Exception
	 */
	public void renameList(String oldTitle, String newTitle) throws Exception
	{
		if (listCollection == null){
			setListCollection();
		}
		logger.log(Level.INFO, "Lists-Collection element is obtained");
		WebElement requiredList = getListByTitle(oldTitle);
		requiredList.click();
		logger.log(Level.INFO, "Click on list: " + oldTitle);

		WebElement editSpan= listCollection.findElement(By.className("list-options"));
		WebElement gToClick = editSpan.findElement(By.id("options"));
		gToClick.click();
		logger.log(Level.INFO, "Click edit button.");

		WebElement inputTitle = driver.findElement(By.className("listOptions-title"));
		inputTitle.sendKeys(newTitle);
		WebElement saveButton = driver.findElement(By.className("submit"));
		saveButton.click();
	}

	/**
	 * Delete list by title
	 * @param title
	 * @throws Exception
	 */
	public void deleteList(String title) throws Exception
	{
		if (listCollection == null){
			setListCollection();
		}
		logger.log(Level.INFO, "Lists-Collection element is obtained");
		WebElement requiredList = getListByTitle(title);
		requiredList.click();
		logger.log(Level.INFO, "Click on list: " + title);

		WebElement editSpan= listCollection.findElement(By.className("list-options"));
		WebElement gToClick = editSpan.findElement(By.id("options"));
		gToClick.click();
		logger.log(Level.INFO, "Click edit button.");

		WebElement deleteButton = driver.findElement(By.id("trash"));
		deleteButton.click();
		WebElement deleteConfirmButton = driver.findElement(By.xpath("//button[@class='confirm']"));
		deleteConfirmButton.click();
	}

	/**
	 * Duplicate list
	 * @param title
	 * @throws Exception
	 */
	public void duplicateList(String title) throws Exception
	{
		if (listCollection == null){
			setListCollection();
		}
		logger.log(Level.INFO, "Lists-Collection element is obtained");
		WebElement requiredList = getListByTitle(title);
		requiredList.click();
		logger.log(Level.INFO, "Click on list: " + title);

		WebElement editSpan= listCollection.findElement(By.className("list-options"));
		WebElement gToClick = editSpan.findElement(By.id("options"));
		gToClick.click();
		logger.log(Level.INFO, "Click edit button.");

		WebElement duplicateButton = driver.findElement(By.id("duplicate"));
		duplicateButton.click();
	}
}
