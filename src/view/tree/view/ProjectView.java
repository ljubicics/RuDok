package view.tree.view;

import model.nodes.RuNode;
import model.workspace.Presentation;
import model.workspace.Project;
import observer.ISubscriber;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectView extends JPanel implements ISubscriber {

    private JLabel projectName;
    private Project project;
    private List<RuNode> children;
    private JTabbedPane tabbedPane;

    public ProjectView(Project project) {
        this.project = project;
        this.projectName = new JLabel();
        this.tabbedPane = new JTabbedPane();
        projectName.setText(project.getName());
        this.setLayout(new BorderLayout());
        JPanel panelLbl = new JPanel();
        panelLbl.add(projectName);
        this.add(panelLbl, BorderLayout.NORTH);
        this.project.addSubscriber(this);
        children = new ArrayList<>();
        children.addAll(project.getNodeChildren());

        for(RuNode ruNode : children) {
         PresentationView presentationView = new PresentationView((Presentation) ruNode);
         tabbedPane.addTab(ruNode.getName(), presentationView);
        }

        this.add(tabbedPane, BorderLayout.CENTER);
        this.setVisible(true);
    }

    @Override
    public void update(Object notification) {
        RuNode n = (Project)notification;
        this.projectName.setText(n.getName());
    }
}
