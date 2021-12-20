package controller;

import view.MainFrame;
import view.dialogs.SlotStrokeDialog;
import view.tree.view.ProjectView;

import java.awt.event.ActionEvent;

public class SlotStrokeAction extends AbstractRudokAction{

    public SlotStrokeAction() {
        putValue(SMALL_ICON, loadIcon("icons/line.png"));
        putValue(NAME, "Slot stroke");
        putValue(SHORT_DESCRIPTION, "Sets slot stroke");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new SlotStrokeDialog((ProjectView) MainFrame.getInstance().getSplitPaneSaver().getRightComponent());
    }
}
