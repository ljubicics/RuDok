package model.factory;

import model.nodes.RuNode;
import model.nodes.RuNodeComposite;
import model.workspace.Project;

public class ProjectFactory extends AbstractNodeFactory{

    @Override
    public RuNode createRuNode(RuNode nodeParent) {
        return new Project("Project", (RuNodeComposite) nodeParent);
    }

}
