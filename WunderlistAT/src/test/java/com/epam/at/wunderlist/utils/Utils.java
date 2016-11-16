package com.epam.at.wunderlist.utils;

import org.apache.commons.exec.util.StringUtils;

import java.util.Date;

/**
 * Utils class to form title
 */
public class Utils
{
	/**
	 * Create title in format "Title_date_time"
	 * @return title for list
	 */
	public static String getTitleWithCurrentDate()
	{
		StringBuilder sb = new StringBuilder("Title_");
		String date = (new Date(System.currentTimeMillis())).toString();
		sb.append(date.replace(' ', '_'));
		return sb.toString();
	}
}
