import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;

class Tab_Contact_Display extends JPanel implements Serializable {
    private String[] COLUMNS = {"Image","Nom", "Prénom","Numero"}; {

        final long serialVersionUID = 1L;

    }

    private DefaultTableModel model = new DefaultTableModel(COLUMNS, 0){

    //le tableau n'est pas editable
    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }

};
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

        try {
            ObjectOutputStream Ecrire_fichier = new ObjectOutputStream(new FileOutputStream("C:/temp/Smartphone/contacts.ser"));

            Ecrire_fichier.writeObject(row);

            Ecrire_fichier.close();

            //recover updated data (avec le tableau dispo)
            ObjectInputStream Recover_File = new ObjectInputStream(new FileInputStream("C:/temp/Smartphone/contacts.ser"));

            Tab_Contact_Display[] data_recover=(Tab_Contact_Display[]) Recover_File.readObject();


            Recover_File.close();



        }catch (Exception e){


        }

    }


}
