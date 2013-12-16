import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;


public class GetMousePosition {
	public static void main(String[] args){
	
		while (true) {
			PointerInfo info = MouseInfo.getPointerInfo();
			Point p = info.getLocation();
			double x = p.getX();
			double y = p.getY();
			System.out.println(x + "\t" + y);
		}
		
	}
}
