import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

public class Ecran_Galerie extends JFrame implements Serializable{


    ImageIcon[] tableau = new ImageIcon[0];
    static String[] tabLien = new String[0];


    JButton plus = new JButton("+");
    JButton moins = new JButton("-");
    JButton cancel = new JButton("Cancel");

    GridBagLayout gbl = new GridBagLayout();


    JPanel south = new JPanel();
    JPanel north = new JPanel();
    JPanel center = new JPanel(gbl);



    public Ecran_Galerie() {

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight =1;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.WEST;




        setResizable(false);

        setSize(400, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        if(tabLien!=null){
        tableau = misAjour(tabLien);
        }

        center.removeAll();
        center.setSize(getMinimumSize());
        center.setMaximumSize(getMaximumSize());

        int x = 0;
        int y = 0;

        for(int i = 0; i<tableau.length;i++) {
            JLabel label = new JLabel(tableau[i]);
            ImageIcon back = tableau[i];

           JButton buton = new JButton();
           buton.setIcon(back);
           buton.setSize(90,90);


            gbc.gridx = x;
            gbc.gridy = y;
            gbc.weightx =0;
            gbc.weighty = 0;

            //center.add(label, gbc);
            center.add(buton, gbc);
            if(x == 2){
                y+=1;
                x=0;
            }
            else{
                x+=1;
            }
        }



        north.add(plus);
        north.add(moins);


        add(north, BorderLayout.NORTH);



        //centerGrid.addLayoutComponent(null, new JLabel(image));
        //center.add(new JLabel(image));

        add(new JScrollPane(center, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));




        add(cancel, BorderLayout.AFTER_LAST_LINE);

        plus.addMouseListener(new Ecouteur_Ecran_Galerie(this));
        cancel.addMouseListener(new Ecouteur_Ecran_Galerie(this));
        moins.addMouseListener(new Ecouteur_Ecran_Galerie(this));
    }

    public class Ecouteur_Ecran_Galerie extends MouseAdapter {

        public Ecouteur_Ecran_Galerie(Ecran_Galerie ecran) {

        }

        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub

            Object source = e.getSource();


            if (source == plus) {
                /*AjoutImage nouveau = new AjoutImage();
                nouveau.setVisible(true);
                //nouveau.setLocation(.getLocation());
                dispose();*/

                JFileChooser search = new JFileChooser();
                search.setSize(200,400);
                search.setMultiSelectionEnabled(true);
                search.setMaximumSize(new Dimension(400,800));
                search.setCurrentDirectory(new File("C:/temp/Smartphone/Images"));


                int retour = search.showDialog(getParent(), "validate");
                if(retour == JFileChooser.APPROVE_OPTION){
                    File[] serieImage = search.getSelectedFiles();
                    for(int i = 0;i<serieImage.length;i++){
                        tabLien = ajoutLien(tabLien, serieImage[i].getAbsolutePath());
                    }
                    Ecran_Galerie.tabLien = tabLien;

                    String[] serialisable = tabLien;

                    serialisation(serialisable);

                    Ecran_Galerie miseAjour = new Ecran_Galerie();

                    miseAjour.setVisible(true);
                }
            }

            if (source == moins) {
                SupprimeImage enleve = new SupprimeImage();
                enleve.setVisible(true);
                dispose();
            }
            if (source == cancel) {

                Ecran principal = new Ecran();

                principal.setVisible(true);

                dispose();
            }

            /*if(source==this.buton){

            }*/


        }


    }

    public ImageIcon[] misAjour (String[] tabLien){
        ImageIcon[] tableau = new ImageIcon[tabLien.length];
        for(int i =0;i<tabLien.length;i++){
            ImageIcon image = new ImageIcon(new ImageIcon(tabLien[i]).getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));

            tableau[i]=image;
        }

        return tableau;
    }

    public Dimension getMaximumSize() {
        return new Dimension(300, 999999999);
    }

    public Dimension getMinimumSize() {
        return new Dimension(300, 800);
    }

    public String [] ajoutLien (String[] tableau, String lien){

        String[] tableau2  = new String[tableau.length+1];

        for (int i = 0; i < tableau.length; i++) {
            tableau2[i] = tableau[i];
        }
        tableau2[tableau2.length - 1] = lien;

        return tableau2;
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

    /*public String[] deserialisation () throws IOException, ClassNotFoundException {

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("C:/temp/Smartphone/Images/save.ser");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("fichier pas trouvé");

            return new JButton[0] ;
        }

        DataInputStream ds = new DataInputStream(fis);


        String getLiens = new String();
        while(ds.available()>0){
            char c = ds.readChar();
            getLiens +=c ;
        }


        String[] toString = new String[0];

        if(getLiens!=null){
            toString = getLiens.split(" ");
        }

        JButton[] tobutton = new JButton[0];

        for(int i = 0; i<toString.length;i++){
            JButton toString[i].getText() = new JButton();
        }

        ds.close();
        fis.close();


        return toString;
    }*/

}
