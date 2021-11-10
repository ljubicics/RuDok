package view.tree.view;

import view.tree.controller.TreeCellEditor;
import view.tree.controller.TreeCellRenderer;
import view.tree.controller.WorkspaceTreeSelectionListener;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;

public class MyTree extends JTree {

    public MyTree() {
        addTreeSelectionListener(new WorkspaceTreeSelectionListener());
        setCellRenderer(new TreeCellRenderer());
        setCellEditor(new TreeCellEditor(this, new DefaultTreeCellRenderer()));
        setEditable(true);
    }
}
