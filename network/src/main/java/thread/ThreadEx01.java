package thread;

public class ThreadEx01 {
	public static void main(String[] args) {

//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//
//				for (int i = 0; i < 10; i++) {
//					System.out.print(i);
//				}
//			}
//		}).start();
		new DigitThread().start();
		for (char c = 'a'; c <= 'z'; c++) {
			System.out.print(c);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
