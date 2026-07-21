package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * this is a utility class which has functionalities from java library
 * 
 * @author Mukilan P
 * @version 26-06-24
 */
public class JavaUtility {

	/**
	 * this is a generic method to fetch Calendar Details
	 * 
	 * @param pattern
	 * @return
	 */
	public String getCalendarDetails(String pattern) {

		Calendar cal = Calendar.getInstance();
		Date d = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String value = sdf.format(d);
		return value;
		//pattern -> it is for user needs pattern 
	}

	/**
	 * this is a generic method to generate random number
	 * 
	 * @return
	 */
	public int getRandomNumber(int bound) {
		Random r = new Random();
		int num = r.nextInt(bound);
		return num;
		// bound -> is user input for limit
	}
}
