package model.workspace;

import model.nodes.RuNode;
import model.nodes.RuNodeComposite;

import java.io.Serializable;

public class Workspace extends RuNodeComposite implements Serializable {
    public Workspace(String name, RuNodeComposite parent) {
        super(name, parent);
    }


    public void addChild(RuNode n) {
        if(n instanceof Project)
            super.add(n);
    }
}
