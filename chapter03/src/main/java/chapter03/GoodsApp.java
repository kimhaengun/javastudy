package chapter03;

public class GoodsApp {
	//static 사용하면 공유해서 사용가능
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Goods goods = new Goods();
		goods.setName("Nikon");
		goods.setPrice(400000);
		goods.setCountStock(30);
		goods.setCountSold(20);
		goods.toString();
		System.out.println(goods.toString());
		goods.showInfo();

		
	}

}
