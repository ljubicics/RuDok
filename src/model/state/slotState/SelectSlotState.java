package model.state.slotState;

import view.tree.view.PresentationView;
import view.tree.view.SlideView;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;

public class SelectSlotState implements SlotState{

    @Override
    public void mousePressed(SlideView sw, MouseEvent me) {

    }

    @Override
    public void mouseDragged(SlideView sw, MouseEvent me) {
        if(sw.getSelectedSlot() != null) {
            GeneralPath shape = new GeneralPath();

            shape.moveTo(me.getPoint().getX(), me.getPoint().getY());
            shape.lineTo(me.getPoint().getX() + sw.getSelectedSlot().getSlot().getWidth(), me.getPoint().getY());
            shape.lineTo(me.getPoint().getX() + sw.getSelectedSlot().getSlot().getWidth(), me.getPoint().getY() + sw.getSelectedSlot().getSlot().getHeight());
            shape.lineTo(me.getPoint().getX(), me.getPoint().getY() + sw.getSelectedSlot().getSlot().getHeight());
            shape.closePath();

            sw.getSelectedSlot().getSlot().setShape(shape);
            sw.getSelectedSlot().getSlot().setPosition(me.getPoint());
            sw.repaint();

            PresentationView presentationView = (PresentationView) sw.getParent().getParent().getParent().getParent();
            if(sw.getParent().getParent().getParent().getParent() instanceof PresentationView) {
                for(Component c : presentationView.getNavigatorPanel().getComponents()) {
                    if(c instanceof SlideView) {
                        if(((SlideView) c).getSlide().getName().equals(sw.getSlide().getName())) {
                            c.revalidate();
                            c.repaint();
                        }
                    }
                }
            }
        }
    }

    @Override
    public void mouseReleased(SlideView sw, MouseEvent me) {

    }
}
