package prob01;

public class Printer {

//	public void println(int i) {
//		// TODO Auto-generated method stub
//		System.out.println(i);
//	}
//	public void println(boolean b) {
//		// TODO Auto-generated method stub
//		System.out.println(b);
//	}
//	public void println(double b) {
//		// TODO Auto-generated method stub
//		System.out.println(b);
//	}
//	public void println(String s) {
//		// TODO Auto-generated method stub
//		System.out.println(s);
//	}
	
	//제너릭 활용해보기
//	public <T> void println(T t) { //파라매터에 대한 제너릭 <T>
//		System.out.println(t);
//	}
	
	//============================================
	
	//... ->여러개의 Integer가 들어 올 수있다.
	public int sum(Integer... nums) {
		Integer sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum+=i;
		}
		return sum;
	}
	
	//제너릭으로 활용
	public <T> void println(T... ts) { //파라매터에 대한 제너릭 <T>
		
		for(T t:ts) {
			System.out.println(t);	
		}
	}
	
}
