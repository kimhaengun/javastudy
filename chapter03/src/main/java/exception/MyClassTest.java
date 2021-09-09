package exception;

import java.io.IOException;

public class MyClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			MyClass myClass = new MyClass();
			myClass.danger();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error : "+e);
		}
	}

}
