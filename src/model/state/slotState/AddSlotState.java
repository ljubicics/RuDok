package model.state.slotState;

import model.workspace.Slide;
import model.workspace.slotWorkspace.Slot;
import view.tree.view.PresentationView;
import view.tree.view.SlideView;
import view.tree.view.SlotView;

import java.awt.*;
import java.awt.event.MouseEvent;

public class AddSlotState implements SlotState{

    private Color colorSlota = new Color(255,255,255);
    private Stroke strokeSlota;

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

        Slot slot = new Slot(me.getPoint(), 60, 40, colorSlota, strokeSlota);
        Slide slide = sw.getSlide();
        slide.getSlotArrayList().add(slot);
        SlotView slotView = new SlotView(slot);
        sw.getSlotViewArrayList().add(slotView);
        if(sw.getParent().getParent().getParent().getParent() instanceof PresentationView) {
            for(Component c : presentationView.getNavigatorPanel().getComponents()) {
                if(c instanceof SlideView) {
                    if(((SlideView) c).getSlide().getName().equals(sw.getSlide().getName())) {
                        ((SlideView) c).getSlotViewArrayList().add(slotView);
                        c.revalidate();
                        c.repaint();
                    }
                }
            }
        }
        sw.revalidate();
        sw.repaint();
    }

    @Override
    public void mouseDragged(SlideView sw, MouseEvent me) {

    }

    @Override
    public void mouseReleased(SlideView sw, MouseEvent me) {

    }

    public Color getColorSlota() {
        return colorSlota;
    }

    public void setColorSlota(Color colorSlota) {
        this.colorSlota = colorSlota;
    }

}
