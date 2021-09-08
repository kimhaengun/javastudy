package chapter03;

public class SwapTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 20;
		System.out.println(a+":"+b);
		
		//swap하기
		int temple=a;
		a=b;
		b=temple;
		System.out.println(a+":"+b);
	}

}
