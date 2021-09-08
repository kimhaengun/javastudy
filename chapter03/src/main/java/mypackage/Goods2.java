package mypackage;

public class Goods2 {
	public String name; //모든 접근 허용
	protected int price; //같은 패키지 클래스 + 자식 접근 가능
	int countStock; //아무것도 없으면 default -> 같은 패키지에서 접근 가능
	private int countSold; //외부 클래스 접근 허가 X, 내부 클래스만 접근 가능
	
	void m() {
		countSold = 100;
	}
}
