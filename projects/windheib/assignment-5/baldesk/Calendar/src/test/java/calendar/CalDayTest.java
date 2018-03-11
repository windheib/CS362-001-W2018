package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 // Test that addAppt(Appt appt)  works correctly
	 @Test
	public void test01()  throws Throwable  {
		CalDay day = new CalDay();
		assertFalse(day.isValid());
		assertNull(day.iterator());
		assertEquals("", day.toString());

	}

	 //tests if isvalid() function works
	 @Test
	  public void test02()  throws Throwable  {
		 Calendar rightnow = Calendar.getInstance();
		 //current month/year/date is today
		 int thisMonth = rightnow.get(Calendar.MONTH)+1;
		 int thisYear = rightnow.get(Calendar.YEAR);
		 int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		 GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);

		 CalDay calday = new CalDay(today);

		 assertEquals(true, calday.isValid() );

	 }

	 //test if Iterator<?> function works
	// test the getters
	@Test
	public void test03()  throws Throwable  {
		int startHour = 2;
		int startMinute = 8;
		int startDay = 12;
		int startMonth = 4;
		int startYear = 2014;
		String title = "title";
		String description = "this is my description";
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		Calendar cur = Calendar.getInstance();
		int month = cur.get(Calendar.MONTH)+1;
		int year = cur.get(Calendar.YEAR);
		int day = cur.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(year,month,day);
		CalDay calday = new CalDay(today);

		LinkedList<Appt> appointments = new LinkedList<Appt>();
		appointments.add(appt);

	}
	//tests setters
	@Test
	public void test04()	throws Throwable{
		 Calendar rightnow = Calendar.getInstance();
		 //current month/year/date is today
		 int thisMonth = 2;
		 int thisYear = 2018;
		 int thisDay = 12;
		 GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);

		 CalDay calday = new CalDay(today);

		assertEquals(thisDay, calday.getDay());
		assertEquals(thisMonth, calday.getMonth());
		assertEquals(thisYear, calday.getYear());






	}
	@Test
	public void test05()	throws Throwable{
		 Calendar rightnow = Calendar.getInstance();
		 //current month/year/date is today
		 int thisMonth = 2;
		 int thisYear = 2018;
		 int thisDay = 12;
		 GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);

		 CalDay calday = new CalDay(today);

		// String check = "\t --- 2/12/2018 --- \n";
		 //assertEquals(check, calday.toString());


	}

}