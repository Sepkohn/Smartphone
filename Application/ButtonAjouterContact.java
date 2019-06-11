import javax.swing.*;
import java.awt.event.ActionListener;

class ButtonAjouterContact extends JPanel {
    private JButton addInfoButton = new JButton("Add Information");

    public ButtonAjouterContact() {
        add(addInfoButton);
    }

    public void addInfoBtnAddActionListener(ActionListener listener) {
        addInfoButton.addActionListener(listener);
    }
}
