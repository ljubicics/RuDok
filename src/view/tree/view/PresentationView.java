package view.tree.view;

import model.nodes.RuNode;
import model.workspace.Presentation;
import model.workspace.Slide;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PresentationView extends JPanel {

    private JLabel autorName;
    private List<RuNode> children;
    private String url;

    public PresentationView(Presentation presentation) {
        children = new ArrayList<>();
        this.setLayout(new BorderLayout());
        this.autorName = new JLabel();
        autorName.setText(presentation.getAutor());
        autorName.setHorizontalAlignment(JLabel.CENTER);
        this.add(autorName, BorderLayout.NORTH);
        children.addAll(presentation.getNodeChildren());
        url = presentation.getURL();
        JPanel boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));

        for(RuNode ruNode : children) {
            SlideView slideView = new SlideView((Slide) ruNode, url);
            boxPanel.add(slideView);
        }
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(boxPanel);
        this.add(scrollPane, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
