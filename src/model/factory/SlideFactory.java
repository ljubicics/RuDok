package model.factory;

import model.nodes.RuNode;
import model.workspace.Presentation;
import model.workspace.Slide;

public class SlideFactory extends AbstractNodeFactory{

    @Override
    public RuNode createRuNode(RuNode nodeParent) {
        return new Slide("Slide " + (((Presentation)nodeParent).getNodeChildren().size() + 1), nodeParent);
    }

}
