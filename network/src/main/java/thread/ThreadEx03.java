package thread;

public class ThreadEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new DigitThread();
		Thread t2 = new AlphabetThread();
		Thread t3 = new Thread(new UppserCaseAlphabetRunnableImpl());
	
		t1.start();
		t2.start();
		t3.start();
	}

}
