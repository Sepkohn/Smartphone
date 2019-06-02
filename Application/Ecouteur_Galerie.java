import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class Ecouteur_Galerie extends MouseAdapter {
    public Ecouteur_Galerie(Ecran ecran) {
    }

    public void mouseClicked(MouseEvent e) {
        JFrame test = new JFrame();
        test.setVisible(true);
        test.setSize(200, 200);

    }

    public Image ajouter(Image image) {
        return image;
    }
}
