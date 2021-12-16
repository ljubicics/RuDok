package view.tree.view;

import model.state.slotState.SelectSlotState;
import model.workspace.Presentation;
import model.workspace.Slide;
import model.workspace.slotWorkspace.Slot;
import observer.ISubscriber;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

public class SlideView extends JPanel implements ISubscriber {

    private Slide slide;
    private String url;
    private ArrayList<SlotView> slotViewArrayList = new ArrayList<>();
    private SlotView selectedSlot = null;

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

       this.addMouseListener(new MouseAdapter() {
           @Override
           public void mousePressed(MouseEvent e) {
               PresentationView presentationView = (PresentationView) getParent().getParent().getParent().getParent();
               if(presentationView.getSlotState() instanceof SelectSlotState) {
                   for(SlotView slotView : getSlotViewArrayList()) {
                       if(slotView.getShape().contains(e.getPoint())) {
                           selectedSlot = slotView;
                           break;
                       }
                   }
               } else {
                   presentationView.getSlotState().mousePressed((SlideView) e.getComponent(), e);
               }
           }

           @Override
           public void mouseReleased(MouseEvent e) {
               PresentationView presentationView = (PresentationView) getParent().getParent().getParent().getParent();
               presentationView.getSlotState().mouseReleased((SlideView) e.getComponent(), e);
           }

       });

       this.addMouseMotionListener(new MouseAdapter() {
           @Override
           public void mouseDragged(MouseEvent e) {
               PresentationView presentationView = (PresentationView) getParent().getParent().getParent().getParent();
               presentationView.getSlotState().mouseDragged((SlideView) e.getComponent(), e);
           }
       });
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

    public SlotView getSelectedSlot() {
        return selectedSlot;
    }

    public void setSelectedSlot(SlotView selectedSlot) {
        this.selectedSlot = selectedSlot;
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

        Graphics2D g2d = (Graphics2D) g;
        if(this.getParent().getParent().getParent().getParent() instanceof PresentationView) {
            PresentationView presentationView = (PresentationView) this.getParent().getParent().getParent().getParent();
            for (Component c : presentationView.getNavigatorPanel().getComponents()) {
                if (c == this) {
                    g2d.scale(0.3, 0.3);

                }
            }
        } else {
            g2d.scale(1.5, 1.5);
        }

        for(SlotView sw : this.slotViewArrayList) {
            sw.paint(g2d);
        }

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
