package chapter03;

public class SwapTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 20;
		System.out.println(a+":"+b);
		
		//swap하기
		swap(a, b);
		
		System.out.println(a+":"+b);
	}
	public static void swap(int p,int q) {
		int temple=p;
		p=q;
		q=temple;
	} //함수 종료(block 영역 탈출) 시 지역변수 값 튀어나감 (사라짐)

}
