package controller;

import model.state.slotState.AddSlotState;
import model.state.slotState.SelectSlotState;
import model.workspace.Presentation;
import view.MainFrame;
import view.tree.view.PresentationView;
import view.tree.view.ProjectView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SelectSlotAction extends AbstractRudokAction{

    public SelectSlotAction() {
        putValue(SMALL_ICON, loadIcon("icons/info.png"));
        putValue(NAME, "Select slot");
        putValue(SHORT_DESCRIPTION, "Click on slot to select it");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ProjectView projectView = (ProjectView) MainFrame.getInstance().getSplitPaneSaver().getRightComponent();
        JTabbedPane tabbedPane = projectView.getTabbedPane();
        PresentationView presentationView = (PresentationView) tabbedPane.getSelectedComponent();
        Presentation presentation = presentationView.getPresentation();
        presentation.setSlotState(new SelectSlotState());
    }
}
