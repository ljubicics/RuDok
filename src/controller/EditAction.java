package controller;

import model.nodes.RuNode;
import model.workspace.Presentation;
import view.MainFrame;
import view.dialogs.EditDialog;
import view.tree.model.MyTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class EditAction extends AbstractRudokAction{

    public EditAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F6, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("icons/info.png"));
        putValue(NAME, "Edit");
        putValue(SHORT_DESCRIPTION, "Edit presentationb");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        MyTreeNode mtn = (MyTreeNode) MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
        RuNode n = mtn.getN();
        if(n instanceof Presentation) {
            EditDialog editDialog = new EditDialog(MainFrame.getInstance(), n);
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
        }
    }
}
