package model.workspace;

import model.nodes.RuNode;
import model.nodes.RuNodeComposite;

public class Presentation extends RuNodeComposite {
    public Presentation(String name, RuNodeComposite parent) {
        super(name, parent);
    }

    public void addChild(RuNode n) {
        if(n instanceof Slide)
            super.add(n);
    }
}
