import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GUI_Contact extends JPanel {
    Tab_Contact_Display displayPanel = new Tab_Contact_Display();
    ButtonAjouterContact buttonPanel = new ButtonAjouterContact();
    Contact_Data_Extract informationPanel = new Contact_Data_Extract();


    public GUI_Contact() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.setSize(400,200);
        bottomPanel.add(Box.createVerticalStrut(10));
        bottomPanel.add(buttonPanel);
        bottomPanel.add(Box.createHorizontalStrut(10));
        bottomPanel.add(informationPanel);


        setLayout(new BorderLayout());
        //laxout de la fenêtre (voir s'il faut changer encore)
        add(displayPanel, BorderLayout.PAGE_END);
        add(bottomPanel, BorderLayout.SOUTH);


        buttonPanel.addInfoBtnAddActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String Image = informationPanel.getImage();
                String Nom = informationPanel.getNom();
                String Prenom = informationPanel.getPrenom();
                String Numero = informationPanel.getNumero();

                displayPanel.addRow(Image,Nom, Prenom, Numero);
            }

        });
    }
}
