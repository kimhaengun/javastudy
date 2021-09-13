package collection.stack;

import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		//push : 삽입, pop : 삭제
		Stack<String> s = new Stack<String>();
		
		s.push("하나");
		s.push("둘");
		s.push("셋");
		while(!s.isEmpty()) {
			String s1 = s.pop();
			System.out.println("pop() : "+s1);
		}
		
		//비어있는 경우에 예외 발생.(EmptyStackException)
//		s.pop();
		s.push("하나");
		s.push("둘");
		s.push("셋");
		System.out.println(s.pop());
		//맨위에 뭐가 있을까
		System.out.println(s.peek());
		System.out.println(s.pop());
	}
}
