package controller;

import model.nodes.RuNode;
import model.workspace.Project;
import view.MainFrame;
import view.tree.model.MyTreeNode;
import view.tree.view.MyTree;
import view.tree.view.ProjectView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DoubleClickProjectController extends MouseAdapter {

    private MyTree myTree;

    public DoubleClickProjectController(MyTree myTree) {
        this.myTree = myTree;
        myTree.addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount()==2) {
            MyTreeNode o = (MyTreeNode) MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
            try {
                RuNode node = o.getN();
                if(node instanceof Project) {
                    MainFrame.getInstance().getSplitPaneSaver().setRightComponent(new ProjectView((Project) node));
                }
            } catch (NullPointerException ignored) {
                return;
            }
        }
    }
}
