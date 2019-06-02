import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Ecran extends JFrame {

    private JButton cancel = new JButton("O");
    JButton galerie = new JButton("Galerie");
    JButton contact = new JButton("Contacts");
    JButton undo = new JButton("Back");

    JPanel south = new JPanel();
    JPanel centre = new JPanel();


    public Ecran() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 800);

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
            Ecran_Galerie test = new Ecran_Galerie();
            test.setVisible(true);
            try {
                AjoutImage.tableau = deserialisation();
            } catch (IOException ex) {
                ex.printStackTrace();
                System.out.println("Import Export exception");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
                System.out.println("Classe non trouvée");
            }
            dispose();
        }

        public Image ajouter(Image image) {
            return image;
        }
    }

    public ImageIcon[] deserialisation () throws IOException, ClassNotFoundException {
        ImageIcon[] newTableau = new ImageIcon[0];
        FileInputStream fis = null;
        try {
            // fis = new FileInputStream("C:/temp/Smartphone/Out/production/Smartphone/Images/save.ser");
            fis = new FileInputStream("C:/temp/Smartphone/Images/save.ser");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("fichier pas trouvé");
        }
        if (fis != null) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            String test = ois.toString();
            String[] toTest = test.split(" ");
            for (int i = 0; i < toTest.length; i++) {
                ImageIcon image = new ImageIcon(toTest[i]);
                //Ecran_Galerie.center.add(new JLabel(image));
                newTableau = ajoutImage(newTableau, image);
            }

            ois.close();
            }

    return newTableau;
    }

    public ImageIcon[] ajoutImage(ImageIcon[] tableau, ImageIcon image) {


        ImageIcon[] tableau2 = new ImageIcon[tableau.length + 1];
        for (int i = 0; i < tableau.length; i++) {
            tableau2[i] = tableau[i];
        }
        tableau2[tableau2.length - 1] = image;

        return tableau2;

    }
}


