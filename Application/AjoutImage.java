import java.awt.*;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.*;

import javax.swing.*;

public class AjoutImage extends JFrame {

    static ImageIcon[] tableau = new ImageIcon[1];

    JTextArea aide = new JTextArea("Insert image link");

    JTextField lien = new JTextField();

    JButton ok = new JButton("OK");

    JButton cancel = new JButton("Cancel");

    JPanel south = new JPanel();

    public AjoutImage() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(400, 800);


        south.add(ok);
        south.add(cancel);

        add(aide, BorderLayout.NORTH);
        add(lien, BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);

        ok.addMouseListener(new EcouteurAdd());
        cancel.addMouseListener(new EcouteurAdd());

    }

    class EcouteurAdd extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
            Object source = e.getSource();

            if (source == ok) {

                ImageIcon image = new ImageIcon(new ImageIcon(lien.getText()).getImage().getScaledInstance(175, 200, Image.SCALE_DEFAULT));

                tableau = ajoutImage(tableau, image);

                //AjoutImage.tableau[AjoutImage.tableau.length-1]=image;

                //Ecran_Galerie.tableau=tableau;

                Ecran_Galerie miseAjour = new Ecran_Galerie(image);

                miseAjour.setVisible(true);


                dispose();

            }
            if (source == cancel) {

                Ecran_Galerie miseAjour = new Ecran_Galerie(null);

                miseAjour.setVisible(true);

                dispose();
            }
        }

    }


    public static ImageIcon[] getTableau(ImageIcon[] tableau2) {
        // TODO Auto-generated method stub
        return tableau2;
    }

    public ImageIcon[] ajoutImage(ImageIcon[] tableau, ImageIcon image) {


        ImageIcon[] tableau2 = new ImageIcon[tableau.length + 1];
        for (int i = 0; i < tableau.length; i++) {
            tableau2[i] = tableau[i];
        }
        tableau2[tableau2.length - 1] = image;

        return tableau2;

    }


}
