package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.*;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {	 
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


		appt = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);

	}

//	 }
	//test that public deleteappt works
	 @Test
	  public void test02()  throws Throwable  {
		 int startHour = 1;
		 int startMinute = 9;
		 int startDay = 13;
		 int startMonth = 8;
		 int startYear = 2015;
		 String title = "title";
		 String description = "description";
		 Appt appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		 Appt appt2 = new Appt(startHour+1, startMinute+1, startDay+1, startMonth+1, startYear+1, title, description);
		 Appt appt3 = new Appt(startHour+7, startMinute+7, startDay, startMonth, startYear, title, description);

		 LinkedList<Appt> appts = new LinkedList<Appt>();
		 LinkedList<Appt> appts_1 = new LinkedList<Appt>();
		 appts.add(appt1);
		 appts_1.add(appt1);
		 appts.add(appt2);

		 Calendar now = Calendar.getInstance();    //current month/year/date is today
		 int month = now.get(Calendar.MONTH)+1;
		 int year = now.get(Calendar.YEAR);
		 int day = now.get(Calendar.DAY_OF_MONTH);
		 GregorianCalendar today = new GregorianCalendar(year,month,day);
		 CalDay firstDay = new CalDay(today);

		 firstDay.addAppt(appt1);
		 firstDay.addAppt(appt2);

		 TimeTable timeTable=new TimeTable();
		 LinkedList<Appt> listDeletedAppts = timeTable.deleteAppt(appts, appt2);
		 LinkedList<Appt> listDeletedAppts_Null = timeTable.deleteAppt(appts, appt3);


		 LinkedList<Appt> appts_new = new LinkedList<Appt>();
		 appts_new.add(appt1);
		 LinkedList<Appt> appts_new_more = appts_new;
		 appts_new_more.add(appt2);

		 assertEquals(null, timeTable.deleteAppt(appts, appt3) );
		 assertEquals(null, timeTable.deleteAppt(null, null));
		 assertEquals(null, timeTable.deleteAppt(appts, null));
		 assertEquals(null, timeTable.deleteAppt(null, appt3));

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

	@Test
	  public void test04()  throws Throwable  {
			TimeTable table = new TimeTable();
	        LinkedList<CalDay> calDays = new LinkedList<CalDay>();
			LinkedList<Appt> listAppts = new LinkedList<Appt>();
			
			//get todays date
	    	Calendar rightnow = Calendar.getInstance();
	    	int thisMonth = rightnow.get(Calendar.MONTH);
			int thisYear = rightnow.get(Calendar.YEAR);
			int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
			int startHour=15;
			int startMinute=30;
			int startDay=thisDay;  	
			int startMonth=4; 	
			int startYear=thisYear; 	
			String title="Birthday Party";
			String description="This is my birthday party.";
			
			//Construct a new Appointment object with the initial data	 
	        Appt appt_1 = new Appt(startHour,
	                 startMinute ,
	                 startDay ,
	                 startMonth ,
	                 startYear ,
	                 title,
	                description);
	        
	        listAppts.add(appt_1);
	         
	     // create another appointment
	        startHour=2;
			startMinute=30;
			startDay=thisDay;  	
			startMonth=5; 	
			startYear=thisYear; 	
			title="thing1";
			description="its a thing1";
			//Construct a new Appointment object with the initial data	 
	        Appt appt_2 = new Appt(startHour,
	                 startMinute ,
	                 startDay ,
	                 startMonth ,
	                 startYear ,
	                 title,
	                description);
	       
	        listAppts.add(appt_2);

	        startHour=13;
			startMinute=30;
			startDay=thisDay;		
			startMonth=6;	
			startYear=thisYear;	
			title="thing2";
			description="its a thing2";
	        Appt appt = new Appt(startHour,
	                 startMinute ,
	                 startDay ,
	                 startMonth ,
	                 startYear ,
	                 title,
	                description);
	        listAppts.add(appt);

	        startHour=-22;
			startMinute=30;
			startDay=thisDay;		
			startMonth=7;	
			startYear=thisYear;	
			title="thing3";
			description="its a thing3";

	        GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
			GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
			tomorrow.add(Calendar.DAY_OF_MONTH,1);
			
			calDays = table.getApptRange(listAppts, today, tomorrow);
			
			assertEquals(null, table.deleteAppt(listAppts, appt));			
			assertEquals(null, table.deleteAppt(null, null));
			assertEquals(null, table.deleteAppt(listAppts, null));
			assertEquals(null, table.deleteAppt(null, listAppts.get(1)));
	 }


//add more unit tests as you needed
}
