package controller;

import java.awt.event.ActionEvent;

public class SlotColourAction extends AbstractRudokAction{

    public SlotColourAction() {
        putValue(SMALL_ICON, loadIcon("icons/delete.png"));
        putValue(NAME, "Set slot colour");
        putValue(SHORT_DESCRIPTION, "Sets slot colour");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
