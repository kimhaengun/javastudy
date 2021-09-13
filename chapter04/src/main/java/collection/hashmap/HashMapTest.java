package collection.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		String ks1 = "one";
		//컬렉션에는 객체만 들어갈 수 있다.
		m.put(ks1, 1); //auto boxing Integer(객체)가 들어가야되는데 정수를 넣음
		m.put("two", 2);
		m.put("three", 3);
		
		int i = m.get("one"); //auto unboxing
		int j = m.get(new String("one"));
		System.out.println("i값:"+i);
		System.out.println("j값:"+j);
		
		m.put("three", 33333);
		System.out.println("같은 키로 값이 바뀔까:"+m.get("three"));
		
		//순회
		Set<String> s = m.keySet();
		for(String key:s) {
			System.out.println(m.get(key));
		}
	}
}
