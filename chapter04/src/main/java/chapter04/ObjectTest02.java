package chapter04;

public class ObjectTest02 {
	public static void main(String[] args) {
		Point p1 = new Point(10, 20);
		Point p2 = new Point(10, 20);
		Point p3 = p2;
		
		// == 두 객체의 동일성을 비교하는 것
		System.out.println(p1==p2); //f
		System.out.println(p2==p3); //t
		
		// equals: 두 객체의 동질성(내용비교)
		// 	       부모 클래스 Object의 기본 구현은 동일성(==) 비교와 같다.
		System.out.println(p1.equals(p2)); //기본:f /equals 오버라이딩해서 만들어서 사용하면 t
		System.out.println(p2.equals(p3)); //기본:t /
	}
}
