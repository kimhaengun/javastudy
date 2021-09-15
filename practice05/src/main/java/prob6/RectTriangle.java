package prob6;

public class RectTriangle extends Shape{
	private double width;
	private double height;
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public RectTriangle(double w, double h) {
		this.width = w;
		this.height = h;
	}
	@Override
	protected double getArea() {

		return width*height*0.5;
	}
	@Override
	protected double getPerimeter() {
		//Math.sqrt --> 제곱근
		double s = Math.sqrt(width*width+height*height);
		return width+height+s;
	}
	

}
