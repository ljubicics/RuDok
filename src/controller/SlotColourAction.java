package controller;


import model.state.slotState.AddSlotState;
import view.MainFrame;
import view.tree.view.PresentationView;
import view.tree.view.ProjectView;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;

public class SlotColourAction extends AbstractRudokAction{

    public SlotColourAction() {
        putValue(SMALL_ICON, loadIcon("icons/wheel.png"));
        putValue(NAME, "Set slot colour");
        putValue(SHORT_DESCRIPTION, "Sets slot colour");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ProjectView projectView = (ProjectView) MainFrame.getInstance().getSplitPaneSaver().getRightComponent();
        JTabbedPane tabbedPane = projectView.getTabbedPane();
        PresentationView presentationView = (PresentationView) tabbedPane.getSelectedComponent();
        Color color = JColorChooser.showDialog(MainFrame.getInstance().getSplitPaneSaver().getRightComponent(), "Choose your next slot colour", Color.WHITE);
        presentationView.getSlotStateManager().getAddSlotState().setColorSlota(color);
    }
}
