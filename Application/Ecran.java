//import javafx.util.converter.ByteStringConverter;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.text.DateFormat;
import java.time.Clock;
import java.util.Date;


public class Ecran extends JFrame {

    private JButton cancel = new JButton("O");
    JButton galerie = new JButton("Galerie");
    JButton contact = new JButton("Contacts");


    JPanel south = new JPanel();
    JPanel centre = new JPanel();
    //panel barre etat
    JPanel north = new JPanel();


    public Ecran() {

        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(400, 800);
        //app au centre de l'écran :p
        setLocationRelativeTo(null);

        south.add(cancel);


        centre.add(galerie);
        centre.add(contact);


        //voir si on peut mettre un fond d'ecran...
        centre.setOpaque(false);


        setTitle("Smartphone");

        getContentPane().setBackground(Color.BLACK);

        add(south, BorderLayout.SOUTH);
        add(centre, BorderLayout.CENTER);
        add(north, BorderLayout.NORTH);


        galerie.addMouseListener(new Ecouteur_Galerie(this));
        contact.addMouseListener(new Ecouteur_Contact(this));
        cancel.addMouseListener(new Ecouteur_Galerie(this));

        //ajout de l'horloge dans l'écran principal (AMK)

        north.setSize(400, 200);
        north.setVisible(true);
        north.setForeground(Color.WHITE);

        }

      //  north.add(setContentPane(StatusBar.TimerThread));


    public class Ecouteur_Galerie extends MouseAdapter {
        public Ecouteur_Galerie(Ecran ecran) {
        }

        //quitter l'app pour de bon !
        public void fermer() {

            System.exit(0);
            
        }

        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == galerie) {
                try {
                    Ecran_Galerie.tabLien = deserialisation();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                Ecran_Galerie test = new Ecran_Galerie();
                test.setVisible(true);

                dispose();
            }
            if(e.getSource()==cancel){

                fermer();

            }


        }


    }



   public String[] deserialisation () throws IOException, FilenotFound {

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("C:/temp/Smartphone/Images/Serialisation/image.ser");
        } catch (FilenotFound e) {
            dispose();
            new FilenotFound();
            e.printStackTrace();

            return new String[0] ;
        }

        DataInputStream ds = new DataInputStream(fis);


        String getLiens = new String();

        while(ds.available()>0){
            char c = ds.readChar();
            getLiens +=c ;
        }


        String[] toString =new String[0];

        if(getLiens!=null){

                toString = getLiens.split(" ");

         }

        ds.close();
        fis.close();


    return toString;
    }


}
