package prob03;

public class CurrencyConverter {
	private double rate;

	public double getRate() {
		return rate;
	}


	public void setRate(double rate) {
		this.rate = rate;
		System.out.println("현재 환율: "+this.rate);
	}


	//한국 원화 -> 달러
	public double toDollar(double krw) {

		return krw/rate;
	}
	
	//달러 -> 원화
	public double toKRW(double dollar) {

		return dollar*rate;
	}
}
