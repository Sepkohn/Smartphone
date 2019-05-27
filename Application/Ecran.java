import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


public class Ecran extends JFrame implements MouseListener {
	
	JButton cancel = new JButton("O");
	JButton galerie = new JButton("Galerie");
	JButton contact = new JButton("Contacts");
	JButton undo = new JButton("Back");
	
	JPanel south = new JPanel();
	JPanel centre = new JPanel();

	//Horloge layout




	public Ecran() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		south.add(cancel);
		south.add(undo);
		
		centre.add(galerie);
		centre.add(contact);



		//voir si on peut mettre un fond d'ecran...
		centre.setOpaque(false);


		setTitle("Smartphone");
		
		getContentPane().setBackground(Color.BLACK);
		
		add(south, BorderLayout.SOUTH);
		add(centre, BorderLayout.CENTER);




		galerie.addMouseListener(new Ecouteur_Galerie(this));
		contact.addMouseListener(new Ecouteur_Contact(this));

		//ajout de l'horloge dans l'écran principal (AMK)


	}




	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
