package collection.vector;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest01 {
	public static void main(String[] args) {

		Vector<String> v = new Vector<>();

		v.addElement("둘리");
		v.addElement("또치");
		v.addElement("희동이");

		// 순회
		for (int i = 0; i < v.size(); i++) {
			System.out.println("Vector 값:" + v.elementAt(i));
		}
		System.out.println("===================");
		// 삭제 - 희동이
		v.removeElementAt(2);
		// 순회2
		Enumeration<String> e = v.elements();
		while(e.hasMoreElements()) {
			String s = e.nextElement();
			System.out.println(s);
		}
	}
}
