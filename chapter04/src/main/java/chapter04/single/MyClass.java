package chapter04.single;

public class MyClass {
	private static MyClass instance=null;
	
	private MyClass() {
		
	}
	
	//singleton + Factory Method
	public static MyClass getInstance() {
		if (instance == null) {
			instance = new MyClass();
		}
		return instance;
	}
}
