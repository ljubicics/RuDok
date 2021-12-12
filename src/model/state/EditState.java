package model.state;

import model.workspace.Presentation;
import view.MainFrame;
import view.tree.view.PresentationView;
import view.tree.view.ProjectView;

import javax.swing.*;
import java.awt.*;

public class EditState implements PresentationState{
    @Override
    public void changeState(Presentation presentation) {
            PresentationView presentationView = new PresentationView(presentation);
            JTabbedPane tabbedPane = ((ProjectView) MainFrame.getInstance().getSplitPaneSaver().getRightComponent()).getTabbedPane();
            int selectedIndex = tabbedPane.getSelectedIndex();
            tabbedPane.setComponentAt(selectedIndex, presentationView);
            MainFrame.getInstance().setJMenuBar(MainFrame.getInstance().getMyMenuBar());
            if(MainFrame.getInstance().getSlideShowToolBar() != null) {
                MainFrame.getInstance().remove(MainFrame.getInstance().getSlideShowToolBar());
            }
            MainFrame.getInstance().add(MainFrame.getInstance().getToolBar(), BorderLayout.NORTH);
            MainFrame.getInstance().revalidate();
            MainFrame.getInstance().repaint();

    }

    /*public void returnToEditState() {
        MainFrame.getInstance().setJMenuBar(MainFrame.getInstance().getMyMenuBar());
        MainFrame.getInstance().remove(MainFrame.getInstance().getSlideShowToolBar());
        MainFrame.getInstance().add(MainFrame.getInstance().getToolBar(), BorderLayout.NORTH);
        MainFrame.getInstance().getSplitPaneSaver().removeAll();
        MainFrame.getInstance().getSplitPaneSaver().add(MainFrame.getInstance().getSplitPaneSaver());
        MainFrame.getInstance().getSplitPaneSaver().revalidate();
        MainFrame.getInstance().getSplitPaneSaver().repaint();
        MainFrame.getInstance().add(MainFrame.getInstance().getSplitPaneSaver());
        MainFrame.getInstance().revalidate();
        MainFrame.getInstance().repaint();
    }*/
}