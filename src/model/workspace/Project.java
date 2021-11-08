package model.workspace;

import model.nodes.RuNode;
import model.nodes.RuNodeComposite;

public class Project extends RuNodeComposite{

    public Project(String name, RuNodeComposite parent) {
        super(name, parent);
    }

    public void addChild(RuNode n) {
        if(n instanceof Presentation)
            super.add(n);
    }
}