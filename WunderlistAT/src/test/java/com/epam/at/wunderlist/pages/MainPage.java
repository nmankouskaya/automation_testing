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

	public WebElement getListByTitle(String title){
		if (listCollection == null){
			setListCollection();
		}
		WebElement requiredList = null;
		for(WebElement el : listCollection.findElements(By.className("title")))
		{
			if(el.getText().equals(title)){
				requiredList = el;
			}
		}
		return requiredList;
	}

	private WebElement listCollection;

	public void setListCollection(){
		listCollection = driver.findElement(By.className("lists-collection"));
	}

	public void editList(String oldTitle, String newTitle)
	{
		if (listCollection == null){
			setListCollection();
		}
		WebElement requiredList = getListByTitle(oldTitle);
		requiredList.click();
		WebElement editButton = listCollection.findElement(By.className("list-options"));
		//WebElement li = requiredList.findElement(By.cssSelector("li[area-label~='"+ oldTitle +"']"));
		editButton.click();
		WebElement inputTitle = driver.findElement(By.className("big listOptions-title"));
		inputTitle.sendKeys(newTitle);
		WebElement saveButton = driver.findElement(By.className("submit full blue"));
		saveButton.click();
	}
}
