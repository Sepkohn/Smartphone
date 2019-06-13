import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.io.File;

class Contact_Data_Extract extends JPanel {
    // ce field pour image ne marche pas... (comme ça pas error lors du addRow)
    protected JTextField imagechamp = new JTextField(10);
    protected JTextField nomchamp = new JTextField(10);
    protected JTextField prenomchamp = new JTextField(10);
    protected JTextField numerochamp = new JTextField(15);
    //button image absatraction pour le mettre dans une fonction

    JButton insterimage = new JButton("Image de contact");



    public Contact_Data_Extract() {
        add(insterimage);
        // action pour mettre une image dans la cellule [0] du tableau
        insterimage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sélectionner une image");
                JFileChooser search = new JFileChooser();
                search.setFileSelectionMode(JFileChooser.FILES_ONLY);
                search.setMultiSelectionEnabled(true);
                search.setCurrentDirectory(new File("C:/temp/Smartphone/Images"));
                int retour = search.showDialog(null, "validate");
                search.setVisible(true);
                search.setSize(400,400);
                search.setMaximumSize(new Dimension(400, 800));



            }
        });

        add(Box.createHorizontalStrut(5));
        add(new JLabel("Numéro :"));
        add(numerochamp);
        add(Box.createHorizontalStrut(5));
        add(new JLabel("Nom :"));
        add(nomchamp);
        add(Box.createHorizontalStrut(5));
        add(new JLabel("Prénom :"));
        add(prenomchamp);
        add(Box.createHorizontalStrut(5));




    }
    //cette fonction en renvoie rien... (imagechamp)
    public String getImage() { return imagechamp.getText();}

    public String getNom() {
        return nomchamp.getText();
    }

    public String getPrenom() {
        return prenomchamp.getText();
    }

    public String getNumero() {
        return numerochamp.getText();
    }

    }



