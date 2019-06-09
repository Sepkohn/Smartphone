import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

public class AjoutImage extends JFrame implements Serializable {

    String[] tabLien = Ecran_Galerie.tabLien;

    JTextArea aide = new JTextArea("Insert image link");

    JTextField lien = new JTextField();

    JButton ok = new JButton("OK");

    JButton cancel = new JButton("Cancel");

    JPanel south = new JPanel();

    public AjoutImage() {



        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(400, 800);
        setLocationRelativeTo(null);

        south.add(ok);
        south.add(cancel);

        add(aide, BorderLayout.NORTH);
        add(lien, BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);

        ok.addMouseListener(new EcouteurAdd());
        cancel.addMouseListener(new EcouteurAdd());

    }

    public String [] ajoutLien (String[] tableau, String lien){

        String[] tableau2  = new String[tableau.length+1];

        for (int i = 0; i < tableau.length; i++) {
            tableau2[i] = tableau[i];
        }
        tableau2[tableau2.length - 1] = lien;

        return tableau2;
    }

    class EcouteurAdd extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
            Object source = e.getSource();

            if (source == ok) {


                String link = lien.getText();

                boolean format = testImage(link);

                if(format == true){
                    ImageIcon image = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(175, 200, Image.SCALE_DEFAULT));
                    if(image!= null) {
                        tabLien = ajoutLien(tabLien, link);
                        Ecran_Galerie.tabLien = tabLien;

                        String[] serialisable = tabLien;

                        serialisation(serialisable);

                        Ecran_Galerie miseAjour = new Ecran_Galerie();

                        miseAjour.setVisible(true);

                        dispose();
                    }
                    else{
                        JFrame erreur = new JFrame();
                        erreur.setVisible(true);
                        setLocationRelativeTo(null);
                        erreur.setSize(400, 100);


                        JTextArea message = new JTextArea("L'image n'a pas pu être crée");
                        erreur.add(message);
                    }
                }

                else{
                    JFrame erreur = new JFrame();
                    erreur.setVisible(true);
                    setLocationRelativeTo(null);
                    erreur.setSize(400, 100);


                    JTextArea message = new JTextArea("Erreur image invalide. Erreur chemin d'accès ou format invalide. " +
                            "Formats disponibles : .jpg, .gif ou .png");
                    erreur.add(message);
                }
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

    public boolean testImage(String lien){
        if(lien.contains(".jpg")){
            return true;
        }
        else{
            if(lien.contains(".gif")){
                return true;
            }
            else{
                if(lien.contains(".png")){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
    }
}
