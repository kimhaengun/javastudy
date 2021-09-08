package chapter03;

public class GoodsApp {
	//static 사용하면 공유해서 사용가능
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Goods goods = new Goods();
		goods.setName("Nikon");
		goods.setPrice(40000);
		goods.setCountStock(30);
		goods.setCountSold(20);
		System.out.println(goods.toString());
		goods.showInfo();
		
		System.out.println(Goods.countOfGoods);
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		System.out.println(Goods.countOfGoods);
		
		int discountPrice = goods.calcDiscountPrice(50);
		System.out.println(discountPrice);
	}

}
