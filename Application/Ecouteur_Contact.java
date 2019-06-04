import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Ecouteur_Contact extends MouseAdapter {
    public Ecouteur_Contact(Ecran ecran) {

    }
    public void mouseClicked(MouseEvent event) {

        Ecran_Contact Ecran = new Ecran_Contact();
        Ecran.setVisible(true);
        Ecran.setSize(400, 800);
        Ecran.setLocationRelativeTo(Ecran);
        Ecran.setTitle("Contacts");
        Ecran.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }


}


