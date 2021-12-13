package view.tree.view;

import model.nodes.RuNode;
import model.workspace.Presentation;
import model.workspace.Slide;
import model.workspace.slotWorkspace.Slot;
import observer.ISubscriber;
import view.tree.model.MyTreeNode;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class SlideView extends JPanel implements ISubscriber {

    private Slide slide;
    private String url;
    private ArrayList<SlotView> slotViewArrayList = new ArrayList<>();

    public SlideView(Slide slide, String url) {
       this.slide = slide;
       this.slide.addSubscriber(this);
       this.url = url;
       this.setSize(400, 300);
       this.setPreferredSize(new Dimension(400, 300));
       this.setMaximumSize(new Dimension(400, 300));

       this.setVisible(true);

       for(Slot s : slide.getSlotArrayList()) {
           this.slotViewArrayList.add(new SlotView(s));
       }
    }

    public Slide getSlide() {
        return slide;
    }

    public void setSlide(Slide slide) {
        this.slide = slide;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<SlotView> getSlotViewArrayList() {
        return slotViewArrayList;
    }

    public void setSlotViewArrayList(ArrayList<SlotView> slotViewArrayList) {
        this.slotViewArrayList = slotViewArrayList;
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

    @Override
    public void update(Object notification) {
        Slide slide = (Slide) notification;
        if(slide.getParent() == null) {
            JPanel panel = (JPanel) this.getParent();
            panel.remove(this);
            panel.revalidate();
            panel.repaint();
        }

    }
}
