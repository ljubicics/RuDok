package model.state;

import model.workspace.Presentation;
import view.MainFrame;
import view.tree.view.ProjectView;
import view.tree.view.SlideShowView;

import javax.swing.*;
import java.io.Serializable;

public class ViewState implements PresentationState, Serializable {

    @Override
    public void changeState(Presentation presentation) {

        SlideShowView slideShowView = new SlideShowView(presentation);

        MainFrame.getInstance().remove(MainFrame.getInstance().getToolBar());
        MainFrame.getInstance().setJMenuBar(null);
        JTabbedPane tabbedPane = ((ProjectView) MainFrame.getInstance().getSplitPaneSaver().getRightComponent()).getTabbedPane();
        int selectedIndex = tabbedPane.getSelectedIndex();
        tabbedPane.setComponentAt(selectedIndex, slideShowView);

        MainFrame.getInstance().getSplitPaneSaver().revalidate();
        MainFrame.getInstance().getSplitPaneSaver().repaint();
        slideShowView.revalidate();
        slideShowView.repaint();
        MainFrame.getInstance().revalidate();
        MainFrame.getInstance().repaint();
    }
}
