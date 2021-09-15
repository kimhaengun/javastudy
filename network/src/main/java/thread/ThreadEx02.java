package thread;

public class ThreadEx02 {
	public static void main(String[] args) {
		Thread t1 = new DigitThread();
		Thread t2 = new AlphabetThread();
		t1.start();
		t2.start();
	}
}
