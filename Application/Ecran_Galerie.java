import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;

import javax.swing.*;

public class Ecran_Galerie extends JFrame{
	
	JButton plus = new JButton ("+");
	JButton cancel = new JButton ("Cancel");
	
	JSlider deroulant = new JSlider(JSlider.VERTICAL);
	
	/*ImageIcon pikachu;
	ImageIcon salameche;
	ImageIcon dracofeu;*/
	
	JPanel south = new JPanel();
	
	//static ImageIcon[] tableau = new ImageIcon[1];
	
	static JPanel center= new JPanel();
	
	
	public Ecran_Galerie(ImageIcon image) {

		setSize(400, 800);
	
		
	
		
	/*pikachu = new ImageIcon("C:/temp/Smartphone/Images/pika.jpg");
	salameche = new ImageIcon("C:/temp/Smartphone/Images/sala.jpg");
	dracofeu = new ImageIcon("C:/temp/Smartphone/Images/draco.jpg");
		
	south.add(new JLabel(pikachu));
	south.add(new JLabel(salameche));
	south.add(new JLabel(dracofeu));*/

	//setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	add(plus, BorderLayout.NORTH);
	
	center.add(new JLabel(image));
	add(center, BorderLayout.CENTER);
	
	
	
	add(deroulant, BorderLayout.EAST);
	//add(south, BorderLayout.CENTER);
	add(cancel, BorderLayout.SOUTH);
	
	plus.addMouseListener(new Ecouteur_Ecran_Galerie(this));
	cancel.addMouseListener(new Ecouteur_Ecran_Galerie(this));
	}

	
	static ImageIcon[] getTableau (ImageIcon[] tableau) {
		
		return tableau;		
	}
	
	public class Ecouteur_Ecran_Galerie extends MouseAdapter{
		
		public Ecouteur_Ecran_Galerie(Ecran_Galerie ecran){
			
		}
		
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			Object source = e.getSource();
			
			
			if(source==plus) {
			AjoutImage nouveau = new AjoutImage();
			nouveau.setVisible(true);
			//nouveau.setLocation(.getLocation());
			dispose();
			}
			if(source ==cancel) {
				
				serialisation(AjoutImage.tableau);
			
				Ecran principal = new Ecran();
				
				principal.setVisible(true);
				
				dispose();
			}
			
			
			
			
		}
		
		

	}

	public void serialisation(ImageIcon[] tableau) {
	 
 
	 try {
		 FileOutputStream out = new FileOutputStream( "C:/temp/Smartphone/Images/save.ser" );
		 ObjectOutputStream oos = new ObjectOutputStream( out );
		 oos.writeObject(tableau);
		 oos.close(); 
		} catch(IOException e) { 
 }
 }

}
