import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeInMiliSecond {

	/**
	 * 
	 * @param args
	 * 
	 */

	public static void main(String[] args) {

// TODO Auto-generated method stub

		try {

			String str_date = "22/07/2021 10:30:00";
			DateFormat formatter;
			Date date;
			formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			date = (Date) formatter.parse(str_date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			System.out.println("Date and Time is " + date);
			System.out.println("Time millis is " + cal.getTimeInMillis());
             
//			Date date1=(Date)new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("13/3/2013 16:15:00");
//			Calendar.getInstance().setTime(date1);
			
			Calendar cal1 = Calendar.getInstance();

			cal1.setTimeInMillis(1361185610269L);

			System.out.println(cal1.getTime());
		} catch (ParseException e) {
			System.out.println("Exception :" + e);
		}

	}

	/*
	 * SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
	 * Locale.US); format.setTimeZone(TimeZone.getTimeZone("IST"));
	 * 
	 * Date date; try { date = format.parse("2012-09-24 18:00:00"); long millis =
	 * date.getTime(); System.out.println(millis); } catch (ParseException e) { //
	 * TODO Auto-generated catch block e.printStackTrace();
	 */
}
