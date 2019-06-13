import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

public class SupprimeImage extends JFrame implements Serializable{

   String[] tabLien = getTableau(Ecran_Galerie.tabLien);

    JTextArea aide = new JTextArea("Insert image link");

    JTextField lien = new JTextField();

    JButton ok = new JButton("OK");

    JButton cancel = new JButton("Cancel");

    JPanel south = new JPanel();

    public SupprimeImage(){


    setSize(400, 800);
    setLocationRelativeTo(null);

        south.add(ok);
        south.add(cancel);

    add(aide, BorderLayout.NORTH);
    add(lien, BorderLayout.CENTER);
    add(south, BorderLayout.SOUTH);

        ok.addMouseListener(new EcouteurSuppr());
        cancel.addMouseListener(new EcouteurSuppr());

    }

    class EcouteurSuppr extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
            Object source = e.getSource();

            if (source == ok) {

                String link = lien.getText();


                Ecran_Galerie.tabLien = supprimeLiens(tabLien, link);



                String[] serialisable = Ecran_Galerie.tabLien;

                serialisation(serialisable);

                Ecran_Galerie miseAjour = new Ecran_Galerie();

                miseAjour.setVisible(true);

                dispose();

            }
            if (source == cancel) {

                String[] serialisable = tabLien;

                serialisation(serialisable);

                Ecran_Galerie miseAjour = new Ecran_Galerie();

                miseAjour.setVisible(true);

                dispose();
            }
        }

    }

    public void serialisation(String[] tableau) {

            File fichier;
            fichier = new File("C:/temp/Smartphone/Images/save.ser");
            fichier.delete();

        try {
            FileOutputStream fos = new FileOutputStream(fichier);

            DataOutputStream ds = new DataOutputStream(fos);


            for (int i = 0; i < tableau.length; i++) {
                String image = tableau[i];
                ds.writeChars(image +" ");
            }

            ds.close();
            fos.close();

        } catch (IOException e) {
            System.out.println("erreur");
        }
    }


    public String[] supprimeLiens(String[] liens, String link){

        String[] newTab = new String[0];
        int count = 0;

        if(liens!=null) {

            for (int i = 0; i < liens.length && count != 1; i++) {

                if (liens[i].equals(link)) {

                    for (int j = i; j < liens.length-1; j++) {
                        liens[j] = liens[j + 1];

                    }

                    newTab = new String[liens.length - 1];
                    for (int k = 0; k < newTab.length; k++) {
                        newTab[k] = liens[k];

                    }
                    count++;

                } else if (i == liens.length - 1) {
                    JFrame erreur = new JFrame();
                    erreur.setVisible(true);
                    setLocationRelativeTo(null);
                    erreur.setSize(400, 100);


                    JTextArea message = new JTextArea("Erreur : image non trouvée");
                    erreur.add(message);

                    newTab = liens;
                }
            }
        }
        else {
            JFrame erreur = new JFrame();
            erreur.setVisible(true);
            setLocationRelativeTo(this);
            erreur.setSize(400, 100);

            JTextArea message = new JTextArea("Erreur : le tableau est vide!!");
            erreur.add(message);

            newTab = liens;

        }

        return newTab;
    }

    public String[] getTableau (String[] tableauS){
        return tableauS;
    }

}
