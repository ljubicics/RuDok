package controller;

import model.state.ViewState;
import view.MainFrame;
import view.tree.view.PresentationView;
import view.tree.view.ProjectView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class SlideShowAction extends AbstractRudokAction{

    public SlideShowAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F9, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("icons/slideshow.png"));
        putValue(NAME, "SlideShow");
        putValue(SHORT_DESCRIPTION, "Start Slide Show");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(MainFrame.getInstance().getSplitPaneSaver().getRightComponent() instanceof ProjectView) {
                ProjectView projectView = (ProjectView) (MainFrame.getInstance().getSplitPaneSaver().getRightComponent());
                JTabbedPane jTabbedPane = projectView.getTabbedPane();
                PresentationView presentationView = (PresentationView) jTabbedPane.getSelectedComponent();
                    presentationView.setViewState();
            }
    }
}
