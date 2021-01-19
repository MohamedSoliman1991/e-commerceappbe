package ae.task.ecomperceappbe.common;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Utilities {
	
	static int getCurrentYear(){
		
		//Getting the current date value
	      LocalDate currentdate = LocalDate.now();
	      //getting the current year
	      int currentYear = currentdate.getYear();
	      System.out.println("Current month: "+currentYear);
	      return currentYear;
	}
	
	public static boolean compareWithRegisieredDate(String registeredDate)
	
	{
		Date convertedRegisteredDate = null;
		try {
			convertedRegisteredDate = new SimpleDateFormat("dd/MM/yyyy").parse(registeredDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		long timestamp = convertedRegisteredDate.getTime();
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(timestamp);
		 int registeredYear = cal.get(Calendar.YEAR);
		 if(getCurrentYear() - registeredYear == 2)
			 return true;
		return false;
		
	}
}
