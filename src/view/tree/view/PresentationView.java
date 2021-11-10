package view.tree.view;

import model.nodes.RuNode;
import model.workspace.Presentation;
import model.workspace.Slide;
import observer.ISubscriber;
import view.tree.model.MyTreeNode;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PresentationView extends JPanel implements ISubscriber {

    private JLabel autorName;
    private JPanel boxPanel;
    private Presentation presentation;
    private List<RuNode> children;
    private String url;

    public PresentationView(Presentation presentation) {
        this.presentation = presentation;
        this.presentation.addSubscriber(this);
        children = new ArrayList<>();
        this.setLayout(new BorderLayout());
        this.autorName = new JLabel();
        autorName.setText(presentation.getAutor());
        autorName.setHorizontalAlignment(JLabel.CENTER);
        this.add(autorName, BorderLayout.NORTH);
        children.addAll(presentation.getNodeChildren());
        url = presentation.getURL();
        boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));

        for(RuNode ruNode : children) {
            SlideView slideView = new SlideView((Slide) ruNode, url);
            boxPanel.add(slideView);
            boxPanel.add((Box.createRigidArea(new Dimension(0, 50))));
            boxPanel.revalidate();
            boxPanel.repaint();
        }
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(boxPanel);
        this.add(scrollPane, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public JLabel getAutorName() {
        return autorName;
    }

    public void setAutorName(JLabel autorName) {
        this.autorName = autorName;
    }

    public List<RuNode> getChildren() {
        return children;
    }

    public void setChildren(List<RuNode> children) {
        this.children = children;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }

    @Override
    public void update(Object notification) {
        System.out.println(this.presentation);
        Presentation p = (Presentation) notification;

        JTabbedPane tabbedPane = (JTabbedPane) this.getParent();
        int i;
        for(i = 0; i < tabbedPane.getComponentCount(); i++) {
            if(tabbedPane.getComponentAt(i).equals(this)) {
                break;
            }
        }
        tabbedPane.setTitleAt(i, p.getName());

        if(presentation.getNodeChildren().size() > 0) {
            Slide slide = (Slide) presentation.getNodeChildren().get(presentation.getNodeChildren().size()-1);
                boxPanel.add(new SlideView(slide, presentation.getURL()));
                boxPanel.add(Box.createRigidArea(new Dimension(0, 50)));
                boxPanel.revalidate();
                boxPanel.repaint();
                this.revalidate();
                this.repaint();
        }

        if(!(this.getAutorName().equals(p.getAutor()))) {
            this.autorName.setText(p.getAutor());
            this.revalidate();
            this.repaint();
        }

       if(p.getParent() == null) {
            JTabbedPane tabbedPane1 = (JTabbedPane) this.getParent();
            tabbedPane1.remove(this);
            tabbedPane1.revalidate();
            tabbedPane1.repaint();
        }


    }
}
