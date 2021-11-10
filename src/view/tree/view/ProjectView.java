package view.tree.view;

import model.nodes.RuNode;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Workspace;
import observer.ISubscriber;
import view.MainFrame;
import view.tree.model.MyTreeNode;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectView extends JPanel implements ISubscriber {

    private JLabel projectName;
    private Project project;
    private List<RuNode> children;
    private JTabbedPane tabbedPane;
    private JPanel panelLbl;

    public ProjectView(Project project) {
        this.project = project;
        this.projectName = new JLabel();
        this.tabbedPane = new JTabbedPane();
        projectName.setText(project.getName());
        this.setLayout(new BorderLayout());
        panelLbl = new JPanel();
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

    public JLabel getProjectName() {
        return projectName;
    }

    public void setProjectName(JLabel projectName) {
        this.projectName = projectName;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<RuNode> getChildren() {
        return children;
    }

    public void setChildren(List<RuNode> children) {
        this.children = children;
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public void setTabbedPane(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }

    public JPanel getPanelLbl() {
        return panelLbl;
    }

    public void setPanelLbl(JPanel panelLbl) {
        this.panelLbl = panelLbl;
    }

    @Override
    public void update(Object notification) {
        Project n = (Project)notification;

        if(n.getParent() == null) {
            System.out.println("Usao");
            MainFrame.getInstance().getSplitPaneSaver().setRightComponent(new JPanel());
            MainFrame.getInstance().revalidate();
            MainFrame.getInstance().repaint();
            return;
        }

        if(n.getNodeChildren().size() > 0) {
            if(tabbedPane.getTabCount() == 0) {
                System.out.println("Usao u petlju");
                RuNode node = ((Project) notification).getNodeChildren().get(((Project) notification).getNodeChildren().size() - 1);
                Presentation p = (Presentation) node;
                PresentationView pv = new PresentationView(p);
                tabbedPane.addTab(node.getName(), pv);
                tabbedPane.revalidate();
                tabbedPane.repaint();
                return;
            }
        }

        if(n.getNodeChildren().size() > tabbedPane.getTabCount()){
            Presentation p = (Presentation) n.getNodeChildren().get(n.getNodeChildren().size()-1);
            tabbedPane.addTab(p.getName(), new PresentationView(p));
        }

        if(!(projectName.equals(n.getName()))) {
            this.projectName.setText(n.getName());
            return;
        }



    }
}
