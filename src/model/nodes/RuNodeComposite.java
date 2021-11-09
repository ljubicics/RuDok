package model.nodes;

import observer.IPublisher;

import java.util.ArrayList;

public class RuNodeComposite extends RuNode implements IPublisher {

    private ArrayList<RuNode> nodeChildren;

    public RuNodeComposite(String name, RuNode parent) {
        super(name, parent);
        this.nodeChildren = new ArrayList<>();
    }
    public void add(RuNode n) {
        this.nodeChildren.add(n);
        notifySubscribers(this);
    }

    public void removeChild(RuNode n) {
        nodeChildren.remove(n);
    }

    public ArrayList<RuNode> getNodeChildren() {
        return nodeChildren;
    }

    public void setNodeChildren(ArrayList<RuNode> nodeChildren) {
        this.nodeChildren = nodeChildren;
    }

}
