package prob2;

import java.util.Iterator;

public class Prob2 {
	public static void main(String[] args) {
		/* 코드 작성 */
		int num;
		num=10;
		for (int i = 1; i < 11; i++) {
			for (int j = i; j < num+i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		
	}
}
