package paint;

public abstract class Shape {
	private String lineColor;
	private String fillColor;
	
	//추상클래스 -draw()의 기능은 전부 다름
	public abstract void draw();
	
	public String getLineColor() {
		return lineColor;
	}
	public void setLineColor(String lineColor) {
		this.lineColor = lineColor;
	}
	public String getFillColor() {
		return fillColor;
	}
	public void setFillColor(String fillColor) {
		this.fillColor = fillColor;
	}
	
}
