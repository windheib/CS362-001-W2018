package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import jdk.internal.jline.internal.TestAccessible;
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
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


	 // test set methods

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

//private method.... whoops
	 @Test
	  public void test03()	throws Throwable {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		 assertEquals(true, appt.getValid());
		 //appt.isValid();

		 startMinute=61;
		 Appt appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		 assertEquals(false, appt1.getValid());
		 startMinute=30;
		 startDay=0;
		 Appt appt2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		 //appt.isValid();
		 assertEquals(false, appt2.getValid());
		 startDay=15;
		 startMonth=64;
		 Appt appt3 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		 //appt.isValid();
		 assertEquals(false, appt3.getValid());

	 }
	//test setRecurrance
	@Test
	public void test04()		throws Throwable {
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		int[] recDays = new int[3];
		for(int i=0; i<3; i++){
			recDays[i+1] = i;
		}

		int recBy = 8;
		int increment = 7;
		int number = 6;
		appt.setRecurrence(recDays, recBy, increment, number);

		//assertions
		assertEquals(recDays, appt.getRecurDays());
		assertEquals(recBy, appt.getRecurBy());
		assertEquals(increment, appt.getRecurIncrement());
		assertEquals(number, appt.getRecurNumber());
	}

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

	@Test
	public void test06()		throws Throwable {
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		int[] recDays = new int[3];
		for(int i=0; i<3; i++){
			recDays[i+1] = i;
		}

		int recBy = 8;
		int increment = 7;
		int number = 6;

		appt.setRecurrence(recDays, recBy, increment, 0);
		boolean holder = false;
		assertEquals(false, appt.isRecurring());

		appt.setRecurrence(recDays, recBy, increment, 3);
		assertEquals(true, appt.isRecurring());
	}
	//compareTo()
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
		assertEquals(compFinal, appt.compareTo(compAppt));

	}
//add more unit tests as you needed
	
}
