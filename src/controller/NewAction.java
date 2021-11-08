package controller;


import view.dialogs.AddNewPresentationDialog;
import model.nodes.RuNode;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Slide;
import model.workspace.Workspace;
import view.MainFrame;

import view.tree.model.MyTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewAction extends AbstractRudokAction{

    public NewAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F10, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("icons/new.png"));
        putValue(NAME, "New");
        putValue(SHORT_DESCRIPTION, "New");
    }

    public void actionPerformed(ActionEvent e) {
        MyTreeNode o = (MyTreeNode) MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
        RuNode node = o.getN();
        if(node instanceof Workspace) {
            System.out.println(((Workspace) node).getNodeChildren().isEmpty());
            Project p = new Project("Projekat " + (((Workspace) node).getNodeChildren().size()+1), (Workspace) node);
            ((Workspace) node).addChild(p);
            System.out.println(((Workspace) node).getNodeChildren().isEmpty());
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
        }
        if(node instanceof Project) {
            new AddNewPresentationDialog(MainFrame.getInstance(), node);
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
        }
        if(node instanceof Presentation) {
            Slide s = new Slide("Slide " + (((Presentation)node).getNodeChildren().size()+1), node);
            ((Presentation) node).add(s);
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
       }
    }
}
