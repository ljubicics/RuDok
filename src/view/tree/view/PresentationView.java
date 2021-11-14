package view.tree.view;

import model.nodes.RuNode;
import model.workspace.Presentation;
import model.workspace.Slide;
import observer.ISubscriber;

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

        if(p.getParent() == null) {
            JTabbedPane tabbedPane1 = (JTabbedPane) this.getParent();
            tabbedPane1.remove(this);
            tabbedPane1.revalidate();
            tabbedPane1.repaint();
            return;
        }

        if(!(this.presentationName.equals(p.getName()))) {
            System.out.println("Ulazi u izmenu imena");
            JTabbedPane tabbedPane = (JTabbedPane) this.getParent();
            System.out.println(p.getNodeChildren().size());
            System.out.println(boxPanel.getComponentCount());
            for (int i = 0; i < tabbedPane.getComponentCount(); i++) {
                if(tabbedPane.getTitleAt(i).equals(this.presentationName)) {
                    tabbedPane.setTitleAt(i, p.getName());
                    tabbedPane.revalidate();
                    tabbedPane.repaint();
                }
            }
            this.presentationName = p.getName();
            return;
        }

        if(!(this.getUrl().equals(p.getURL()))) {
            this.url = p.getURL();
            for(int i = 0; i < boxPanel.getComponentCount(); i++) {
                if(boxPanel.getComponent(i) instanceof SlideView) {
                    ((SlideView)boxPanel.getComponent(i)).setUrl(this.url);
                    (boxPanel.getComponent(i)).revalidate();
                    (boxPanel.getComponent(i)).repaint();
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
            this.autorName = p.getAutor();
            this.revalidate();
            this.repaint();
            return;
        }
        if (p.getNodeChildren().size() > 0) {
            Slide mySlide = (Slide) p.getNodeChildren().get(p.getNodeChildren().size() - 1);
            if (boxPanel.getComponentCount() == 0) {
                boxPanel.add(new SlideView(mySlide, p.getURL()));
               boxPanel.add(Box.createRigidArea(new Dimension(0, 50)));
                boxPanel.revalidate();
                boxPanel.repaint();
                this.revalidate();
                this.repaint();

            }
            Slide mySlide2 = (Slide) p.getNodeChildren().get(p.getNodeChildren().size()-1);
            SlideView lastSlideView = (SlideView) boxPanel.getComponent(boxPanel.getComponentCount() - 2);
            Slide lastSlide = lastSlideView.getSlide();
            if (!(lastSlide.equals(mySlide2))) {
                boxPanel.add(new SlideView(mySlide2, p.getURL()));
               boxPanel.add(Box.createRigidArea(new Dimension(0, 50)));
                boxPanel.revalidate();
                boxPanel.repaint();
                this.revalidate();
                this.repaint();
            }
        }

    }
}
