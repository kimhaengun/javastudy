package collection.hashset;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest02 {
	public static void main(String[] args) {
		//HashSet 사용 조건 --> equals,hashcode
		Set<Gugudan> set = new HashSet<>();
		
		set.add(new Gugudan(2,3));
		set.add(new Gugudan(9,9));
		set.add(new Gugudan(3,2));
		for(Gugudan g : set) {
			System.out.println(g);
		}
	}
}
