package paint;

public class Main {
 public static void main(String[] args) {	
	Point p = new Point();
	p.setX(10);
	p.setY(10);
	drawPoint(p);
//	p.disapear();
	p.show(false);
 }
 
 public static void drawPoint(Point point) {
	 point.show();
 }
 
}
