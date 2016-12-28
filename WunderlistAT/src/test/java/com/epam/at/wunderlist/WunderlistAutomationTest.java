package com.epam.at.wunderlist;

import com.epam.at.wunderlist.utils.Utils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.at.wunderlist.steps.Steps;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.fail;

/**
 * Wunderlist automation test for case: creating new list with valid title
 * @author Nastassia_Dubovik@epam.com
 */
public class WunderlistAutomationTest
{
	/**
	 * Steps contains main tasks to perform
	 */
	private Steps steps;

	/**
	 * Username field
	 */
	private final String USERNAME = "TestUser";

	/**
	 * Email field
	 */
	private final String EMAIL = "stasyadybovik@mail.ru";

	/**
	 * Password field
	 */
	private final String PASSWORD = "TestUser111";

	/**
	 * ListName field
	 */
	private String listTitle;

	/**
	 * Init
	 */
	@BeforeMethod
	public void setUp()
	{
		steps = new Steps();
		steps.initBrowser();
		listTitle = Utils.getTitleWithCurrentDate();
	}

	/**
	 * Test for login
	 */
	@Test
	public void testLogin()
	{
		steps.login(EMAIL, PASSWORD);
		assertTrue(steps.checkLoggedIn(USERNAME));
	}

	/**
	 * Test for creating list with valid title
	 */
	@Test
	public void testCreateListWithValidTitle()
	{
		steps.login(EMAIL, PASSWORD);
		assertTrue(steps.checkLoggedIn(USERNAME));
		steps.createNewList(listTitle);
		assertTrue(steps.checkCreatedList(listTitle));
	}

	/**
	 * Test for editing list title
	 */
	@Test
	public void testEditListTitle()
	{
		steps.login(EMAIL, PASSWORD);
		try {
			steps.editListTitle("Title_Thu_Nov_17_02:09:27_MSK_2016", "Title_Thu_Nov_17_02:09:27_MSK_2016" + "_Edit");
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test for deleting the list
	 * List with name "List_For_Deleting" should be created before
	 */
	@Test
	public void testDeleteList()
	{
		steps.login(EMAIL, PASSWORD);
		try {
			steps.deleteList("List_For_Deleting");
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test for duplicating the list with name "List_For_Duplicate"
	 */
	@Test
	public void testDuplicateList()
	{
		steps.login(EMAIL, PASSWORD);
		try {
			steps.duplicateList("List_For_Duplicate");
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Stop browser
	 */
	@AfterMethod
	public void stopBrowser()
	{
		//steps.closeDriver();
	}

}
