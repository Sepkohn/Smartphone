import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ecouteur_Galerie extends MouseAdapter {

	public Ecouteur_Galerie(Ecran ecran) {
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		JFrame test = new JFrame();
		test.setVisible(true);
		test.setSize(200, 200);
	}
	
	public Image ajouter(Image image) {
		
		return image;
		
	}

	

}
