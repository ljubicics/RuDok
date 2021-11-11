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

    private String autorName;
    public JLabel autorLbl;
    private JPanel boxPanel;
    private Presentation presentation;
    private List<RuNode> children;
    private String url;
    private String presentationName;

    public PresentationView(Presentation presentation) {
        this.presentation = presentation;
        this.presentation.addSubscriber(this);
        this.setLayout(new BorderLayout());
        this.autorLbl = new JLabel();
        autorName = presentation.getAutor();
        autorLbl.setText(autorName);
        autorLbl.setHorizontalAlignment(JLabel.CENTER);
        autorLbl.setPreferredSize(new Dimension(0, 30));
        this.add(autorLbl, BorderLayout.NORTH);
        children = new ArrayList<>();
        children.addAll(presentation.getNodeChildren());
        url = presentation.getURL();
        presentationName = presentation.getName();
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

    public String getAutorName() {
        return autorName;
    }

    public void setAutorName(String autorName) {
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
        Presentation p = (Presentation) notification;

        if(boxPanel.getComponentCount() == 0) {
            Slide slide = (Slide) presentation.getNodeChildren().get(presentation.getNodeChildren().size() - 1);
                boxPanel.add(new SlideView(slide, presentation.getURL()));
                boxPanel.add(Box.createRigidArea(new Dimension(0, 50)));
                boxPanel.revalidate();
                boxPanel.repaint();
                this.revalidate();
                this.repaint();
                return;
        }

        if(p.getParent() == null) {
            JTabbedPane tabbedPane1 = (JTabbedPane) this.getParent();
            tabbedPane1.remove(this);
            tabbedPane1.revalidate();
            tabbedPane1.repaint();
            return;
        }

        if(!(this.presentationName.equals(p.getName()))) {
            JTabbedPane tabbedPane = (JTabbedPane) this.getParent();
            for (int i = 0; i < tabbedPane.getComponentCount(); i++) {
                if(tabbedPane.getTitleAt(i).equals(this.presentationName)) {
                    tabbedPane.setTitleAt(i, p.getName());
                    tabbedPane.revalidate();
                    tabbedPane.repaint();
                }
            }
            return;
        }

        if(!(this.getUrl().equals(p.getURL()))) {
            this.url = p.getURL();
            for(int i = 0; i < boxPanel.getComponentCount(); i++) {
                if(boxPanel.getComponent(i) instanceof SlideView) {
                    ((SlideView)boxPanel.getComponent(i)).setUrl(this.url);
                    ((SlideView)boxPanel.getComponent(i)).revalidate();
                    ((SlideView)boxPanel.getComponent(i)).repaint();
                }
            }
            boxPanel.revalidate();
            boxPanel.repaint();
            this.revalidate();
            this.repaint();
            return;
        }

        if(!(this.getAutorName().equals(p.getAutor()))) {
            this.autorLbl.setText(p.getAutor());
            this.revalidate();
            this.repaint();
            return;
        }

        if(presentation.getNodeChildren().size() > 0) {
            Slide slide = (Slide) presentation.getNodeChildren().get(presentation.getNodeChildren().size() - 1);
                boxPanel.add(new SlideView(slide, presentation.getURL()));
                boxPanel.add(Box.createRigidArea(new Dimension(0, 50)));
                boxPanel.revalidate();
                boxPanel.repaint();
                this.revalidate();
                this.repaint();
                return;
        }
    }
}
