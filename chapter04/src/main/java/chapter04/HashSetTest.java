package chapter04;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
	public static void main(String[] args) {
		Set<Rect> set =  new HashSet<>();
		
		Rect r1 = new Rect(10, 20);
		Rect r2 = new Rect(10, 20);
		
		set.add(r1);
		set.add(r2);
		
		//hashCode가 있을경우 값이 같기 때문에 하나만 출력 
		// 없으면 주소가 다르기 때문에 다른 값이라 판한다고 두개가 출력
		
		for(Rect r : set) {
			System.out.println(r.toString());
		}
	}
}
