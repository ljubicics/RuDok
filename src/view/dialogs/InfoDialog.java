package view.dialogs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class InfoDialog extends JDialog {

    public InfoDialog(JFrame parent) {
        setTitle("Info");
        JLabel lblPrezime = new JLabel("Prezime: Ljubicic");
        JLabel lblIme = new JLabel("Ime: Strahinja");
        JLabel lblIndex = new JLabel("Index: RN71-20");

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src/view/dialogs/dialogImages/slika.jpeg"));
        } catch (IOException e) {
            System.err.println("Error while loading image");
        }

        BufferedImage img2 = null;
        try {
            img2 = ImageIO.read(new File("src/view/dialogs/dialogImages/info.png"));
        } catch (IOException e) {
            System.err.println("Error while loading image");
        }
        this.setIconImage(img2);

        JPanel panel = new JPanel();
        JLabel lblImage = new JLabel();
        lblImage.setIcon(new ImageIcon(img));

        JPanel panelNext = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(lblImage);
        panel.add(panelNext);
        panelNext.setLayout(new BoxLayout(panelNext, BoxLayout.Y_AXIS));
        panelNext.add(lblIme);
        panelNext.add(lblPrezime);
        panelNext.add(lblIndex);
        this.add(panel);
        this.setSize(500,250);
        this.setModal(true);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(parent);
        this.setResizable(false);
        this.setVisible(true);
    }
}
