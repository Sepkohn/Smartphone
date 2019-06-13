import javax.swing.*;
import java.io.FileNotFoundException;

    public class FilenotFound extends FileNotFoundException {

    public FilenotFound(){


        JOptionPane.showMessageDialog(null, "Erreur : fichier non trouvée");
        Ecran erreur = new Ecran();

        erreur.setVisible(true);

    }

}
