package chapter03;

public class Goods {
	//private 사용 시 외부에서 접근 불가 (정보 은닉/캡슐화) / 내부 메서드에서만 접근 가능
	//String은 객체이기 때문에 초기화 가능 = null
	//static - 프로그램 시작부터 끝까지 생존
	//final - (끝) 값을 못바꿈. 
	//JVM = 클래스 파일 로딩 -> static을 모두 찾고 RAM에 저장 -> main()함수 호출
	public static int countOfGoods=0;
	private String name;
	private int price;
	private int countStock;
	private int countSold;
	
	public int calcDiscountPrice(int percentage) {
		return price*percentage/100;
	}
	
	//생성자
	//생성자 없으면 객체 생성 불가능.. 없으면 자동으로 생성 됨	
	public Goods() {
		Goods.countOfGoods++;
	}
	//get,set 외부에서 값에 접근할 수 있도록
	//public -> 외부에서 접근 가능
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	public int getCountSold() {
		return countSold;
	}
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
	@Override
	public String toString() {
		return "Goods [name=" + name + ", price=" + price + ", countStock=" + countStock + ", countSold=" + countSold
				+ "]";
	}
	public void showInfo() {
		// TODO Auto-generated method stub
		System.out.println("name = "+name);
		System.out.println("price = "+price);
		System.out.println("countStock = "+countStock);
		System.out.println("countSold = "+countSold);
	}
	
	
}
