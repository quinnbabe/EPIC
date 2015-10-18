import java.util.Arrays;

/**
 * Get a date (mon/day/year) from user. Print exact the week of dates (Sun to
 * Sat). ex) input: 2/20/2001 if the day is Wednesday output:
 * 
 * Sunday 2/17/2001 Monday 2/18/2001 Tuesday 2/19/2001 Wednesday 2/20/2001
 * Thursday 2/21/2001 Friday 2/22/2001 Saturday 2/23/2001
 */
public class Calendar {

	public static void calendar(String date, int calendar) {
		int[] days_month = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String[] list = date.split("/");
		String[] result = new String[7];
		result[calendar] = printCalendar(calendar) + date;
		int year = Integer.parseInt(list[2]);
		int month = Integer.parseInt(list[0]);
		int day = Integer.parseInt(list[1]);
		int left = calendar;
		int right = 7-calendar-1;
		
		for(int i=1;i<=left;i++){
			day--;
			if(day==0){
				month--;
				if(month==0){
					year--;
					month = 12;
					day = 31;
				}else{
					day = (isLeapYear(year)&&month==2) ? 29 : days_month[month];
				}
			}
			result[calendar-i] = printCalendar(calendar-i) +""+month+"/"+day+"/"+year;
		}
		
		year = Integer.parseInt(list[2]);
		month = Integer.parseInt(list[0]);
		day = Integer.parseInt(list[1]);
		for(int i=1;i<=right;i++){
			day++;
			if(day >= ((isLeapYear(year)&&month==2)?29 : days_month[month])){
				day=1;
				if(month!=12){
					month++;
				}else{
					year++;
					month=1;
				}
			}
			result[calendar+i] = printCalendar(calendar+i) +""+month+"/"+day+"/"+year;
		}
		
		System.out.println(Arrays.toString(result));
	}
	
	private static boolean isLeapYear(int year){
		if(year%400==0 || (year%4==0 && year%100!=0)){
			return true;
		}
		return false;
	}
	private static String printCalendar(int days) {
		int select = days % 7;
		switch (select) {
		case 0:
			return "Sunday";
		case 1:
			return "Monday";
		case 2:
			return "Tuesday";
		case 3:
			return "Wednesday";
		case 4:
			return "Thursday";
		case 5:
			return "Friday";
		case 6:
			return "Saturday";
		default:
			return "";
		}
	}
	


	public static void main(String[] args) {
		calendar("12/31/2014",3); 
	}
	
	
	
	

}
