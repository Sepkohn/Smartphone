import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


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


    }


}


