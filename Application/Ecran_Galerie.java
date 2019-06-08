import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

public class Ecran_Galerie extends JFrame {

    ImageIcon[] tableau = new ImageIcon[0];
    static String[] tabLien = new String[0];


    JButton plus = new JButton("+");
    JButton moins = new JButton("-");
    JButton cancel = new JButton("Cancel");


    //GridLayout centerGrid = new GridLayout(0, 3, 1, 1);


    JPanel south = new JPanel();
    JPanel north = new JPanel();
    JPanel center = new JPanel();


    public Ecran_Galerie() {

        setResizable(false);

        setSize(400, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        if(tabLien!=null){
        tableau = misAjour(tabLien);
        }


        center.removeAll();
        center.setSize(getMinimumSize());
        center.setMaximumSize(getMaximumSize());

        for(int i = 0; i<tableau.length;i++) {
            JLabel label = new JLabel(tableau[i]);
            center.add(label);
        }


        north.add(plus);
        north.add(moins);


        add(north, BorderLayout.NORTH);



        //centerGrid.addLayoutComponent(null, new JLabel(image));
        //center.add(new JLabel(image));

        add(new JScrollPane(center), BorderLayout.CENTER);




        add(cancel, BorderLayout.AFTER_LAST_LINE);

        plus.addMouseListener(new Ecouteur_Ecran_Galerie(this));
        cancel.addMouseListener(new Ecouteur_Ecran_Galerie(this));
        moins.addMouseListener(new Ecouteur_Ecran_Galerie(this));
    }

    public class Ecouteur_Ecran_Galerie extends MouseAdapter {

        public Ecouteur_Ecran_Galerie(Ecran_Galerie ecran) {

        }

        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub

            Object source = e.getSource();


            if (source == plus) {
                AjoutImage nouveau = new AjoutImage();
                nouveau.setVisible(true);
                //nouveau.setLocation(.getLocation());
                dispose();
            }

            if (source == moins) {
                SupprimeImage enleve = new SupprimeImage();
                enleve.setVisible(true);
                //nouveau.setLocation(.getLocation());
                dispose();
            }
            if (source == cancel) {

                Ecran principal = new Ecran();

                principal.setVisible(true);

                dispose();
            }


        }


    }

    public ImageIcon[] misAjour (String[] tabLien){
        ImageIcon[] tableau = new ImageIcon[tabLien.length];
        for(int i =0;i<tabLien.length;i++){
            ImageIcon image = new ImageIcon(new ImageIcon(tabLien[i]).getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
            tableau[i]=image;
        }

        return tableau;
    }

    public Dimension getMaximumSize() {
        return new Dimension(300, 999999999);
    }

    public Dimension getMinimumSize() {
        return new Dimension(300, 800);
    }

}
