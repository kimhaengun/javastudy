package paint;

public class Point {
	private int x;
	private int y;
	
	public void show() {
		System.out.println("점[x="+x+", y="+y+"]를 그렸습니다.");
	}
	public void show(boolean visible) {
		if (visible==true) {
			//반복 코드 생성 X
//			System.out.println("점[x="+x+", y="+y+"]를 그렸습니다.");
			show();
		}else {
			System.out.println("점[x="+x+", y="+y+"]를 지웠습니다.");
		}
	}
//	public void disapear() {
//		System.out.println("점[x="+x+", y="+y+"]를 지웠습니다.");
//	}
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}
