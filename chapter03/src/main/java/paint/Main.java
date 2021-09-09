package paint;

public class Main {
	public static void main(String[] args) {
		Point p = new Point();
		p.setX(10);
		p.setY(10);
//		drawPoint(p);
		draw(p);
	//	p.disapear();
		p.show(false);
		
		Point colorPoint = new ColorPoint();
		colorPoint.setX(100);
		colorPoint.setY(200);
		//다운캐스팅
		((ColorPoint)colorPoint).setColor("Red");
//		drawPoint(colorPoint);
		draw(colorPoint);
		colorPoint.show(false);
		colorPoint.show(true);
		
		//삼각형 그리기
		Triangle triangle = new Triangle();
//		drawTraingle(triangle);
//		drawShape(triangle);
		draw(triangle);
		
		//사각형 그리기
		Rectangle rectangle = new Rectangle();
//		drawRectangle(rectangle);
//		drawShape(rectangle);
		draw(rectangle);
		
		//원 그리기
		Circle circle = new Circle();
//		drawCircle(circle);
//		drawShape(circle);
		draw(circle);
		
		//Graphic
		GraphicText graphicText = new GraphicText("Hello World");
		draw(graphicText);
	}
	public static void draw(Drawable drawble) {
		drawble.draw();
	}
	
//	public static void drawPoint(Point point) {
//		point.show();
//	}
	
//	public static void drawColorPoint(ColorPoint colorPoint) {
//		colorPoint.show();
//	}

//	public static void drawShape(Shape shape) {
//		shape.draw();
//	}
	
//	public static void drawTriangle(Triangle triangle) {
//		triangle.draw();
//	}
//	
//	public static void drawRectangle(Rectangle rectangle) {
//		rectangle.draw();
//	}
//	
//	public static void drawCircle(Circle circle) {
//		circle.draw();
//	}
	

}
