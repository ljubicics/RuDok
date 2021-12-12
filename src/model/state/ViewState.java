package model.state;

import model.workspace.Presentation;
import view.MainFrame;
import view.SlideShowToolBar;
import view.tree.view.ProjectView;
import view.tree.view.SlideShowView;

import javax.swing.*;
import java.awt.*;

public class ViewState implements PresentationState{

    @Override
    public void changeState(Presentation presentation) {

        SlideShowView slideShowView = new SlideShowView(presentation);

        MainFrame.getInstance().remove(MainFrame.getInstance().getToolBar());
        SlideShowToolBar slideShowToolbar = new SlideShowToolBar();
        MainFrame.getInstance().setSlideShowToolBar(slideShowToolbar);
        MainFrame.getInstance().add(slideShowToolbar, BorderLayout.NORTH);
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
