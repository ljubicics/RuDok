package controller;

import java.awt.event.ActionEvent;

public class SlotStrokeAction extends AbstractRudokAction{

    public SlotStrokeAction() {
        putValue(SMALL_ICON, loadIcon("icons/delete.png"));
        putValue(NAME, "Slot stroke");
        putValue(SHORT_DESCRIPTION, "Sets slot stroke");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
