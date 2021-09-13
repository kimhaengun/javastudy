package collection.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class ArrayListTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("김김김");
		list.add("박박박");
		list.add("최최최");
		
		//순회 1
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			System.out.println("List :"+s);
		}
		System.out.println("===============");
		//삭제
		list.remove(2);
		
		//순회2
		Iterator<String> it = list.iterator();
			while (it.hasNext()) {
				String s = it.next();
				System.out.println(s);
			}
		
		System.out.println("===============");
		//순회3
		for (String s : list) {
			System.out.println(s);
		}
	}
}
