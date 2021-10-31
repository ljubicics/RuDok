package model;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.UUID;

public class RuNodeComposite implements TreeNode{

    private String name;
    private RuNodeComposite parent;
    private ArrayList<RuNodeComposite> nodeChildren;
    private String ID;

    public RuNodeComposite(String name, RuNodeComposite parent) {
        this.name = name;
        this.parent = parent;
        this.nodeChildren = new ArrayList<>();
        this.ID = UUID.randomUUID().toString();
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        return null;
    }

    @Override
    public int getChildCount() {
        return 0;
    }

    @Override
    public TreeNode getParent() {
        return null;
    }

    @Override
    public int getIndex(TreeNode node) {
        return 0;
    }

    @Override
    public boolean getAllowsChildren() {
        return false;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public Enumeration<? extends TreeNode> children() {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParent(RuNodeComposite parent) {
        this.parent = parent;
    }

    public ArrayList<RuNodeComposite> getNodeChildren() {
        return nodeChildren;
    }

    public void setNodeChildren(ArrayList<RuNodeComposite> nodeChildren) {
        this.nodeChildren = nodeChildren;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
