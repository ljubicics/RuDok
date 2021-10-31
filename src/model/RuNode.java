package model;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Enumeration;

public class RuNode extends RuNodeComposite{

    public RuNode(String name, RuNodeComposite parent) {
        super(name, parent);
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        return super.getChildAt(childIndex);
    }

    @Override
    public int getChildCount() {
        return super.getChildCount();
    }

    @Override
    public int getIndex(TreeNode node) {
        return super.getIndex(node);
    }

    @Override
    public boolean getAllowsChildren() {
        return super.getAllowsChildren();
    }

    @Override
    public boolean isLeaf() {
        return super.isLeaf();
    }

    @Override
    public Enumeration<? extends TreeNode> children() {
        return super.children();
    }

    @Override
    public ArrayList<RuNodeComposite> getNodeChildren() {
        return super.getNodeChildren();
    }

    @Override
    public void setNodeChildren(ArrayList<RuNodeComposite> nodeChildren) {
        super.setNodeChildren(nodeChildren);
    }
}
