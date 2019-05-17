import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class Ecouteur_Contact extends MouseAdapter {

    private JButton change = new JButton("Changer la taille");
    private JButton retablir = new JButton("Rétablir");
    

    // essayer de mettre un tableau de valeurs pour avoir un menu déroulant avec 3 colonnes
    //on doit avoir le nom, prenom et numero de contact


    public Ecouteur_Contact() {


    }



    @Override
    public void mouseClicked(MouseEvent event){

        JFrame Window = new JFrame();
        Window.setVisible(true);
        Window.setSize(500,900);
        Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       
        JButton Button_Add = new JButton("Ajouter un contact...") ; 
        JButton Button_Remove = new JButton("Supprimer un contact...") ; 
        JLabel text = new JLabel("Liste de Contacts") ; 
        JPanel Panel_START = new JPanel();
        JPanel Panel_END = new JPanel () ; 
        JPanel Panel_Center = new JPanel() ; 
        
        JTable Table_Contact = new JTable(40, 3);

        
       
        Window.add(Panel_START, BorderLayout.PAGE_START) ;
        Panel_START.add(Button_Add); 
        Panel_START.add(Button_Remove) ; 
        
        Window.add(Panel_END, BorderLayout.PAGE_END) ; 
        Panel_END.add(text) ;
        
        
        Window.add(Panel_Center, BorderLayout.CENTER);
        Panel_Center.add(Table_Contact) ; 
        
        //Table_Contact.addRowSelectionInterval(0,0) ;  
        
    
        
        
        
        Button_Add.setVisible(true);
        Button_Remove.setVisible(true);
        
        
        
    }




 ///class Ecouteur_1 implements mouseClicked {

      //  if()



}
