import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

class Tab_Contact_Display extends JPanel {
    private String[] COLUMNS = {"Image","Last Name", "First Name","Numero"};
    private DefaultTableModel model = new DefaultTableModel(COLUMNS, 0);
    private JTable table = new JTable(model);

    public Tab_Contact_Display() {
        setLayout(new BorderLayout());
        add(new JScrollPane(table));
    }

    public void addRow(Object image, String lastName) {
        Object[] row = new Object[4];
        row[0] = image;
       // row[1] = firstName;
        row[3] = lastName;
       // row[4] = number;

        model.addRow(row);
    }
}
