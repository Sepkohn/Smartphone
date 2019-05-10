import java.awt.BorderLayout;

import javax.swing.*;

public class Ecran_Galerie extends JFrame{
	
	JButton plus = new JButton ("+");
	
	JSlider deroulant = new JSlider(JSlider.VERTICAL);
	
	/*ImageIcon pikachu;
	ImageIcon salameche;
	ImageIcon dracofeu;*/
	
	ImageIcon[] tableau = new ImageIcon[0];
	
	JPanel south =  new JPanel();
	
	
	public Ecran_Galerie() {
	
	
		
	/*pikachu = new ImageIcon("C:/temp/Smartphone/Images/pika.jpg");
	salameche = new ImageIcon("C:/temp/Smartphone/Images/sala.jpg");
	dracofeu = new ImageIcon("C:/temp/Smartphone/Images/draco.jpg");
		
	south.add(new JLabel(pikachu));
	south.add(new JLabel(salameche));
	south.add(new JLabel(dracofeu));*/

	setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	add(plus, BorderLayout.NORTH);
	
	add(south, BorderLayout.CENTER);
	
	add(deroulant, BorderLayout.EAST);
	
	plus.addMouseListener(new Ecouteur_Ecran_Galerie(this));
		
	}
	
	
	


}
