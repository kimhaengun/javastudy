package tv;

public class WatchTv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1번째
		TV tv = new TV( 7, 20, false);
		 
		tv.status();
		
		//2번째
		tv.power( true );

		tv.volume( 120 );
		
		tv.status();
		
		//3번째
		tv.volume( false );

		tv.status();
		
		//4번째
		tv.channel( 0 );

		tv.status();
		
		//5번째
		tv.channel( true );

		tv.channel( true );

		tv.channel( true );

		tv.status();
		
		//6번째
		tv.power( false );

		tv.status();

	}

}
