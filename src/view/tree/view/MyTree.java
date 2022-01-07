package view.tree.view;

import model.nodes.RuNode;
import model.workspace.Project;
import view.MainFrame;
import view.tree.controller.TreeCellEditor;
import view.tree.controller.TreeCellRenderer;
import view.tree.controller.WorkspaceTreeSelectionListener;
import view.tree.model.MyTreeModel;
import view.tree.model.MyTreeNode;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;
import java.io.Serializable;

public class MyTree extends JTree {

    public MyTree() {
        addTreeSelectionListener(new WorkspaceTreeSelectionListener());
        setCellRenderer(new TreeCellRenderer());
        setCellEditor(new TreeCellEditor(this, new DefaultTreeCellRenderer()));
        setEditable(true);
    }

    public Project getCurrentProject() {
        MyTreeNode o = (MyTreeNode) MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
        RuNode node = o.getN();
        if(node instanceof Project) {
            return (Project) node;
        }
        return null;
    }

    public void addProject(Project project){
        ((MyTreeModel)getModel()).addProject(project);
        SwingUtilities.updateComponentTreeUI(this);
    }
}
