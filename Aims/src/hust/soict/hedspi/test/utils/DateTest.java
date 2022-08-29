package hust.soict.hedspi.test.utils;

import hust.soict.hedspi.aims.utils.DateUtils;
import hust.soict.hedspi.aims.utils.MyDate;

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyDate date1 = new MyDate("first", "June", "nineteen hundred");
		MyDate date2 = new MyDate("second", "June", "nineteen thirty");
		MyDate date3 = new MyDate("first", "May", "nineteen fourty-five");
		MyDate date4 = new MyDate("first", "April", "nineteen fourty-five");
		DateUtils.sortDate(date1, date2, date3, date4);
		//date1.print2();
	}

}