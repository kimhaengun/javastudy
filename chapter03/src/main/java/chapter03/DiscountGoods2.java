package chapter03;

import mypackage.Goods2;

public class DiscountGoods2 extends Goods2 {
	//float 설정
	private float discountRate = 0.5f;
	
	public float getDiscountPrice() {
		//price = protected는 자식에서 접근할 수 있기 때문에 사용이 가능하다.
		return discountRate*price;
	}
}
