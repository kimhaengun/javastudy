package chapter03;

import java.security.spec.MGF1ParameterSpec;

public class StaticMethod {
	int n;
	static int m;
	
	void f1() {
		System.out.println(n);
	}
	
	void f2() {
		System.out.println(StaticMethod.m);
		//같은 클래스에서는 클래스(static) 변수 접근에서는 클래스 이름 생략가능(StaticMethode.m 생략->m)
		System.out.println(m);
	}
	
	void f3() {
		f2();
	}
	
	static void s1() {
		//오류 이유 -> static method에서는 instance 변수에 접근할 수 없다.	
		//System.out.println(n);
	}
	
	static void s2() {
		System.out.println(StaticMethod.m);
		//같은 클래스에서는 클래스(static) 변수 접근에서는 클래스 이름 생략가능(StaticMethode.m 생략->m)
		System.out.println(m);
	}
	
	static void s3() {
		//오류 -> static method에서는 instance 메소드에 접근할 수 없다.
//		f1();
	}
	
	static void s4() {
		StaticMethod.s1();
		s1();
	}
}
