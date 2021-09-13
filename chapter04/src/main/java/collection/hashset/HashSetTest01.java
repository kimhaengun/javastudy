package collection.hashset;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest01 {
	public static void main(String[] args) {
		//키, 인덱스가 존재하지 않음.
		Set<String> s = new HashSet<String>();
		s.add("둘리");
		s.add("마이콜");
		s.add("또치");
		
		String s1 = new String("도우너");
		String s2 = new String("도우너");
		s.add(s1);
		//내용으로만 봄
		System.out.println("도우너가 있니:"+s.contains(s2));
		
		System.out.println("Set size :"+s.size());
		//contains = 해당 값이 있는지 확인할 수 있다.
		System.out.println("둘리가 있니:"+s.contains("둘리"));
		//순회1
		for(String str : s) {
			System.out.println(str);
		}
	}
}
