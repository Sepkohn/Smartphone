import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


public class Ecran extends JFrame{
	
	JButton cancel = new JButton("O");
	JButton galerie = new JButton("Galerie");
	JButton contact = new JButton("Contacts");
	JButton undo = new JButton("Back");
	
	JPanel south = new JPanel();
	JPanel centre = new JPanel();



	public Ecran() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,800);

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

	public class Ecouteur_Galerie extends MouseAdapter {
		public Ecouteur_Galerie(Ecran ecran) {
		}

		public void mouseClicked(MouseEvent e) {
			Ecran_Galerie test = new Ecran_Galerie(null);
			test.setVisible(true);
			dispose();
		}

		public Image ajouter(Image image) {
			return image;
		}
	}
}
