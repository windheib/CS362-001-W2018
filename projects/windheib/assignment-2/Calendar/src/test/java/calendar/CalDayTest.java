package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {
	// test default
	@Test
	public void test01()  throws Throwable  {
		CalDay day = new CalDay();
		assertFalse(day.isValid());
		assertNull(day.iterator());
		assertEquals("", day.toString());

	}
	@Test
	public void test02()  throws Throwable  {

		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="title";
		String description="sick description";

		Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth ,startYear , title, description);
		Appt appt2 = new Appt(startHour + 4, startMinute , startDay , startMonth , startYear , title, description);
		Appt appt3 = new Appt(startHour - 4, startMinute , startDay , startMonth , startYear , title, description);

		GregorianCalendar cal = new GregorianCalendar();
		CalDay day = new CalDay(cal);
		assertTrue(day.isValid());
		assertEquals(cal.get(cal.DAY_OF_MONTH), day.getDay());
		assertEquals(cal.get(cal.MONTH), day.getMonth());
		assertEquals(cal.get(cal.YEAR), day.getYear());
		assertTrue(day.getAppts().isEmpty());
		assertEquals(0, day.getSizeAppts());

		for(int i = 0; i<1; i++) {
			day.addAppt(appt1);
			day.addAppt(appt2);
			day.addAppt(appt3);
		}
		assertFalse(day.iterator() == null);

		CalDay day2 = new CalDay(null);
	}
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
//add more unit tests as you needed
}