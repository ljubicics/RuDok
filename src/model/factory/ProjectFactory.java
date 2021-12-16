package model.factory;

import model.nodes.RuNode;
import model.nodes.RuNodeComposite;
import model.workspace.Project;
import model.workspace.Workspace;

public class ProjectFactory extends AbstractNodeFactory{

    @Override
    public RuNode createRuNode(RuNode nodeParent) {
        return new Project("Project " + (((Workspace)nodeParent).getNodeChildren().size() + 1), (RuNodeComposite) nodeParent);
    }

}
