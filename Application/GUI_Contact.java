import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


class GUI_Contact extends JPanel {
    Tab_Contact_Display displayPanel = new Tab_Contact_Display();
    ButtonsContact buttonPanel = new ButtonsContact();
    Contact_Data_Extract informationPanel = new Contact_Data_Extract();


    public GUI_Contact() {
        JPanel Panel_Haut = new JPanel();
        Panel_Haut.setLayout(new BoxLayout(Panel_Haut, BoxLayout.Y_AXIS));
        Panel_Haut.setSize(400, 200);
        Panel_Haut.add(Box.createVerticalStrut(10));
        Panel_Haut.add(buttonPanel);
        Panel_Haut.add(Box.createHorizontalStrut(10));
        Panel_Haut.add(informationPanel);


        setLayout(new BorderLayout());
        //laxout de la fenêtre (voir s'il faut changer encore)
        add(displayPanel, BorderLayout.PAGE_END);
        add(Panel_Haut, BorderLayout.SOUTH);


        //selectionner un champ dans le tableau
        displayPanel.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int i = displayPanel.table.getSelectedRow();

                informationPanel.imagechamp.setText(displayPanel.model.getValueAt(i, 0).toString());
                informationPanel.nomchamp.setText(displayPanel.model.getValueAt(i, 1).toString());
                informationPanel.prenomchamp.setText(displayPanel.model.getValueAt(i, 2).toString());
                informationPanel.numerochamp.setText(displayPanel.model.getValueAt(i, 3).toString());

            }
        });

        buttonPanel.addInfoBtnAddActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String Image = informationPanel.getImage();
                String Nom = informationPanel.getNom();
                String Prenom = informationPanel.getPrenom();
                String Numero = informationPanel.getNumero();

                displayPanel.addRow(Image, Nom, Prenom, Numero);
            }

        });


        buttonPanel.AnnulerContact(new

    ActionListener() {

        public void actionPerformed (ActionEvent d){

            Ecran retour_ecran = new Ecran();
            retour_ecran.setVisible(true);


        }
    });



        buttonPanel.DeleteContact(new ActionListener() {

            public void actionPerformed(ActionEvent a) {

                int i = displayPanel.table.getSelectedRow();
                if(i >= 0){

                    displayPanel.model.removeRow(i);
                }
                else{
                    System.out.println("Erreur pour supprimer");
                }
            }
        });





        buttonPanel.UpdateContact(new ActionListener() {

            public void actionPerformed(ActionEvent b) {

                int i = displayPanel.table.getSelectedRow();

                if(i >= 0)
                {
                    displayPanel.model.setValueAt(informationPanel.imagechamp.getText(), i, 0);
                    displayPanel.model.setValueAt(informationPanel.nomchamp.getText(), i, 1);
                    displayPanel.model.setValueAt(informationPanel.prenomchamp.getText(), i, 2);
                    displayPanel.model.setValueAt(informationPanel.numerochamp.getText(), i, 3);

                }
                else{
                    System.out.println("Update Error");
                }
            }
        });

    }



}
