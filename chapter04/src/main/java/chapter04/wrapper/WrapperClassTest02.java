package chapter04.wrapper;

public class WrapperClassTest02 {
	public static void main(String[] args) {
		String s1 = "123456";
		//String -> Integer
		int i = Integer.parseInt(s1);
		
		//Integer -> String
		String s2 = String.valueOf(i);
		
		String s3 = ""+i;
		
		System.out.println(s1+":"+s2+":"+s3);
		
		//A의 아스키코드
		char c = 'A';
		int a = Character.getNumericValue('A');
		System.out.println(a);
		System.out.println("A의 아스키 코드 값 : "+(int)c);
		
		//2진수
		String s4 = Integer.toBinaryString(15);
		System.out.println("2진수:"+s4);
		
		//16진수
		String s5 = Integer.toHexString(15);
		System.out.println("16진수:"+s5);
	}
}
