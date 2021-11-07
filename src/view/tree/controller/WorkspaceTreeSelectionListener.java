package view.tree.controller;

import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Slide;
import model.workspace.Workspace;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class WorkspaceTreeSelectionListener implements TreeSelectionListener {

    @Override
    public void valueChanged(TreeSelectionEvent e) {

        TreePath path = e.getPath();
        for(int i = 0; i < path.getPathCount(); i++) {
            if(path.getPathComponent(i) instanceof Workspace) {
                Workspace w = (Workspace) path.getPathComponent(i);

                System.out.println("Selektovan dijagram" + w);
            }
            if(path.getPathComponent(i) instanceof Project) {
                Project p = (Project) path.getPathComponent(i);
            }
            if(path.getPathComponent(i) instanceof Presentation) {
                Presentation p = (Presentation) path.getPathComponent(i);
            }
            if(path.getPathComponent(i) instanceof Slide) {
                Slide s = (Slide) path.getPathComponent(i);
            }
        }
    }
}
