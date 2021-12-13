package controller;

import java.awt.event.ActionEvent;

public class SelectSlotAction extends AbstractRudokAction{

    public SelectSlotAction() {
        putValue(SMALL_ICON, loadIcon("icons/delete.png"));
        putValue(NAME, "Select slot");
        putValue(SHORT_DESCRIPTION, "Click on slot to select it");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
