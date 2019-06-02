import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Ecran_Galerie extends JFrame {

    JPanel center = new JPanel();
    JButton plus = new JButton("+");
    JButton cancel = new JButton("Cancel");
    JScrollBar deroulant = new JScrollBar();
	
	/*ImageIcon pikachu;
	ImageIcon salameche;
	ImageIcon dracofeu;*/
    GridLayout centerGrid = new GridLayout(0, 2);


    //static ImageIcon[] tableau = new ImageIcon[1];
    JPanel south = new JPanel();


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
       // setLayout(centerGrid);
        //centerGrid.addLayoutComponent(null, new JLabel(image));
        center.add(new JLabel(image));
        add(center, BorderLayout.CENTER);


        add(deroulant, BorderLayout.EAST);
        //add(south, BorderLayout.CENTER);
        add(cancel, BorderLayout.SOUTH);

        plus.addMouseListener(new Ecouteur_Ecran_Galerie(this));
        cancel.addMouseListener(new Ecouteur_Ecran_Galerie(this));
    }


    static ImageIcon[] getTableau(ImageIcon[] tableau) {

        return tableau;
    }

    public void serialisation(ImageIcon[] tableau) {

        try {
            FileOutputStream out = new FileOutputStream("C:/temp/Smartphone/Images/save.ser");
            ObjectOutputStream oos = new ObjectOutputStream(out);

            for (int i = 0; i < tableau.length; i++) {
                ImageIcon image = tableau[i];
                String link = image.toString();
                oos.writeObject(link + " ");
            }

            oos.close();
        } catch (IOException e) {
            System.out.println("erreur");
        }
    }

    public class Ecouteur_Ecran_Galerie extends MouseAdapter {

        public Ecouteur_Ecran_Galerie(Ecran_Galerie ecran) {

        }

        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub

            Object source = e.getSource();


            if (source == plus) {
                AjoutImage nouveau = new AjoutImage();
                nouveau.setVisible(true);
                //nouveau.setLocation(.getLocation());
                dispose();
            }
            if (source == cancel) {
                if (AjoutImage.tableau != null) {
                    serialisation(AjoutImage.tableau);
                }

                Ecran principal = new Ecran();

                principal.setVisible(true);

                dispose();
            }


        }


    }

}
