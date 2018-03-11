package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.*;


import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;
	
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void randomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing...");
		 
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				Appt validDelete = null;
				Appt invalidDelete = null;
				TimeTable timetable = new TimeTable();
				LinkedList<Appt> appts = new LinkedList<Appt>();

				for (int i = 0; i < NUM_TESTS; i++) {
					for (int j = 0; j < 5; j++){
						 int startHour=random.nextInt(30);
						 int startMinute=random.nextInt(70);
						 int startDay=random.nextInt(35);
						 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 12);
						 int startYear=ValuesGenerator.RandInt(random);
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
						 if(appt.getValid()){
						 	validDelete = appt;
						 }
						 else if(!(appt.getValid())){
						 	invalidDelete = appt;
						 }
						 appts.add(appt);
					}
					int thisMonth = random.nextInt(15); // have it be mostly valid values except for a couple
			 		int thisYear = random.nextInt(3000);
					int thisDay = random.nextInt(40);
					GregorianCalendar firstDay = new GregorianCalendar(thisYear,thisMonth,thisDay);

					//CalDay first = new CalDay(firstDay);

					thisMonth = random.nextInt(15); // have it be mostly valid values except for a couple
			 		thisYear = random.nextInt(3000);
					thisDay = random.nextInt(40);
					GregorianCalendar lastDay = new GregorianCalendar(thisYear,thisMonth,thisDay);

					//CalDay second = new CalDay(lastDay);

					timetable.getApptRange(appts, firstDay, lastDay);

					timetable.deleteAppt(appts, validDelete);
					timetable.deleteAppt(appts, invalidDelete);
					timetable.deleteAppt(appts, null);
					timetable.deleteAppt(null, null);
					
					 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				        if((iteration%10000)==0 && iteration!=0 )
				              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
				 
				}
			}	
				
		}catch(NullPointerException e){
			
		}
	 
		 System.out.println("Done testing...");
	 }


	
}
