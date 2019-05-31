import javax.swing.*;
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
    JSlider slider = new JSlider (JSlider.VERTICAL);
    JButton Button_Back = new JButton("Retour");
    JScrollPane Slider = new JScrollPane(Panel_Center);
    //JFrame frame = new JFrame();


    // object[] columns = {"Image", "Nom", "Prenom", "Numéro"} ;

    JTable Table_Contact = new JTable(40, 4);

    // a voir si on fait un header dans le tableau

    //DefaultTableModel model = new DefaultTableModel() ;
    //model.setColumnIdentifiers(colums);
    // Table_Contact.setModel(model) ;


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
                Ecran_Contact.this.setVisible(false);
            }
        });

        // visuel app contact
        add(Panel_Center, BorderLayout.CENTER);
        Panel_Center.setBackground(Color.BLACK);
        Panel_Center.add(Table_Contact);
        Table_Contact.setGridColor(Color.WHITE);
        Table_Contact.setBackground(Color.BLACK);
        Table_Contact.setForeground(Color.WHITE);


        //slider, voir comment on peut faire la faonction de glissage
        add(Slider, BorderLayout.EAST);

        //Fonctions pour scroll le tableau
        Slider.setHorizontalScrollBarPolicy(Slider.HORIZONTAL_SCROLLBAR_NEVER);
        Slider.setVerticalScrollBarPolicy(Slider.VERTICAL_SCROLLBAR_AS_NEEDED);
        Slider.setBounds(50, 30, 300, 50);
        Panel_Center.add(Slider, BorderLayout.EAST);

        add(slider, BorderLayout.EAST) ;


        Button_Add.addMouseListener(new Ecouteur_Ecran_Contact(this));


        //frame.pack();

        //frame.setVisible(true);
        // champ reserve

    }

    public class Ecouteur_Ecran_Contact extends MouseAdapter {

        public Ecouteur_Ecran_Contact(Ecran_Contact ecranContact ) {

            setSize(400, 800);


        }


    }
}