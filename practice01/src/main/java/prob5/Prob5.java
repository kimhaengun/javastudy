package prob5;

import java.util.Iterator;

public class Prob5 {

	public static void main(String[] args) {
		int num = 100;
		int count = 0;
		for (int i = 0; i < num; i++) {
			//형 변환
			String str = String.valueOf(i);
			int strlength=str.length(); //문자열 길이
			for (int j = 0; j < strlength; j++) {
				char c = str.charAt(j);
				if (c=='3'||c=='6'||c=='9') { //하나라도 참일 경우
					count++;
				}//end if
				
			}//end for
		}//end for
	}
}
