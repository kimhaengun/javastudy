package exception;

import java.io.IOException;

public class MyClass {
	// exception 만들기
	// danger 메소드 쓰려면 exception처리 해야돼~
	public void danger() throws IOException, MyException {
		System.out.println("some codes1");
		System.out.println("some codes2");
		
		//Myexception 발동
		if(5-5==0){
			throw new MyException();		
				}
		
		//exception 발동
		if(10-10==0) {
			throw new IOException();	
		}
		
		System.out.println("some codes3");
		System.out.println("some codes4");
	}
}
