package chapter04.string;
//제어 문자
public class StringTest01 {
	public static void main(String[] args) {
		// c:\temp
		System.out.println("c:\temp"); //c:	emp
		//출력 문자라고 알려주기 : \
		System.out.println("c:\\temp"); //c:\temp
		
		
		System.out.println("\"hello\""); // "hello"
		
		// \t : tab
		// \r : carrige return
		// \n : newline
		// \b : beep
		
		System.out.print("hello\tworld\n");
		System.out.println("hello");
		char c ='\'';
		System.out.println(c);
	}
}
