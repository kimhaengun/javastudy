package prob5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class MyStack {
	protected int size; //3 
	protected int top; // 초기값 0
	protected String[] array;
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
		if(size==array.length) {
			//배열 크기 초과시 ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ
			String[] array1 = new String[this.size+1];
			for (int i = 0; i < array.length; i++) {
				array1[i]=array[i];
			}
			}
		array[++top] = string;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public String pop() {
		// TODO Auto-generated method stub
		return null;
	}

	
}