package model.nodes;

import java.util.ArrayList;

public class RuNodeComposite extends RuNode{

    private ArrayList<RuNode> nodeChildren;

    public RuNodeComposite(String name, RuNode parent) {
        super(name, parent);
        this.nodeChildren = new ArrayList<>();
    }
    public void add(RuNode n) {
        this.nodeChildren.add(n);
        this.notifySubscribers(this);
    }

    public void removeChild(RuNode n) {
        n.setParent(null);
        this.getNodeChildren().remove(n);
        n.notifySubscribers(n);
    }

    public ArrayList<RuNode> getNodeChildren() {
        return nodeChildren;
    }

    public void setNodeChildren(ArrayList<RuNode> nodeChildren) {
        this.nodeChildren = nodeChildren;
    }

}
