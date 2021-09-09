package paint;

public class ColorPoint extends Point {
	private String color;
	
	
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
