package hust.soict.hedspi.aims.utils;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import java.text.ParseException;  

public class DateUtils {
	public static int compareTwoDate(MyDate d1, MyDate d2) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
		String str1 = String.valueOf(d1.getYear()) + "/" + String.valueOf(d1.getMonth()) + "/" + String.valueOf(d1.getDay());
		String str2 = String.valueOf(d2.getYear()) + "/" + String.valueOf(d2.getMonth()) + "/" + String.valueOf(d2.getDay());
		
		Date date1 = sdf.parse(str1);  
		Date date2 = sdf.parse(str2);  
		
		return date1.compareTo(date2);
	}
	
	public static void sortDate (MyDate...dates ) {
		String str[] = new String[dates.length];
		int i = 0;
		for(MyDate d : dates) {
			str[i] = String.valueOf(d.getYear()) + "/" + String.valueOf(d.getMonth()) + "/" + String.valueOf(d.getDay());
			i++;
		}
		Arrays.sort(str);
		System.out.println("Sorted day: ");
		for(String tmp : str) {
			System.out.println(tmp);
		}
	}
}