package paint;

public class ColorPoint extends Point {
	private String color;
	
//	public ColorPoint() {
//		//super();가 자동으로 생성되는데 Point의 기본 생성자가 다름
//	}
	
	public ColorPoint(int x, int y, String color) {
		// TODO Auto-generated constructor stub
		//super 부모 클래스 생성자 x,y
		super(x, y);
//		setX(x);
//		setY(y);
		this.color=color;
	}


	//부모 Point의 show()메소드를 오버라이딩
	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("점[x="+getX()+", y="+getY()+", color="+color+"]를 그렸습니다.");
	}

	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
