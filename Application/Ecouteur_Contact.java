import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;




public class Ecouteur_Contact extends MouseAdapter implements Serializable{

    Tab_Contact_Display.AccessibleJComponent model;

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


        //recover updated data to a JTable(deserialization)

        try {

            FileInputStream filein = new FileInputStream("C:/temp/Smartphone/contacts.txt");

            ObjectInputStream input = new ObjectInputStream(filein);

            System.out.println("je n'arrive pas à lire");

            input.close();


        }catch (Exception e) {

            e.printStackTrace();

        }
    }
}



