import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.io.*;
import java.text.AttributedCharacterIterator;

public class Ecran_Galerie extends JFrame implements Serializable {


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
        gbc.gridheight = 1;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.WEST;


        setResizable(false);

        setSize(400, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        if (tabLien != null) {
            tableau = misAjour(tabLien);
        }
        tabLien = supprimeLien(tabLien, "");


        center.removeAll();
        center.setSize(getMinimumSize());
        center.setMaximumSize(getMaximumSize());

        int x = 0;
        int y = 0;

        for (int i = 0; i < tableau.length; i++) {
            JLabel label = new JLabel(tableau[i]);

            gbc.gridx = x;
            gbc.gridy = y;
            gbc.weightx = 0;
            gbc.weighty = 0;

            center.add(label, gbc);


            if (x == 2) {
                y += 1;
                x = 0;
            } else {
                x += 1;
            }
        }


        north.add(plus);
        north.add(moins);


        add(north, BorderLayout.NORTH);


        add(new JScrollPane(center, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));


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

                JFileChooser search = new JFileChooser();
                search.setSize(200, 400);
                search.setFileSelectionMode(JFileChooser.FILES_ONLY);
                search.setMultiSelectionEnabled(true);
                search.setMaximumSize(new Dimension(400, 800));

                search.setCurrentDirectory(new File("C:/temp/Smartphone/Images"));


                int retour = search.showDialog(null, "validate");

                if (retour == JFileChooser.APPROVE_OPTION) {
                    File[] serieImage = search.getSelectedFiles();
                    for (int i = 0; i < serieImage.length; i++) {
                        tabLien = ajoutLien(tabLien, serieImage[i].getAbsolutePath());
                    }
                    Ecran_Galerie.tabLien = tabLien;

                    String[] serialisable = tabLien;

                    serialisation(serialisable);

                    Ecran_Galerie miseAjour = new Ecran_Galerie();

                    miseAjour.setVisible(true);

                    dispose();
                } else if (source == moins) {


                    JFileChooser erase = new JFileChooser();
                    erase.setSize(200, 400);
                    erase.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    erase.setMultiSelectionEnabled(false);
                    erase.setMaximumSize(new Dimension(400, 800));

                    erase.setCurrentDirectory(new File("C:/temp/Smartphone/Images"));


                    int getBack = search.showDialog(null, "validate");

                    if (getBack == JFileChooser.APPROVE_OPTION) {

                        tabLien = supprimeLiens(tabLien, search.getSelectedFile().getAbsolutePath());

                        String[] serialisable = tabLien;

                        serialisation(serialisable);

                        Ecran_Galerie miseAjour = new Ecran_Galerie();

                        miseAjour.setVisible(true);

                        dispose();
                    } else if (source == cancel) {

                        Ecran principal = new Ecran();

                        principal.setVisible(true);

                        dispose();
                    }
                }
            }
        }
    }


    public ImageIcon[] misAjour(String[] tabLien) {
        ImageIcon[] tableau = new ImageIcon[tabLien.length];
        for (int i = 0; i < tabLien.length; i++) {
            ImageIcon image = new ImageIcon(new ImageIcon(tabLien[i]).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));

            tableau[i] = image;
        }

        return tableau;
    }

    public Dimension getMaximumSize() {
        return new Dimension(300, 999999999);
    }

    public Dimension getMinimumSize() {
        return new Dimension(300, 800);
    }

    public String[] ajoutLien(String[] tableau, String lien) {

        String[] tableau2 = new String[tableau.length + 1];

        for (int i = 0; i < tableau.length; i++) {
            tableau2[i] = tableau[i];
        }
        tableau2[tableau2.length - 1] = lien;

        return tableau2;
    }


    public void serialisation(String[] tableau) {

        File fichier;
        fichier = new File("C:/temp/Smartphone/Images/Serialisation/image.ser");
        fichier.delete();

        try {
            FileOutputStream fos = new FileOutputStream(fichier);

            DataOutputStream ds = new DataOutputStream(fos);


            for (int i = 0; i < tableau.length; i++) {
                String image = tableau[i];
                ds.writeChars(image + " ");
            }

            ds.close();
            fos.close();

        } catch (IOException e) {
            System.out.println("erreur");
        }
    }

    public String[] supprimeLiens(String[] liens, String link) {

        String[] newTab = new String[0];

        int count = 0;

        if (liens != null) {

            for (int i = 0; i < liens.length && count != 1; i++) {

                if (liens[i].equals(link)) {

                    for (int j = i; j < liens.length - 1; j++) {
                        liens[j] = liens[j + 1];

                    }

                    newTab = new String[liens.length - 1];
                    for (int k = 0; k < newTab.length; k++) {
                        newTab[k] = liens[k];

                    }
                    count++;

                } else if (i == liens.length - 1) {

                    JOptionPane.showMessageDialog(null, "Erreur : image non trouvée");
                    setVisible(true);

                    newTab = liens;
                }
            }
        } else {

            JOptionPane.showMessageDialog(null, "Erreur : le tableau est vide!!");

            newTab = liens;

        }

        return newTab;
    }

    public String[] supprimeLien(String[] liens, String link) {

        String[] newTab ;

        int count = 0;

        if (liens != null) {

            for (int i = 0; i < liens.length && count != 1; i++) {

                if (liens[i].equals(link)) {

                    for (int j = i; j < liens.length - 1; j++) {
                        liens[j] = liens[j + 1];

                    }

                    newTab = new String[liens.length - 1];
                    for (int k = 0; k < newTab.length; k++) {
                        newTab[k] = liens[k];

                    }
                    count++;

                    return newTab;



                }
            }
        }

            return liens;



    }


}