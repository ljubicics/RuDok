package view.tree.controller;

import model.nodes.RuNode;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Slide;
import model.workspace.Workspace;
import view.tree.model.MyTreeNode;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.net.URL;


public class TreeCellRenderer extends DefaultTreeCellRenderer {

    public TreeCellRenderer() {

    }

    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel,expanded, leaf, row,hasFocus);

        if(value instanceof MyTreeNode) {
            RuNode n = ((MyTreeNode) value).getN();
            if (n instanceof Workspace) {
                URL imageURL = getClass().getResource("icons\\workspace.png");
                Icon icon = null;
                if (imageURL != null)
                    icon = new ImageIcon(imageURL);
                setIcon(icon);
            } else if (n instanceof Project) {
                URL imageURL = getClass().getResource("icons\\project.png");
                Icon icon = null;
                if (imageURL != null)
                    icon = new ImageIcon(imageURL);
                setIcon(icon);
            } else if (n instanceof Presentation) {
                URL imageURL = getClass().getResource("icons\\presentation.png");
                Icon icon = null;
                if (imageURL != null)
                    icon = new ImageIcon(imageURL);
                setIcon(icon);
            } else if (n instanceof Slide) {
                URL imageURL = getClass().getResource("icons\\slide.png");
                Icon icon = null;
                if (imageURL != null)
                    icon = new ImageIcon(imageURL);
                setIcon(icon);
            }
            return this;
        }
        return this;
    }
}
