package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );

		while( true ) {
			
			/* 게임 작성 */
			System.out.println("수를 결정하였습니다. 맞추어 보세요.");
			System.out.println("1~100");

			// 정답 램덤하게 만들기
			Random random = new Random();
			int correctNumber = random.nextInt( 100 ) + 1;
			System.out.println(correctNumber);
			boolean succes = true;
			int count =0;
			int low=1;
			int hight=100;
			while(succes) {
				count++;
				System.out.print(count+">>");
				int result = scanner.nextInt();
				
				if (result > correctNumber) {
					System.out.println("더 낮게");
					hight = result;
					System.out.println(low+"~"+hight);
					
				}else if(result < correctNumber) {
					System.out.println("더 높게");
					low=result;
					System.out.println(low+"~"+hight);
				}else if(result == correctNumber) {
					System.out.println("맞았습니다.");
					succes = false;
				}
			}
			
			
			//새 게임 여부 확인하기
			System.out.print( "다시 하겠습니까(y/n)>>" );
			String answer = scanner.next();
			if( "y".equals( answer ) == false ) {
				break;
			}
		}
		
		
		scanner.close();
	}

}