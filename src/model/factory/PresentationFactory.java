package model.factory;

import model.nodes.RuNode;
import model.nodes.RuNodeComposite;
import model.workspace.Presentation;
import model.workspace.Project;

public class PresentationFactory extends AbstractNodeFactory{

    @Override
    public RuNode createRuNode(RuNode nodeParent) {
        return new Presentation("Presentation " + (((Project)nodeParent).getNodeChildren().size() + 1), (RuNodeComposite) nodeParent,"Strahinja", "src/view/slidePictures/background.png");
    }

}
