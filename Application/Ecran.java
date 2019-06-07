//import javafx.util.converter.ByteStringConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;



public class Ecran extends JFrame {


    private JButton cancel = new JButton("O");
    JButton galerie = new JButton("Galerie");
    JButton contact = new JButton("Contacts");
    JButton undo = new JButton("Back");


    JPanel south = new JPanel();
    JPanel centre = new JPanel();
    JPanel north = new JPanel();


    public Ecran() {

        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(400, 800);
        //app au centre de l'écran :p
        setLocationRelativeTo(null);

        south.add(cancel);
        south.add(undo);

        centre.add(galerie);
        centre.add(contact);

        north.add(new BarreEtat());


        //voir si on peut mettre un fond d'ecran...
        centre.setOpaque(false);


        setTitle("Smartphone");

        getContentPane().setBackground(Color.BLACK);

        add(south, BorderLayout.SOUTH);
        add(centre, BorderLayout.CENTER);
        add(north, BorderLayout.NORTH);

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
                    AjoutImage.tabLien = deserialisation();
                } catch (IOException ex) {
                    ex.printStackTrace();
                    System.out.println("Import Export exception");
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                    System.out.println("Classe non trouvée");
                }
                AjoutImage.tableau = toImage(AjoutImage.tabLien);
                dispose();
            }

            public Image ajouter(Image image) {
                return image;
            }
        }

        public String[] deserialisation() throws IOException, ClassNotFoundException {

            FileInputStream fis = null;
            try {
                // fis = new FileInputStream("C:/temp/Smartphone/Out/production/Smartphone/Images/save.ser");
                fis = new FileInputStream("C:/temp/Smartphone/Images/save.ser");


            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("fichier pas trouvé");
            }
            ObjectInputStream ois = new ObjectInputStream(fis);

            DataInputStream ds = new DataInputStream(ois);

            String getliens = ds.readUTF();

            String[] toString = new String[0];

            if (getliens != null) {
                toString = getliens.split(" ");
            }

            ds.close();
            ois.close();


            return toString;
        }

        public ImageIcon[] ajoutImage(ImageIcon[] tableau, ImageIcon image) {


            ImageIcon[] tableau2 = new ImageIcon[tableau.length + 1];
            for (int i = 0; i < tableau.length; i++) {
                tableau2[i] = tableau[i];
            }
            tableau2[tableau2.length - 1] = image;

            return tableau2;

        }

        public ImageIcon[] toImage(String[] toString) {

            ImageIcon[] newTableau = new ImageIcon[0];

            for (int i = 0; i < toString.length; i++) {
                ImageIcon im = new ImageIcon(toString[i]);
                newTableau = ajoutImage(newTableau, im);
            }

            return newTableau;
        }

        public String[] ajoutLien(String[] tableau, String lien) {

            String[] tableau2 = new String[tableau.length + 1];

            for (int i = 0; i < tableau.length; i++) {
                tableau2[i] = tableau[i];
            }
            tableau2[tableau2.length - 1] = lien;

            return tableau2;
        }
    }




