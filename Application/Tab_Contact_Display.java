import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;

class Tab_Contact_Display extends JPanel implements Serializable {
    private String[] COLUMNS = {"Image","Nom", "Prénom","Numero"}; {

        final long serialVersionUID = 1L;

    }

    protected DefaultTableModel model = new DefaultTableModel(COLUMNS, 0){

    //le tableau n'est pas editable
    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }

    };

    protected JTable table = new JTable(model);


    public Tab_Contact_Display() {
        setLayout(new BorderLayout());
        add(new JScrollPane(table));
        //couleurs table...
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);

    }


    protected void addRow(String Image,String Nom, String Prenom, String Numero) {
        Object[] row = new Object[4];
        row[0] = Image;
        row[1] = Nom;
        row[2] = Prenom;
        row[3] = Numero;

        model.addRow(row);
        //serialization de la table contact
        try {
            ObjectOutputStream Ecrire_fichier = new ObjectOutputStream(new FileOutputStream("C:/temp/Smartphone/contacts.txt"));

            Ecrire_fichier.writeObject(row);

            Ecrire_fichier.close();


        }catch (Exception e){


        }

    }


}
