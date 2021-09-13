package chapter04.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	
	public static void main(String[] args) {
		//현재 시간 - Date(java.util) 
		Date now = new Date();
		System.out.println(now);
		
		//개별적으로 시간 값을 뽑기
		printDate01(now);
		printDate02(now);
	}
	public static void printDate01(Date d) {
		//년도를 4개로 구분하기 ex)YYYY
		//2020-09-13 16:06:30
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf.format(d);
		System.out.println(date);
	}
	public static void printDate02(Date d) {
		// 년도(+1900)
		int year = d.getYear();
		// 월(0~11) --> +1 해줘야 한다.
		int month = d.getMonth();
		// 일
		int day = d.getDay();
		//시
		int hours = d.getHours();
		//분
		int minutes = d.getMinutes();
		//초
		int seconds = d.getSeconds();
		System.out.println((year+1900)+"-"+
							(month+1)+"-"+
							(day)+" "+
							(hours)+":"+
							(minutes)+":"+
							(seconds));
	}
}
