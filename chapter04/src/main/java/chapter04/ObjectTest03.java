package chapter04;

public class ObjectTest03 {

	public static void main(String[] args) {
		//new = 메모리 heap공간에 올라가기때문에 주소가 다름
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode()+" : " + s2.hashCode());
		System.out.println(System.identityHashCode(s1)+" : "+System.identityHashCode(s2));
		
		System.out.println("======================");
		String s3 = "Hello";
		String s4 = "Hello";
		
		System.out.println(s3==s4);
		System.out.println(s3.equals(s4));
		System.out.println(s3.hashCode()+" : " + s4.hashCode());
		System.out.println(System.identityHashCode(s3)+" : "+System.identityHashCode(s4));

		System.out.println("======================");
		String r1 = s3.toUpperCase();
		System.out.println(r1 == s4);
		System.out.println("======================");
		s4 = "hello";
		System.out.println(s3 == s4);
	}

}
