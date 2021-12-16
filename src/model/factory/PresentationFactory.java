package model.factory;

import model.nodes.RuNode;
import model.nodes.RuNodeComposite;
import model.workspace.Presentation;

public class PresentationFactory extends AbstractNodeFactory{

    @Override
    public RuNode createRuNode(RuNode nodeParent) {
        return new Presentation("Presentation", (RuNodeComposite) nodeParent,"Strahinja", "src/view/slidePictures/background.png");
    }

}
