import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;


public class Ecran_Contact extends JFrame {


    JButton Button_Add = new JButton("Ajouter un contact...");
    JButton Button_Remove = new JButton("Supprimer un contact...");
    JLabel text = new JLabel("Liste de Contacts");
    JPanel Panel_START = new JPanel();
    JPanel Panel_END = new JPanel();
    JPanel Panel_Center = new JPanel();
    JButton Button_Back = new JButton("Retour");




    //JFrame frame = new JFrame();


    //Tab pour mettre des contacts...
    Object[][] data = {

            {1, "Dupont", "François", "0789095522"},
            {1, "Dupont", "François", "0789095522"},
            {1, "Dupont", "François", "0789095522"},
            {1, "Dupont", "François", "0789095522"}

    } ;

    JTable Table_Contact = new JTable(data, new Object[]{"Image", "Nom", "Prenom", "Numéro"});

    JScrollPane scroll = new JScrollPane(Table_Contact);
    JTableHeader Header = Table_Contact.getTableHeader();





    public Ecran_Contact() {

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
        add(scroll, BorderLayout.EAST);

        //Fonctions pour scroll le tableau
        scroll.setHorizontalScrollBarPolicy(scroll.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(scroll.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(100, 300, 3000, 200);
        scroll.setVisible(true);
        //Panel_Center.add(scroll, BorderLayout.EAST);



        //Button ajouter...
        Button_Add.addMouseListener(new Ecouteur_Ecran_Contact(this));



    }

    public class Ecouteur_Ecran_Contact extends MouseAdapter {

        public Ecouteur_Ecran_Contact(Ecran_Contact ecranContact ) {

            setSize(400, 800);


        }


    }



}


