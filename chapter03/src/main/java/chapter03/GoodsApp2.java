package chapter03;

import mypackage.Goods2;

public class GoodsApp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Goods2 goods2 = new Goods2();
		goods2.name="camera"; //name = public (접근제한x)
//		goods2.price = 10000; //price = protected(같은패키지에서 접근가능,*자식에서도 접근 가능*)
//		goods2.countStock=20; //countStock = default(같은 패키지만 접근 가능)
//		goods2.countSold=10;//countSold = private(내부 클래스에서만 접근 가능하기 때문에 오류)

	}

}
