package utility;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

public class TimeHelper {
	public static void main(String args[]) {
		Date c = new Date();
		System.out.println(new TimeHelper().dateToTimestamp(c));
	}

	public static Timestamp dateToTimestamp(Date date) {
		int year = date.getYear();
		int month = date.getMonth();
		int day = date.getDate();
		System.out.println(day);
		return new Timestamp(year, month, day, 0, 0, 0, 0);

	}

	public static Date LocalDateToDate(LocalDate ld) {
		int year = ld.getYear();
		Month month = ld.getMonth();
		int day = ld.getDayOfMonth();
		System.out.println(day);
		Date c = new Date();
		c.setYear(year-1900);
		c.setMonth(month.getValue()-1);
		c.setDate(day);
		return c;

	}
}
