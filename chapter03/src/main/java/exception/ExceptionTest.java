package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 10-a;
		
		System.out.println("some code1 ...");
		try {
			System.out.println("come code2 ...");
			int result = (1+2+3)/b;	
			System.out.println("come code3 ...");
			System.out.println("come code4 ...");
		}catch (ArithmeticException e) {
			// 예외처리
			// 1.사용자에게 제공(사과)
			System.out.println("sorry...");
			// 2.로깅(log 남기기)
			System.out.println("error :"+e);
			// 3.정상 종료(clear)
			return;
		}finally { //자원 정리
			//프로그램이 종료되면 무조건 실행됨 = finally
			System.out.println("자원 정리");
		}

	}

}
