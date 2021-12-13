package controller;

import java.awt.event.ActionEvent;

public class AddNewSlotAction extends AbstractRudokAction{

    public AddNewSlotAction() {
        putValue(SMALL_ICON, loadIcon("icons/delete.png"));
        putValue(NAME, "Add new slot");
        putValue(SHORT_DESCRIPTION, "Adds new slot to selected slide");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
