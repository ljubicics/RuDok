package view.tree.view;

import model.workspace.Slide;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SlideView extends JPanel {

    private Slide slide;
    private String url;

    public SlideView(Slide slide, String url) {
       this.slide = slide;
       this.url = url;
       this.setPreferredSize(new Dimension(300,400));

       this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image img = null;
        try {
             img = ImageIO.read(new File(url));
        } catch (Exception e) {
            e.printStackTrace();
        }

        g.drawImage(img,0,0, this.getWidth(),this.getHeight(), null);
    }
}
