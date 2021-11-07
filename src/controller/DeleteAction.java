package controller;

import model.nodes.RuNode;
import model.nodes.RuNodeComposite;
import view.MainFrame;
import view.tree.model.MyTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteAction extends AbstractRudokAction{

    public DeleteAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("icons/delete.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Deletes selected object");
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("delete");
        MyTreeNode o = (MyTreeNode) MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
        RuNode node = o.getN();
        RuNodeComposite parent = (RuNodeComposite) node.getParent();
        parent.removeChild(node);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
    }
}
