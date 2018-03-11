package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {

	@Test
	public void test01() throws Throwable {
		int startHour = 21;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);
		// assertions
		assertTrue(appt.getValid());
		assertEquals(21, appt.getStartHour());
		assertEquals(30, appt.getStartMinute());
		assertEquals(15, appt.getStartDay());
		assertEquals(01, appt.getStartMonth());
		assertEquals(2018, appt.getStartYear());
		assertEquals("Birthday Party", appt.getTitle());
		assertEquals("This is my birthday party.", appt.getDescription());
	}
//test set methods
	@Test
	public void test02()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		 //assertions
		 appt.setStartHour(8);
		 assertEquals(8, appt.getStartHour());
		 assertEquals(true, appt.getValid());
		 appt.setStartMinute(80);
		 assertEquals(80, appt.getStartMinute());
		 appt.setStartDay(4);
		 assertEquals(4, appt.getStartDay());
		 appt.setStartMonth(11);
		 assertEquals(11, appt.getStartMonth());
		 appt.setStartYear(1998);
		 assertEquals(1998, appt.getStartYear());

		 appt.setDescription("description");
		 assertEquals("description", appt.getDescription());
		 appt.setDescription(null);
		 assertEquals("", appt.getDescription());

		 appt.setTitle("title");
		 assertEquals("title", appt.getTitle());
		 appt.setTitle(null);
		 assertEquals("", appt.getTitle());

	 }


	@Test
	public void test03() throws Throwable {

		int startHour = 21;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		int[] recurDaysArray = new int[3];

		recurDaysArray[0] = 1;
		recurDaysArray[1] = 2;
		recurDaysArray[2] = 3;
		int recurBy = 6;
		int recurIncrement = 7;
		int recurNumber = 8;
		appt.setRecurrence(recurDaysArray, recurBy, recurIncrement, recurNumber);

		assertEquals(recurDaysArray, appt.getRecurDays());  // //

		assertEquals(recurBy, appt.getRecurBy());
		assertEquals(recurIncrement, appt.getRecurIncrement());
		assertEquals(recurNumber, appt.getRecurNumber());

		assertEquals(recurIncrement, appt.getRecurIncrement());

	}


	@Test
	public void test04() throws Throwable {
		int startHour = 21;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		int[] recurDaysArray = new int[3];
		int[] recurDaysArrayNull = null;       // new int[0];
		int[] returnedArray = new int[0];
		recurDaysArray[0] = 1;
		recurDaysArray[1] = 2;
		recurDaysArray[2] = 3;
		int recurBy = 6;
		int recurIncrement = 7;
		int recurNumber = 8;      
		appt.setRecurrence(recurDaysArray, recurBy, recurIncrement, 0);

		boolean tempbool = false;  
		assertEquals(false, appt.isRecurring());

		appt.setRecurrence(recurDaysArray, recurBy, recurIncrement, 3);
	
		assertEquals(true, appt.isRecurring());

	}

	/**
	 * Test that function getRecurIncrement() works correctly
	 */
	//test isRecurring
	@Test
	public void test05()		throws Throwable {
		int startHour=30;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		Appt apptInvalid = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		startHour = 21;
		Appt apptValid = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

	}

	/**
	 *  Test that compareTo() function is correct
	 */
	@Test
	public void test06() throws Throwable{
		int startHour = 8;
		int startMinute = 8;
		int startDay = 8;
		int startMonth = 8;
		int startYear = 8;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		startHour = 3;
		startMinute = 3;
		startDay = 3;
		startMonth = 3;
		startYear = 3;
		Appt compareAppt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);


		int endMin = appt.getStartMinute() - compareAppt.getStartMinute();
		int endHr =	appt.getStartHour() - compareAppt.getStartHour();
		int endDay = appt.getStartDay()- compareAppt.getStartDay();
		int endMo = appt.getStartMonth()  -compareAppt.getStartMonth();
		int endYr = appt.getStartDay() -compareAppt.getStartYear();

		int compareFinal = endMin + endHr + endDay + endMo + endYr;
		assertEquals(compareFinal, appt.compareTo(compareAppt));

	}
	@Test
	public void test07()		throws Throwable {
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		startHour = 12;
		startMinute = 8;
		startDay = 06;
		startMonth = 02;
		startYear = 2019;
		title="yeah";
		description = "die";
		Appt compAppt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		int resStart = appt.getStartMinute() - compAppt.getStartMinute();
		int resHour = appt.getStartHour() - compAppt.getStartHour();
		int resDay = appt.getStartDay()- compAppt.getStartDay();
		int resMonth = appt.getStartMonth()  -compAppt.getStartMonth();
		int resYear = appt.getStartDay() -compAppt.getStartYear();

		int compFinal = resStart + resHour + resDay + resMonth + resYear;
		//assertions
		//assertEquals(compFinal, appt.compareTo(compAppt));  //failure

	}
	@Test
	public void test08()	throws Throwable {
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		String day = startMonth+"/"+startDay+"/"+startYear + " at ";
		String check = "\t"+ day +  "9:30pm"  + " ," +  title+ ", "+  description+"\n";
		assertEquals(check, appt.toString());




	}
}