import java.awt.Point;
import javax.swing.JFrame;

public class lancement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		Ecran smartphone = new Ecran();
		
		smartphone.setVisible(true);	
		
		

	}

	public static Point getLocation (JFrame ecran) {
		
		Point location = new Point();
		location = ecran.getLocation();
		
		return location;
		
	}
}
