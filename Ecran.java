import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Base64;

import javax.swing.*;

public class Ecran extends JFrame{
	
	JButton cancel = new JButton("O");
	JButton galerie = new JButton("Galerie");
	JButton contact = new JButton("Contacts");
	JButton back = new JButton("Back");
	
	JPanel south = new JPanel();
	JPanel centre = new JPanel();
	
	public Ecran () {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(700, 50);
		setSize(500,900);
		
		south.add(cancel);
		south.add(back);
		
		centre.add(galerie);
		centre.add(contact);
		
		//centre.setBackground(Color.GREEN);
		centre.setOpaque(false);
		
		
		setTitle("Smartphone");
		
		getContentPane().setBackground(Color.BLACK);
		
		add(south, BorderLayout.SOUTH);
		add(centre, BorderLayout.CENTER);
		
	
		galerie.addMouseListener(new Ecouteur_Galerie(this));
		
		//back.addMouseListener(new Ecouteur_Galerie());
		//contact.addMouseListener(new Ecouteur_Contact());

		
		
		
	}
	
	public class Ecouteur_Galerie extends MouseAdapter {


		public Ecouteur_Galerie(Ecran ecran){
			
		}

		public void mouseClicked(MouseEvent e) {
			
		
			
			try {
				 FileInputStream in = new FileInputStream( "C:/temp/Smartphone/Images/save.ser" );
				 ObjectInputStream is = new ObjectInputStream( in );
				 //ImageIcon[] AjoutImage.e= (ImageIcon[]) ois.readObject();
				 String galerie_from_disk = (String) is.readObject();
				 is.close();
				 byte[] test = galerie_from_disk.getBytes();
					 
				} catch(IOException | ClassNotFoundException e1) { 
				}
			
			
			
			
			// TODO Auto-generated method stub
				
			Ecran_Galerie test = new Ecran_Galerie(null);
			test.setVisible(true);
	
			dispose();

		}


	}
 
		
	



}
