package paint;

public class Main {
	public static void main(String[] args) {
		Point p = new Point();
		p.setX(10);
		p.setY(10);
		drawPoint(p);
	//	p.disapear();
		p.show(false);
		
		Point colorPoint = new ColorPoint();
		colorPoint.setX(100);
		colorPoint.setY(200);
		//다운캐스팅
		((ColorPoint)colorPoint).setColor("Red");
		drawPoint(colorPoint);
		colorPoint.show(false);
		colorPoint.show(true);
		
		//삼각형 그리기
		Triangle triangle = new Triangle();
		drawTriangle(triangle);
		
		//사각형 그리기
		Rectangle rectangle = new Rectangle();
		drawRectangle(rectangle);
		
		//원 그리기
		Circle circle = new Circle();
		drawCircle(circle);
	}

	public static void drawPoint(Point point) {
		point.show();
	}
	
//	public static void drawColorPoint(ColorPoint colorPoint) {
//		colorPoint.show();
//	}
	
	public static void drawTriangle(Triangle triangle) {
		triangle.draw();
	}
	
	public static void drawRectangle(Rectangle rectangle) {
		rectangle.draw();
	}
	
	public static void drawCircle(Circle circle) {
		circle.draw();
	}
}
