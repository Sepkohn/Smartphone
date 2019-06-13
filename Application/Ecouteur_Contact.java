import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Ecouteur_Contact extends MouseAdapter {
    public Ecouteur_Contact(Ecran ecran) {

    }

    public void mouseClicked(MouseEvent event) {

        Ecran_Contact Ecran = new Ecran_Contact();
        Ecran.setVisible(true);
        Ecran.setTitle("Contacts");
        Ecran.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Ecran.pack();
        Ecran.getContentPane().add(new GUI_Contact(), BorderLayout.CENTER);
        Ecran.setSize(400, 800);
        Ecran.setLocationRelativeTo(null);

        //recover updated data (avec le tableau dispo)

        try {
            ObjectInputStream Recover_File = new ObjectInputStream(new FileInputStream("C:/temp/Smartphone/contacts.txt"));

            Tab_Contact_Display[] data_recover = (Tab_Contact_Display []) Recover_File.readObject();


        }catch (Exception e) {

        }
        }



    }



