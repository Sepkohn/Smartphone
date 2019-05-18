import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;


public class Ecouteur_Contact extends MouseAdapter {

    private JButton change = new JButton("Changer la taille");
    private JButton retablir = new JButton("Rétablir");


    // essayer de mettre un tableau de valeurs pour avoir un menu déroulant avec 3 colonnes
    //on doit avoir le nom, prenom et numero de contact


    public Ecouteur_Contact(Ecran Ecran) {


    }

    @Override
    public void mouseClicked(MouseEvent event){

        JFrame Window = new JFrame();
        Window.setVisible(true);
        Window.setBackground(Color.BLACK);
        Window.setSize(500,900);
        Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       
        JButton Button_Add = new JButton("Ajouter un contact...") ; 
        JButton Button_Remove = new JButton("Supprimer un contact...") ; 
        JLabel text = new JLabel("Liste de Contacts") ; 
        JPanel Panel_START = new JPanel();
        JPanel Panel_END = new JPanel () ; 
        JPanel Panel_Center = new JPanel() ; 
        JButton Button_Back = new JButton("Retour") ;

       // object[] columns = {"Image", "Nom", "Prenom", "Numéro"} ;

        JTable Table_Contact = new JTable(40, 4);

// a voir si on fait un header dans le tableau

        //DefaultTableModel model = new DefaultTableModel() ;
        //model.setColumnIdentifiers(colums);
       // Table_Contact.setModel(model) ;


        Window.setTitle("Contacts");
        Window.add(Panel_START, BorderLayout.NORTH) ;
        Panel_START.setBackground(Color.BLACK);
        Panel_START.add(Button_Add); 
        Panel_START.add(Button_Remove) ; 
        
        Window.add(Panel_END, BorderLayout.SOUTH) ;
        Panel_END.add(text) ;
        Window.add(Button_Back, BorderLayout.SOUTH);
        Panel_END.setBackground(Color.BLACK);
        
        Window.add(Panel_Center, BorderLayout.CENTER);
        Panel_Center.setBackground(Color.BLACK);
        Panel_Center.add(Table_Contact) ;
        Table_Contact.setGridColor(Color.WHITE);
        Table_Contact.setBackground(Color.BLACK);
        Table_Contact.setForeground(Color.WHITE);


        //Button_Back.setActionCommand("close");
        //Button pour revenir au main à faire



        
    }


    }


