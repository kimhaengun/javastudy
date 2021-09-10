package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		Point p = new Point(10,20);
		
		//reflection , 어떤 클래스에서 만들어 져있는가 (클래스 정보)
//		Class klass = p.getClass();
		System.out.println(p.getClass());
		
		//hashig : 정수값으로 만드는 것
		//hashCode : 객체의 주소기반의 정수 값(address 기반의 해싱값)
		//			 주소값 x
		//			 reference값 x
		//해싱값으로 빠른 검색을 하기위해 사용, 암호화 목적이 아님!
		System.out.println(p.hashCode());
		
		//x,y값을 뿌려주는 것이 아니다.
		//결과 = getClass()+"@"+hashCode()
		System.out.println(p.toString());
		
		//객체의 toString값 (toString()생략 가능함)
		System.out.println(p);
	}

}
