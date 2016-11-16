package com.epam.at.wunderlist;

import com.epam.at.wunderlist.utils.Utils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.at.wunderlist.steps.Steps;

import static org.junit.Assert.assertTrue;

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
	private  String listTitle;

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
	 * Stop browser
	 */
	@AfterMethod
	public void stopBrowser()
	{
		//steps.closeDriver();
	}

}
