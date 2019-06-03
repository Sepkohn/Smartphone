import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SupprimeImage extends JFrame {


    JTextArea aide = new JTextArea("Insert image link");

    JTextField lien = new JTextField();

    JButton ok = new JButton("OK");

    JButton cancel = new JButton("Cancel");

    JPanel south = new JPanel();

    public SupprimeImage(){


    setSize(400, 800);


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

                AjoutImage.tabLien = supprimeLiens(AjoutImage.tabLien, link);

                AjoutImage.tableau = supprimeImage(AjoutImage.tableau, AjoutImage.tabLien);

                String[] serialisable = AjoutImage.tabLien;

                serialisation(serialisable);

                Ecran_Galerie miseAjour = new Ecran_Galerie();

                miseAjour.setVisible(true);

                dispose();

            }
            if (source == cancel) {

                String[] serialisable = AjoutImage.tabLien;

                serialisation(serialisable);

                Ecran_Galerie miseAjour = new Ecran_Galerie();

                miseAjour.setVisible(true);

                dispose();
            }
        }

    }

    public void serialisation(String[] tableau) {

        try {
            FileOutputStream out = new FileOutputStream("C:/temp/Smartphone/Images/save.ser");

            DataOutputStream ds = new DataOutputStream(out);


            for (int i = 0; i < tableau.length; i++) {
                String image = tableau[i];
                ds.writeChars(image +" ");
            }

            ds.close();
            out.close();

        } catch (IOException e) {
            System.out.println("erreur");
        }
    }

    public ImageIcon[] supprimeImage(ImageIcon[] tableau, String[] liens){

        ImageIcon[] newTableau = new ImageIcon[tableau.length -1];

        for(int i = 0; i<liens.length;i++){
            newTableau[i]= new ImageIcon(liens[i]);
        }

        return newTableau;
    }

    public String[] supprimeLiens(String[] liens, String link){

        int count =0;
        String[] newTab = new String[0];

        for(int i = 0;i<liens.length;i++){
            if(liens[i]==link){
                for(int j = i; j< liens.length;i++){
                    liens[i]=liens[i+1];
                    count++;
                    break;
                }
                newTab = new String[liens.length-1];
                for(int k = 0;k<liens.length;k++){
                    newTab[k]=liens[k];
                }
            }
            else if(i==liens.length-1 && count==0){
                JFrame erreur = new JFrame();
                erreur.setVisible(true);
                erreur.setSize(400,300);

                JTextArea message = new JTextArea("Erreur : image non trouvée");
                erreur.add(message);
                newTab=liens;
            }
        }






        return newTab;
    }

}
