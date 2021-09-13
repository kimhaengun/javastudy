package chapter04.date;

import java.util.Calendar;

public class CalendarTest {
	public static void main(String[] args) {
		//Calendar는 추상으로 만들어져 new가 안됨
		//getInstance 메소드를 가져와서 사용해야 한다.
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2021);
		cal.set(Calendar.MONDAY, 11); //->12월(Month-1)
		cal.set(Calendar.DATE, 25);
		printDate(cal);
		
		//2021.09.13~ 100일 후 값 구하기
		cal.set(2021, 9, 13);
		cal.add(Calendar.DATE, 100);
		printDate(cal);
		
	}
	public static void printDate(Calendar cal) {
		final String[] DAYS= {"일","월","화","수","목","금","토"};
		int year = cal.get(Calendar.YEAR);
		//0~11 +1
		int month = cal.get(Calendar.MONTH);
		int date = cal.get(Calendar.DATE);
		//1(일)~7(토)
		int day = cal.get(Calendar.DAY_OF_WEEK);
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		System.out.println(year+"년 "+
				(month+1)+"월 "+
				(date)+"일 "+
				(DAYS[day-1])+"요일 "+
				(hour)+"시 "+
				(minute)+"분 "+
				(second)+"초");
	}
}
