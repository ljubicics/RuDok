package model.factory;

import model.nodes.RuNode;
import view.tree.model.MyTreeNode;

public abstract class AbstractNodeFactory {

    public RuNode getNFT(MyTreeNode myTreeNode) {
        RuNode selected = myTreeNode.getN();
        RuNode node = createRuNode(selected);
        node.setParent(selected);
        return node;
    }

    public abstract RuNode createRuNode(RuNode nodeParent);
}
