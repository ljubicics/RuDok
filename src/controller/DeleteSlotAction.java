package controller;

import java.awt.event.ActionEvent;

public class DeleteSlotAction extends AbstractRudokAction{

    public DeleteSlotAction() {
        putValue(SMALL_ICON, loadIcon("icons/delete.png"));
        putValue(NAME, "Delete slot");
        putValue(SHORT_DESCRIPTION, "Deletes selected slot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
