package model.factory;

import model.nodes.RuNode;

public abstract class AbstractNodeFactory {

    public RuNode getNFT(RuNode ruNode) {
        RuNode node = createRuNode(ruNode);
        node.setParent(ruNode);
        return node;
    }

    public abstract RuNode createRuNode(RuNode nodeParent);
}
