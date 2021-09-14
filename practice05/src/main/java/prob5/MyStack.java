package prob5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class MyStack {
	protected int size; //3 
	protected int top; // 초기값 -1
	protected String[] array;
	/*제너릭 배열 설정 -> 제너릭(타입을 설정할 수 있다.)*/ 
	// 오브젝트로 생성후 캐스팅
	// ex) MyStack<T>
	//     T[] buffer = (T[])new Object[];
	
	public MyStack(int i) {
		this.size = i;
		this.top=-1;
		array = new String[this.size];
	}

	public void push(String string) {
		// TODO Auto-generated method stub 
		//size 3, length 3
//		System.out.println("s"+size);
//		System.out.println("l"+array.length);
		if(top==array.length-1) {
			//배열 크기 초과시 ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ
			String[] array1 = new String[size*2];
			for (int i = 0; i < array.length; i++) {
				array1[i]=array[i];
//				System.out.println("array1값:"+array1[i]);
			}
			array=array1; //array1 값 -> array
			}
		array[++top] = string;
//		for (int i = 0; i < array.length; i++) {
//			System.out.println("array값"+i+":"+array[i]);
//		}
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public String pop() {
		// TODO Auto-generated method stub
		String result = array[top];
		array[top]=null;
		top--;
		for (int i = 0; i < array.length; i++) {
			System.out.println("null 체크:"+i+":"+array[i]);
		}
		return result;
	}

	
}