import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ecouteur_Galerie extends MouseAdapter {
    public Ecouteur_Galerie(Ecran ecran) {
    }

    public void mouseClicked(MouseEvent e) {
        JFrame test = new JFrame();
        test.setVisible(true);
        test.setSize(200, 200);
        test.setResizable(false);
        test.setLocationRelativeTo(null);
    }

    public Image ajouter(Image image) {
        return image;
    }
}
