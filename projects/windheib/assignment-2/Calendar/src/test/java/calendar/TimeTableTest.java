package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import jdk.internal.jline.internal.TestAccessible;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {
	//deleteAppt()
	@Test
	public void test01()	throws Throwable {
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		int startHour=15;
		int startMinute=30;
		int startDay=21;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = null;
		//TimeTable.deleteAppt(listAppts, appt);


		appt = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		// unsure

	}

	@Test
	public void test02()  throws Throwable  {
		//Set up appointment(s)
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		LinkedList<Appt> compareAppts = new LinkedList<Appt>();
		int startHour=15;
		int startMinute=30;
		int startDay=21;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		int[] recDays={2,3,4}; //[[Is this correct?]]
		appt.setRecurrence( recDays, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
		listAppts.add(appt);

		//timeTable
		TimeTable timeTable=new TimeTable();
		GregorianCalendar today = new GregorianCalendar(2018,01,21);
		GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH,10);
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		//compare
		CalDay calCompare = new CalDay(today);
		calCompare.addAppt(appt);
		compareAppts = calDays.get(0).getAppts();


		assertEquals(calCompare, calDays.get(0));
		assertEquals(listAppts, calDays.get(0).getAppts());
		assertEquals(appt.getRecurBy(),compareAppts.get(0).getRecurBy());
	}
	//permute()
	@Test
	public void test03()  throws Throwable  {
		int startHour=15;
		int startMinute=30;
		int startDay=21;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";

		Appt apptA = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
		Appt apptB = new Appt(startHour+5, startMinute, startDay, startMonth, startYear, title, description);

		LinkedList<Appt> appointments = new LinkedList<Appt>();
		appointments.add(apptA);
		appointments.add(apptB);

		int[] holder = new int[3];

		for (int i=0; i<3; i++){
			holder[i] = i+1;
		}
		LinkedList<Appt> newList=new LinkedList<Appt>(appointments);
		TimeTable tt = new TimeTable ();
	}
//add more unit tests as you needed
}