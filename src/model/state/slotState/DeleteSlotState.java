package model.state.slotState;

import view.tree.view.PresentationView;
import view.tree.view.SlideView;
import view.tree.view.SlotView;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.Serializable;

public class DeleteSlotState implements SlotState, Serializable {
    @Override
    public void mousePressed(SlideView sw, MouseEvent me) {
        PresentationView presentationView = (PresentationView) sw.getParent().getParent().getParent().getParent();
        if(sw.getParent().getParent().getParent().getParent() instanceof PresentationView) {
            for(Component c : presentationView.getNavigatorPanel().getComponents()) {
                if(c instanceof SlideView) {
                    if(c == sw) {
                        return;
                    }
                }
            }
        }

        SlotView slotView1= null;
        for(SlotView slotView : sw.getSlotViewArrayList()) {
            if(slotView.getShape().contains(me.getPoint())) {
                slotView1 = slotView;
                break;
            }
        }

        if(slotView1 != null) {
            sw.getSlotViewArrayList().remove(slotView1);
            sw.getSlide().getSlotArrayList().remove(slotView1.getSlot());
            sw.revalidate();
            sw.repaint();
            PresentationView presentationView1 = (PresentationView) sw.getParent().getParent().getParent().getParent();
            for (Component c : presentationView1.getNavigatorPanel().getComponents()) {
                if(c instanceof SlideView) {
                    ((SlideView) c).getSlotViewArrayList().remove(slotView1);
                    c.revalidate();
                    c.repaint();
                }
            }
        }
    }

    @Override
    public void mouseDragged(SlideView sw, MouseEvent me) {

    }

    @Override
    public void mouseReleased(SlideView sw, MouseEvent me) {

    }
}
