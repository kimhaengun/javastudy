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
	}

	public static void drawPoint(Point point) {
		point.show();
	}
	
//	public static void drawColorPoint(ColorPoint colorPoint) {
//		colorPoint.show();
//	}
}
