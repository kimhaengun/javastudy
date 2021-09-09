package prob03;

public class CurrencyConverterTest {

	public static void main(String[] args) {
		CurrencyConverter currencyConverter = new CurrencyConverter();
		//  환율을 세팅 합니다.
		currencyConverter.setRate(1197.0);
		
		//한국 원화 -> 달러
		double dollar = currencyConverter.toDollar( 1000000. );
		System.out.println( "백만원은 " + dollar + "달러 입니다" );
		
		//달러 -> 한국 원화
		double krw = currencyConverter.toKRW( 100. );
		System.out.println( "백달러는 " + krw + "원 입니다" );
	}

}
