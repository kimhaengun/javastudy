package tv;

public class TV {
	private int channel; //1~255
	private int volume; //0~100 , power = true 일때만.
	private boolean power;
	
	public void status() {
		System.out.println("TV [channel=" + channel + ", volume=" + volume + ", power=" + power + "]");
	}

	public TV(int channel, int volume, boolean power) {
		this.channel=channel;
		this.volume=volume;
		this.power=power;
	}
	//전원 상태
	public void power(boolean b) {
		// TODO Auto-generated method stub
		this.power = b;
		
	}
	//볼륨 수
	public void volume(int i) {
		// TODO Auto-generated method stub
		if(0<=i&&i<101) {
			this.volume=i;
		}else {
			System.out.println("소리 설정 범위 초과");
		}
		
	}
	
	//볼륨 증감
	public void volume(boolean b) {
		// TODO Auto-generated method stub
		if(b==false) {
			this.volume--;
		}else {
			this.volume++;
		}
	}
	//채널 수
	public void channel(int i) {
		// TODO Auto-generated method stub
		if(1<=i&&i<256) {
			this.channel=i;	
		}else {
			System.out.println("해당 채널 없음");
		}	
	}
	
	//채널 증감
	public void channel(boolean b) {
		// TODO Auto-generated method stub
		if(b==true) {
			this.channel++;
		}else {
			this.channel--;
		}
	}







}
