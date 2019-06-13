import javax.swing.*;
import java.awt.event.ActionListener;

class ButtonsContact extends JPanel{
    private  JButton AnnulerContact = new JButton("Retour");
    private JButton addInfoButton = new JButton("Ajouter Contact");
    private JButton SupprimerContact = new JButton("Supprimer Contact");
    private JButton UpdateContact = new JButton("MàJ Contact");




    public ButtonsContact() {
        add(addInfoButton);
        add(AnnulerContact);
        add(SupprimerContact);
        add(UpdateContact);

    }

    public void addInfoBtnAddActionListener(ActionListener listener) {

        addInfoButton.addActionListener(listener);
    }

    public void AnnulerContact (ActionListener listen){

        AnnulerContact.addActionListener(listen);

    }

    public void DeleteContact (ActionListener tolisten) {

        SupprimerContact.addActionListener(tolisten);
    }

    public void UpdateContact (ActionListener heylisten){

        UpdateContact.addActionListener(heylisten);

    }


}
