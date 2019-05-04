import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class Ecouteur_Contact extends JFrame {

    private JButton ButtonAdd = new JButton("Ajouter");
    private JButton ButtonClose = new JButton("Fermer");
    private JPanel panel_south = new JPanel();


    public Button() {

        //Ecouteur ecouteur = new Ecouteur() ;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // ButtonAdd.addActionListener();
        // ButtonAdd.setActionCommand("toto");

        panel_south.add(ButtonAdd);
        panel_south.add(ButtonClose);

        add(panel_south, BorderLayout.SOUTH);


        ButtonAdd.addActionListener(new Ecouteur_1());

        pack();


    }

    public class Ecouteur_1 implements ActionListener {

        if()


    }





}
