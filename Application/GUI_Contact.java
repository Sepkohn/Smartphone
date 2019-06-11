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
        bottomPanel.add(buttonPanel);
        bottomPanel.add(Box.createHorizontalStrut(10));
        bottomPanel.add(informationPanel);

        setLayout(new BorderLayout());
        add(displayPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        buttonPanel.addInfoBtnAddActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String lastName = informationPanel.getLastName();
                String firstName = informationPanel.getFirstName();

                displayPanel.addRow(lastName, firstName);
            }
        });
    }
}
