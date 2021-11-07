package view.tree.controller;

import model.nodes.RuNode;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Slide;
import model.workspace.Workspace;
import view.MainFrame;
import view.tree.model.MyTreeModel;
import view.tree.model.MyTreeNode;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.net.URL;


public class TreeCellRenderer extends DefaultTreeCellRenderer {

    public TreeCellRenderer() {

    }

    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel,expanded, leaf, row,hasFocus);

        if (MainFrame.getInstance().getMyModel().getRoot().equals(value)) {
            URL imageURL = getClass().getResource("icons\\workspace.jpg");
            Icon icon = null;
            if (imageURL != null)
                icon = new ImageIcon(imageURL);
            setIcon(icon);
        } else if (value instanceof Project) {
            URL imageURL = getClass().getResource("icons\\project.png");
            Icon icon = null;
            if (imageURL != null)
                icon = new ImageIcon(imageURL);
            setIcon(icon);
        } else if (value instanceof Presentation) {
            URL imageURL = getClass().getResource("src/view/tree/controller/icons/project.jpg");
            Icon icon = null;
            if (imageURL != null)
                icon = new ImageIcon(imageURL);
            setIcon(icon);
        } else if (value instanceof Slide) {
            URL imageURL = getClass().getResource("src/view/tree/controller/icons/project.jpg");
            Icon icon = null;
            if (imageURL != null)
                icon = new ImageIcon(imageURL);
            setIcon(icon);
        }
        return this;
    }
}
