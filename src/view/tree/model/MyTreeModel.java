package view.tree.model;

import model.workspace.Project;
import model.workspace.Workspace;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;


public class MyTreeModel extends DefaultTreeModel {

    public MyTreeModel(MyTreeNode root) {
        super(root);
    }

    public void addProject(Project project){
        MyTreeNode myTreeNode = (MyTreeNode) getRoot();
        Workspace w = (Workspace) myTreeNode.getN();
        w.addChild(project);
        project.setParent(w);
    }
}
