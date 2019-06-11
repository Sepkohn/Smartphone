import javax.swing.*;

class Contact_Data_Extract extends JPanel {
    private JTextField lastNameField = new JTextField(10);
    private JTextField firstNameField = new JTextField(10);

    public Contact_Data_Extract() {
        add(new JLabel("Last Name:"));
        add(lastNameField);
        add(Box.createHorizontalStrut(5));
        add(new JLabel("First Name:"));
        add(firstNameField);
    }

    public String getLastName() {
        return lastNameField.getText();
    }

    public String getFirstName() {
        return firstNameField.getText();
    }
}
