package view.tree.model;

import model.nodes.RuNode;
import model.nodes.RuNodeComposite;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Enumeration;

public class MyTreeNode extends DefaultMutableTreeNode {
    private RuNode n;

    public MyTreeNode(RuNode n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return n.getName();
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        if(n instanceof RuNodeComposite){
           RuNode rn = ((RuNodeComposite) n).getNodeChildren().get(childIndex);
           return new MyTreeNode(rn);
        }
        return null;
    }

    @Override
    public int getChildCount() {
        if(n instanceof RuNodeComposite)
            return ((RuNodeComposite) n).getNodeChildren().size();
        return 0;
    }

    @Override
    public MyTreeNode getParent() {
        return new MyTreeNode(n.getParent());
    }

    @Override
    public int getIndex(TreeNode node) {
        if(n instanceof RuNodeComposite)
            return ((RuNodeComposite) n).getNodeChildren().indexOf(node);
        return 0;
    }

    @Override
    public boolean getAllowsChildren() {
        return n instanceof RuNodeComposite;
    }

    @Override
    public boolean isLeaf() {
        return !(n instanceof RuNodeComposite);
    }

    @Override
    public Enumeration<TreeNode> children() {
        return null;
    }

    public RuNode getN() {
        return n;
    }

    public void setN(RuNode n) {
        this.n = n;
    }
}
