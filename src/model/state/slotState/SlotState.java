package model.state.slotState;


import view.tree.view.SlideView;

import java.awt.event.MouseEvent;

public interface SlotState {
    void mousePressed(SlideView sw, MouseEvent me);
    void mouseDragged(SlideView sw, MouseEvent me);
    void mouseReleased(SlideView sw, MouseEvent me);
}
