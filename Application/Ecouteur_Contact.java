import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Ecouteur_Contact extends MouseAdapter {

    public JButton change = new JButton("Changer la taille");
    public JButton retablir = new JButton("Rétablir");


    public Ecouteur_Contact(Ecran ecran) {

    }


    @Override
    public void mouseClicked(MouseEvent event) {


        Ecran_Contact Ecran = new Ecran_Contact();
        Ecran.setVisible(true);
        Ecran.setSize(400, 800);
        Ecran.setLocationRelativeTo(Ecran);
        Ecran.setTitle("Contacts");
        Ecran.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }


}


