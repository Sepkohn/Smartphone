import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Ecouteur_Contact extends MouseAdapter {

    private JButton ButtonAdd = new JButton("Ajouter");
    private JButton ButtonClose = new JButton("Fermer");
    private JPanel panel_south = new JPanel();
    private JPanel panel_north = new JPanel();
    private JPanel panel_center = new JPanel() ;



    public  Ecouteur_Contact() {




    }

    @Override
    public void mouseClicked(MouseEvent event){


        JFrame Window = new JFrame();
        Window.setVisible(true);
        Window.setSize(500,900);
        panel_south.getAccessibleContext();
        panel_south.add(ButtonAdd);
        panel_south.add(ButtonClose) ;

    }


    //public class Ecouteur_1 implements ActionListener {

      //  if()



}
