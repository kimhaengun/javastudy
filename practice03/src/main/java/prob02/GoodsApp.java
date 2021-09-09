package prob02;

import java.util.Iterator;
import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		for (int i = 0; i < goods.length; i++) {
			String[] str = scanner.nextLine().split(" ");
			String product = str[0];
			int price = Integer.parseInt(str[1]);
			int amount = Integer.parseInt(str[2]);
			goods[i] = new Goods();
			goods[i].setProduct(product);
			goods[i].setPrice(price);
			goods[i].setAmount(amount);
		}
		// 상품 출
		for (int i = 0; i < goods.length; i++) {
			System.out.println(goods[i].getProduct()+"(가격:"+goods[i].getPrice()+"원)이 "+goods[i].getAmount()+"개 입고 되었습니다.");

		}
		// 자원정리
		scanner.close();
	}
}
