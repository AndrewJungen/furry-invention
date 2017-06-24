package com.restful.business;

import java.util.Calendar;

public class FetcherUtil {

	public static String getTimeOfDay() {
		String timeOfDay = "";
		Calendar calendar = Calendar.getInstance();
		int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
		int minuteOfDay = calendar.get(Calendar.MINUTE);
		if(1 == hourOfDay){
			timeOfDay = "1:" + minuteOfDay + "AM";
		}else if(2 == hourOfDay){
			timeOfDay = "2:" + minuteOfDay + "AM";
		}else if(3 == hourOfDay){
			timeOfDay = "3:" + minuteOfDay + "AM";
		}else if(4 == hourOfDay){
			timeOfDay = "4:" + minuteOfDay + "AM";
		}else if(5 == hourOfDay){
			timeOfDay = "5:" + minuteOfDay + "AM";
		}else if(6 == hourOfDay){
			timeOfDay = "6:" + minuteOfDay + "AM";
		}else if(7 == hourOfDay){
			timeOfDay = "7:" + minuteOfDay + "AM";
		}else if(8 == hourOfDay){
			timeOfDay = "8:" + minuteOfDay + "AM";
		}else if(9 == hourOfDay){
			timeOfDay = "9:" + minuteOfDay + "AM";
		}else if(10 == hourOfDay){
			timeOfDay = "10:" + minuteOfDay + "AM";
		}else if(11 == hourOfDay){
			timeOfDay = "11:" + minuteOfDay + "AM";
		}else if(12 == hourOfDay){
			timeOfDay = "12:" + minuteOfDay + "PM";
		}else if(13 == hourOfDay){
			timeOfDay = "1:" + minuteOfDay + "PM";
		}else if(14 == hourOfDay){
			timeOfDay = "2:" + minuteOfDay + "PM";
		}else if(15 == hourOfDay){
			timeOfDay = "3:" + minuteOfDay + "PM";
		}else if(16 == hourOfDay){
			timeOfDay = "4:" + minuteOfDay + "PM";
		}else if(17 == hourOfDay){
			timeOfDay = "5:" + minuteOfDay + "PM";
		}else if(18 == hourOfDay){
			timeOfDay = "6:" + minuteOfDay + "PM";
		}else if(19 == hourOfDay){
			timeOfDay = "7:" + minuteOfDay + "PM";
		}else if(20 == hourOfDay){
			timeOfDay = "8:" + minuteOfDay + "PM";
		}else if(21 == hourOfDay){
			timeOfDay = "9:" + minuteOfDay + "PM";
		}else if(22 == hourOfDay){
			timeOfDay = "10:" + minuteOfDay + "PM";
		}else if(23 == hourOfDay){
			timeOfDay = "11:" + minuteOfDay + "PM";
		}else if(24 == hourOfDay){
			timeOfDay = "12:" + minuteOfDay + "AM";
		}
		return timeOfDay;
	}
	
	public static String getDayOfWeek(){
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		String dayOfWeek = "";
		if(1 == day){
			dayOfWeek = "Sunday";
		}else if(2 == day){
			dayOfWeek = "Monday";
		}else if(3 == day){
			dayOfWeek = "Tuesday";
		}else if(4 == day){
			dayOfWeek = "Wednesday";
		}else if(5 == day){
			dayOfWeek = "Thursday";
		}else if(6 == day){
			dayOfWeek = "Friday";
		}else if(7 == day){
			dayOfWeek = "Saturday";
		}
		return dayOfWeek;
	}

}
