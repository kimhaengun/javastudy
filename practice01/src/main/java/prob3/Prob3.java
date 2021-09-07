package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		/* 코드 작성 */
		System.out.println("숫자를 입력하세요 : ");
		int num = scanner.nextInt();
		int result = 0;
		//홀수
		if (num % 2 == 1){
			for (int i = 0; i <= num; i+=2) {
				result+=i;
			}	
			System.out.println("홀수 결과 값 : "+result);
		}else if(num % 2 == 0){ //짝수
			for (int i = 0; i <= num; i+=2) {
				result+=i;
			}
			System.out.println("짝 수결과 값 : "+result);
		}
		
		scanner.close();
	}
}
