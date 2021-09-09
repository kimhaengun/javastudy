package paint;

public class Main {
	public static void main(String[] args) {
		Point p = new Point(10,10);
//		p.setX(10);
//		p.setY(10);
//		drawPoint(p);
		draw(p);
	//	p.disapear();
		p.show(false);
		
		Point colorPoint = new ColorPoint(100,200,"RED");
		colorPoint.setX(100);
		colorPoint.setY(200);
		//다운캐스팅
//		((ColorPoint)colorPoint).setColor("Red");
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
		
		//=<instanceof>=
		//instanceof test -> 부모, 조상까지 가능 but 형제는 불가능
		//Object(Shape(Triangle,Rectangle,Circle))
		System.out.println(circle instanceof Object);
		System.out.println(circle instanceof Shape);
		System.out.println(circle instanceof Circle);
		//오류 -> 형제 불가능
		//class는 hierachy 상위와 하위만 instanceof 연산자를 사용할 수 있다.
//		System.out.println(circle instanceof Rectangle);
		
		//인터페이스(interface)는 hierachy와 상관없이 instanceof 연산자를 사용할 수 있다
		System.out.println(circle instanceof Drawable);
		//run함수 없음 - false 
		System.out.println(circle instanceof Runnable);
		
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
