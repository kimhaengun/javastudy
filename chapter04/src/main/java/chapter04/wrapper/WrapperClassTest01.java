package chapter04.wrapper;

public class WrapperClassTest01 {
	public static void main(String[] args) {
		Integer i = new Integer(10);
		Character c = new Character('c');
		Boolean b = new Boolean(true);
		
		//Auto Boxing
		Integer j = 10;
		Integer j2 = 10;
		
		System.out.println(j == j2);
		System.out.println(j.equals(j2));
		
		//Auto Boxing
//		int m = j.intValue() +10 ;  ==
		int m = j+10;
		
	}
}
