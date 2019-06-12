import javax.swing.*;
import java.awt.event.ActionListener;

class ButtonAjouterContact extends JPanel{
    private  JButton AnnulerContact = new JButton("Retour");
    private JButton addInfoButton = new JButton("Ajouter Contact");


    public ButtonAjouterContact() {
        add(addInfoButton);
        add(AnnulerContact);
    }

    public void addInfoBtnAddActionListener(ActionListener listener) {

        addInfoButton.addActionListener(listener);
    }

    public void AnnulerContact (ActionListener listen){

        AnnulerContact.addActionListener(listen);

    }

}
