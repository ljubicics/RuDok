package controller;

import model.state.slotState.AddSlotState;
import model.workspace.Presentation;
import view.MainFrame;
import view.tree.view.PresentationView;
import view.tree.view.ProjectView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddNewSlotAction extends AbstractRudokAction{

    public AddNewSlotAction() {
        putValue(SMALL_ICON, loadIcon("icons/delete.png"));
        putValue(NAME, "Add new slot");
        putValue(SHORT_DESCRIPTION, "Adds new slot to selected slide");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ProjectView projectView = (ProjectView) MainFrame.getInstance().getSplitPaneSaver().getRightComponent();
        JTabbedPane tabbedPane = projectView.getTabbedPane();
        PresentationView presentationView = (PresentationView) tabbedPane.getSelectedComponent();
        Presentation presentation = presentationView.getPresentation();
        presentation.setSlotState(presentation.getSlotStateManager().getAddSlotState());
    }
}
