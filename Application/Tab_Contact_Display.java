import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

class Tab_Contact_Display extends JPanel {
    private String[] COLUMNS = {"Image","Nom", "Prénom","Numero"};
    private DefaultTableModel model = new DefaultTableModel(COLUMNS, 0);
    private JTable table = new JTable(model);

    public Tab_Contact_Display() {
        setLayout(new BorderLayout());
        add(new JScrollPane(table));
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
    }

    public void addRow(String Image,String Nom, String Prenom, String Numero) {
        Object[] row = new Object[4];
        row[0] = Image;
        row[1] = Nom;
        row[2] = Prenom;
        row[3] = Numero;

        model.addRow(row);
    }
}
