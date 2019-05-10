import javax.swing.*;
import java.awt.*;


public class Ecouteur_Contact extends JFrame {

    private JButton ButtonAdd = new JButton("Ajouter");
    private JButton ButtonClose = new JButton("Fermer");
    private JPanel panel_south = new JPanel();
    private JPanel panel_north = new JPanel();
    private JPanel panel_center = new JPanel() ;
    private JTextField panel_titre = new JTextField();


    public Ecouteur_Contact() {

        //Ecouteur ecouteur = new Ecouteur() ;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // ButtonAdd.addActionListener();
        // ButtonAdd.setActionCommand("toto");

        panel_south.add(ButtonAdd);
        panel_south.add(ButtonClose);

        add(panel_south, BorderLayout.SOUTH);
        add(panel_north, BorderLayout.NORTH);
        add(panel_titre, BorderLayout.NORTH);
        add(panel_center, BorderLayout.CENTER) ;


        ButtonAdd.addActionListener(new Ecouteur_1());

        pack();
    }

    //public class Ecouteur_1 implements ActionListener {

      //  if()


return Ecouteur_Contact ;
}
