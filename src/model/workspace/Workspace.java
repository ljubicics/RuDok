package model.workspace;

import model.nodes.RuNode;
import model.nodes.RuNodeComposite;

public class Workspace extends RuNodeComposite {
    public Workspace(String name, RuNodeComposite parent) {
        super(name, parent);
    }


    public void addChild(RuNode n) {
        if(n instanceof Project)
            super.add(n);
    }
}
