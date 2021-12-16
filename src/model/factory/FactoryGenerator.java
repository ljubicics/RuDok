package model.factory;

import model.nodes.RuNode;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Workspace;

public class FactoryGenerator {
    private RuNode selected;
    final SlideFactory slideFactory = new SlideFactory();
    final PresentationFactory presentationFactory = new PresentationFactory();
    final ProjectFactory projectFactory = new ProjectFactory();

    public FactoryGenerator(RuNode selected) {
        this.selected = selected;
    }

    public AbstractNodeFactory returnNodeFactory(RuNode selected) {
        if(selected instanceof Workspace)
            return projectFactory;
        if(selected instanceof Project)
            return presentationFactory;
        if(selected instanceof Presentation)
            return slideFactory;
        return null;
    }
}
