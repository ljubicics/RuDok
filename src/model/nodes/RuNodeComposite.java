package model.nodes;

import java.util.ArrayList;

public class RuNodeComposite extends RuNode {

    private ArrayList<RuNode> nodeChildren;

    public RuNodeComposite(String name, RuNode parent) {
        super(name, parent);
        this.nodeChildren = new ArrayList<>();
    }

    public void addChild(RuNode n) {
        nodeChildren.add(n);
    }

    public void removeChile(RuNode n) {
        nodeChildren.remove(n);
    }

    public ArrayList<RuNode> getNodeChildren() {
        return nodeChildren;
    }

    public void setNodeChildren(ArrayList<RuNode> nodeChildren) {
        this.nodeChildren = nodeChildren;
    }
}
