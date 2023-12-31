package controller;

import view.MainFrame;
import view.tree.view.PresentationView;
import view.tree.view.ProjectView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DeleteSlotAction extends AbstractRudokAction{

    public DeleteSlotAction() {
        putValue(SMALL_ICON, loadIcon("icons/deleteSlot.png"));
        putValue(NAME, "Delete slot");
        putValue(SHORT_DESCRIPTION, "Deletes selected slot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ProjectView projectView = (ProjectView) MainFrame.getInstance().getSplitPaneSaver().getRightComponent();
        JTabbedPane tabbedPane = projectView.getTabbedPane();
        PresentationView presentationView = (PresentationView) tabbedPane.getSelectedComponent();
        presentationView.setSlotState(presentationView.getSlotStateManager().getDeleteSlotState());
    }
}
