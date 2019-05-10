import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Ecouteur_Contact extends MouseAdapter {

    private JTable tableau;
    private JButton change = new JButton("Changer la taille");
    private JButton retablir = new JButton("Rétablir");

    // essayer de mettre un tableau de valeurs pour avoir un menu déroulant avec 3 colonnes
    //on doit avoir le nom, prenom et numero de contact


    public Ecouteur_Contact() {


    }



    @Override
    public void mouseClicked(MouseEvent event){

        JFrame Window = new JFrame();
        Window.setVisible(true);
        Window.setSize(500,900);

    }




    //public class Ecouteur_1 implements ActionListener {

      //  if()



}
