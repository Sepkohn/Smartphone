import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Ecran_Contact extends JFrame {


    JButton Button_Add = new JButton("Ajouter un contact...");
    JButton Button_Remove = new JButton("Supprimer un contact...");
    JLabel text = new JLabel("Liste de Contacts");
    JPanel Panel_START = new JPanel();
    JPanel Panel_END = new JPanel();
    JPanel Panel_Center = new JPanel();
    JButton Button_Back = new JButton("Retour");



    //Tab pour mettre des contacts...
    Object[][] data = {

            {1, "Dupont", "François", "0789095522"},
            {1, "Dupont", "François", "0789095522"},
            {1, "Dupont", "François", "0789095522"},
            {1, "Dupont", "François", "0789095522"}

    } ;

    JTable Table_Contact = new JTable(data , new Object[]{"Image", "Nom", "Prenom", "Numéro"}){
        private static final long serialVersionUID = 1L;



        public boolean isCellEditable(int row, int column) {
            return false;

        }};



    JScrollPane scroll = new JScrollPane(Table_Contact);
    JTableHeader Header = Table_Contact.getTableHeader();




    public Ecran_Contact() {
        // à voir si cela peut intéresser... (enlève la barre de navigation du JFrame
        //setUndecorated(true);
        setResizable(false);
        add(Panel_START, BorderLayout.NORTH);
        Panel_START.setBackground(Color.BLACK);
        Panel_START.add(Button_Add);
        Panel_START.add(Button_Remove);


        //button back : revenir à l'écran prinicpal -> OK
        add(Panel_END, BorderLayout.SOUTH);
        Panel_END.add(text);
        add(Button_Back, BorderLayout.SOUTH);
        Panel_END.setBackground(Color.BLACK);
        Button_Back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Ecran_Contact.this.dispose();
                //Ecran_Contact.this.setVisible(false);
            }
        });

        // visuel app contact
        add(Panel_Center, BorderLayout.CENTER);

        Panel_Center.add(Header);
        Header.setBackground(Color.BLACK);
        Header.setForeground(Color.WHITE);
        Header.setVisible(true);
        Header.setTable(Table_Contact);


        Panel_Center.setBackground(Color.BLACK);
        Panel_Center.add(Table_Contact);
        Table_Contact.setGridColor(Color.WHITE);
        Table_Contact.setBackground(Color.BLACK);
        Table_Contact.setForeground(Color.WHITE);



        //slider, voir comment on peut faire la faonction de glissage

        //Fonctions pour scroll le tableau
        Panel_Center.add(scroll) ;
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.setHorizontalScrollBarPolicy(scroll.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(scroll.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setViewportBorder(null);
        scroll.setBackground(Color.WHITE);
        scroll.setVisible(true);



        //Button ajouter...
        Button_Add.addMouseListener(new Ecouteur_Ecran_Contact(this));



    }

    public class Ecouteur_Ecran_Contact extends MouseAdapter {

        public Ecouteur_Ecran_Contact(Ecran_Contact EcranAdd ) {


        }

            public void mouseClicked(MouseEvent a ) {

                JFrame AddContact = new JFrame() ;
                AddContact.setResizable(false);
                AddContact.setTitle("Ajouter");
                AddContact.setSize(400, 800);
                AddContact.setLocationRelativeTo(null);
                AddContact.setVisible(true);

                // Champs TextField pour mettre les nouvelles infos
                JPanel centre = new JPanel();
                AddContact.add(centre);
                centre.setVisible(true);

                JLabel enonce_1 = new JLabel();
                enonce_1.setText("Nom:   ");
                centre.add(enonce_1);
                JTextField nom = new JTextField( 28);
                centre.add(nom);


                JLabel enonce_2 = new JLabel();
                enonce_2.setText("Prénom:");
                centre.add(enonce_2);
                JTextField prenom = new JTextField( 28);
                centre.add(prenom);


                JLabel enonce_3 = new JLabel();
                enonce_3.setText("Téléphone:");
                centre.add(enonce_3);
                JTextField numero = new JTextField( 27);
                centre.add(numero);
                ///numero.addActionListener();

                // rajouter un bouton pour choisir la photo à partir de la galerie
                JButton Add_Photo = new JButton("Image de contact");
                centre.add(Add_Photo);
                Add_Photo.setVisible(true);

                //Ecouteur pour donnes rentrées par l'user
                Object [] row = new Object[3] ;
                Add_Photo.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        row[1] = nom.getText();
                        row[2] = prenom.getText();
                        row[3] = numero.getText();
                        // la ligne 0 est réservée à l'image de contact (plutôt une icône vu la taille de chaque ligne)
                    }


                }


            );


                // Buttons avec actions pour ajouter ou annuler l'opération
                JPanel sud = new JPanel();
                AddContact.add(sud, BorderLayout.SOUTH);
                sud.setVisible(true);

                JButton OK_New_Contact = new JButton("Ajouter");
                OK_New_Contact.setVisible(true);
                sud.add(OK_New_Contact);

                JButton Annuler = new JButton("Annuler");
                Annuler.setVisible(true);
                sud.add(Annuler);

                Annuler.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent i) {

                        AddContact.dispose();
                        //Ecran_Contact.this.setVisible(false);
                    }

                });

                OK_New_Contact.addActionListener((new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        //ajoutt d'une nouvelle row avec les nouvelles infos remplies


                    }
                }

                )

                );



                //DefaultTableModel model = (DefaultTableModel)Table_Contact.getModel();

            }



        }


}















