import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ecouteur_Galerie extends MouseAdapter {

	
	public Ecouteur_Galerie(Ecran ecran){
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
		Ecran_Galerie test = new Ecran_Galerie();
		test.setVisible(true);
		test.setSize(500, 900);
		test.setLocationRelativeTo(test);
	
	}

	

}
