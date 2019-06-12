import javax.swing.*;
import java.awt.event.InputMethodEvent;

class Contact_Data_Extract extends JPanel {
    // ce field pour image ne marche pas... (comme ça pas error lors du addRow)
    private JTextField imagechamp = new JTextField(10);
    private JTextField nomchamp = new JTextField(10);
    private JTextField prenomchamp = new JTextField(10);
    private JTextField numerochamp = new JTextField(15);


    public Contact_Data_Extract() {
        add(new JButton("Image de contact"));
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
    //cette fonction en marche pas...
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



