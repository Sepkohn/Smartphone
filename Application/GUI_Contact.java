import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;

class GUI_Contact extends JPanel {
    Tab_Contact_Display displayPanel = new Tab_Contact_Display();
    ButtonAjouterContact buttonPanel = new ButtonAjouterContact();
    Contact_Data_Extract informationPanel = new Contact_Data_Extract();


    public GUI_Contact() {
        JPanel Panel_Haut = new JPanel();
        Panel_Haut.setLayout(new BoxLayout(Panel_Haut, BoxLayout.Y_AXIS));
        Panel_Haut.setSize(400,200);
        Panel_Haut.add(Box.createVerticalStrut(10));
        Panel_Haut.add(buttonPanel);
        Panel_Haut.add(Box.createHorizontalStrut(10));
        Panel_Haut.add(informationPanel);


        setLayout(new BorderLayout());
        //laxout de la fenêtre (voir s'il faut changer encore)
        add(displayPanel, BorderLayout.PAGE_END);
        add(Panel_Haut, BorderLayout.SOUTH);


        buttonPanel.addInfoBtnAddActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String Image = informationPanel.getImage();
                String Nom = informationPanel.getNom();
                String Prenom = informationPanel.getPrenom();
                String Numero = informationPanel.getNumero();

                displayPanel.addRow(Image,Nom, Prenom, Numero);
            }

        });


        buttonPanel.AnnulerContact(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                

            }
        });
    }

}
