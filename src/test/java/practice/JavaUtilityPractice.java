package practice;

import genericUtility.JavaUtility;

public class JavaUtilityPractice {

	public static void main(String[] args) {

		JavaUtility jUtil = new JavaUtility();
		
		String date = jUtil.getCalendarDetails("dd-MM-YYYY");
		System.out.println(date);

		String date_Time = jUtil.getCalendarDetails("dd-MM-YYYY hh:mm:ss");
		System.out.println(date_Time);

		int rnum = jUtil.getRandomNumber(10);
		System.out.println(rnum);

		int rnum1 = jUtil.getRandomNumber(1000);
		System.out.println(rnum1);

	}
}
