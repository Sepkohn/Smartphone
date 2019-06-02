import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AjoutImage extends JFrame {

    static ImageIcon[] tableau = new ImageIcon[0];

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

    class EcouteurAdd extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
            Object source = e.getSource();

            if (source == ok) {

                ImageIcon image = new ImageIcon(new ImageIcon(lien.getText()).getImage().getScaledInstance(175, 200, Image.SCALE_DEFAULT));

                tableau = ajoutImage(tableau, image);

                Ecran_Galerie miseAjour = new Ecran_Galerie();

                miseAjour.setVisible(true);

                dispose();

            }
            if (source == cancel) {

                Ecran_Galerie miseAjour = new Ecran_Galerie();

                miseAjour.setVisible(true);

                dispose();
            }
        }

    }


}
