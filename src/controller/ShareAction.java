package controller;

import model.workspace.Presentation;
import view.MainFrame;
import view.dialogs.ShareDialog;
import view.tree.model.MyTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ShareAction extends AbstractRudokAction{

    public ShareAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F9, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("icons/sharepresentation.png"));
        putValue(NAME, "Share");
        putValue(SHORT_DESCRIPTION, "Share");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MyTreeNode mtn = (MyTreeNode) MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
        if(mtn.getN() instanceof Presentation) {
            new ShareDialog((Presentation) mtn.getN());
        }
    }
}
