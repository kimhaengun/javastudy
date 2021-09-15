package prob6;

public class Rectangle extends Shape implements Resizable{
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

	public void setHeight(int height) {
		this.height = height;
	}
	
	public Rectangle(double w, double h) {
		this.width = w;
		this.height = h;
	}
	@Override
	public void resize(double s) {
		width=width*s;
		height=height*s;
		

	}
	@Override
	protected double getArea() {
		return width*height;
		
	}
	@Override
	protected double getPerimeter() {
		return (width+height)*2;
	}
	
	

}
