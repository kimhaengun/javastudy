package prob01;

import java.util.Iterator;
import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		/* 코드 작성 */
		System.out.println("금액 : ");
		int price = scanner.nextInt();
		// price/Moneys 몫 값
		for (int i = 0; i < MONEYS.length; i++) {
			int count = price/MONEYS[i];
			if (count>=1) {
				for (int j = 1; j <= count; j++) {
					price=price-MONEYS[i];
				}
			}
			System.out.println(MONEYS[i]+"원 :"+count+"개");
		}
		
		
		scanner.close();
 	}
}