package chapter04.single;

public class MyclassTest {
	public static void main(String[] args) {
		//싱글 톤 -
//		MyClass myClass = new MyClass();
		MyClass myClass1 = MyClass.getInstance();
		MyClass myClass2 = MyClass.getInstance();
		
		System.out.println(myClass1 == myClass2);
	}
}
