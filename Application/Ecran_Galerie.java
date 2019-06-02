import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Ecran_Galerie extends JFrame {


    JButton plus = new JButton("+");
    JButton cancel = new JButton("Cancel");
    JScrollBar deroulant = new JScrollBar();
	
	/*ImageIcon pikachu;
	ImageIcon salameche;
	ImageIcon dracofeu;*/
    GridLayout centerGrid = new GridLayout(0, 2);


    //static ImageIcon[] tableau = new ImageIcon[1];
    JPanel south = new JPanel();


    public Ecran_Galerie() {

        JPanel center = new JPanel();
        setSize(400, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        for(int i = 0; i<AjoutImage.tableau.length;i++) {
            JLabel label = new JLabel(AjoutImage.tableau[i]);
            center.add(label);
        }


        add(plus, BorderLayout.NORTH);
       // setLayout(centerGrid);
        //centerGrid.addLayoutComponent(null, new JLabel(image));
        //center.add(new JLabel(image));
        add(center, BorderLayout.CENTER);


        add(deroulant, BorderLayout.EAST);
        add(cancel, BorderLayout.SOUTH);

        plus.addMouseListener(new Ecouteur_Ecran_Galerie(this));
        cancel.addMouseListener(new Ecouteur_Ecran_Galerie(this));
    }


    static ImageIcon[] getTableau(ImageIcon[] tableau) {

        return tableau;
    }

    public void serialisation(ImageIcon[] tableau) {

        try {
            FileOutputStream out = new FileOutputStream("C:/temp/Smartphone/Images/save.ser");
            ObjectOutputStream oos = new ObjectOutputStream(out);

            for (int i = 0; i < tableau.length; i++) {
                ImageIcon image = tableau[i];
                String test = image.toString();
                oos.writeObject( test + " ");
            }

            oos.close();
        } catch (IOException e) {
            System.out.println("erreur");
        }
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
            if (source == cancel) {
                if (AjoutImage.tableau != null) {
                    serialisation(AjoutImage.tableau);
                }

                Ecran principal = new Ecran();

                principal.setVisible(true);

                dispose();
            }


        }


    }

}
