import java.awt.*;
import javax.swing.*;

import javafx.scene.layout.Background;

public class Ecran extends JFrame{
	
	JButton cancel = new JButton("O");
	JButton galerie = new JButton("Galerie");
	JButton contact = new JButton("Contacts");
	JButton undo = new JButton("Back");
	
	JPanel south = new JPanel();
	JPanel centre = new JPanel();
	
	public Ecran () {
		
		
		south.add(cancel);
		south.add(undo, BorderLayout.LINE_END);
		
		centre.add(galerie);
		centre.add(contact);
		
		//centre.setBackground(Color.GREEN);
		centre.setOpaque(false);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setTitle("Smartphone");
		
		getContentPane().setBackground(Color.BLACK);
		
		add(south, BorderLayout.SOUTH);
		add(centre, BorderLayout.CENTER);
		
	// test commentaire
		// test commentaire 2
		
		
		
	}


}
