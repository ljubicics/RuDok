package view.dialogs;

import model.nodes.RuNode;
import model.nodes.RuNodeComposite;
import model.workspace.Presentation;
import observer.ErrorFactory;
import view.MainFrame;
import view.tree.model.MyTreeNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShareDialog extends JDialog {
    private JButton closeBtn;
    private JPanel projectPanel;
    private JScrollPane projectScroll;
    private Presentation presentation;
    public String selected;

    public ShareDialog(Presentation presentation) {
        this.presentation = presentation;
        this.closeBtn = new JButton("Close");
        this.setLayout(new BorderLayout());
        this.add(closeBtn, BorderLayout.SOUTH);
        this.setSize(new Dimension(300,300));
        projectPanel = new JPanel();
        projectPanel.setLayout(new BoxLayout(projectPanel, BoxLayout.Y_AXIS));
        projectScroll = new JScrollPane();

        if(MainFrame.getInstance().getMyTree().getModel().getChildCount(MainFrame.getInstance().getMyTree().getModel().getRoot()) < 2) {
            ErrorFactory.getInstance().generateError("Nije moguće podeliti prezentaciju", "Nema projekata u koje se može podeliti prezentacija", "Dodajte novi projekat i pokusajte ponovo", 0);
            return;
        }

        for(int i = 0; i < MainFrame.getInstance().getMyTree().getModel().getChildCount(MainFrame.getInstance().getMyTree().getModel().getRoot()); i++) {
            MyTreeNode myTreeNode = (MyTreeNode) MainFrame.getInstance().getMyTree().getModel().getChild(MainFrame.getInstance().getMyTree().getModel().getRoot(), i);
            RuNode node = myTreeNode.getN();
            RuNode parent = presentation.getParent();
            if(!(node.equals(parent))) {
                JButton projectBtn = new JButton(node.getName());
                projectBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        selected = projectBtn.getText();
                        for(int i = 0; i < MainFrame.getInstance().getMyTree().getModel().getChildCount(MainFrame.getInstance().getMyTree().getModel().getRoot()); i++) {
                            MyTreeNode myTreeNode = (MyTreeNode) MainFrame.getInstance().getMyTree().getModel().getChild(MainFrame.getInstance().getMyTree().getModel().getRoot(), i);
                            RuNode ruNode = myTreeNode.getN();
                            if(ruNode.getName().equals(selected)) {
                                presentation.setShared(true);
                                ((RuNodeComposite)ruNode).add(presentation);
                            }
                        }
                    }
                });
                projectPanel.add(projectBtn);
                projectBtn.setHorizontalAlignment(JButton.CENTER);
            }
        }

        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        projectScroll.setViewportView(projectPanel);
        this.add(projectScroll, BorderLayout.CENTER);
        this.setLocationRelativeTo(MainFrame.getInstance());
        this.setVisible(true);
    }

    public JButton getCloseBtn() {
        return closeBtn;
    }

    public void setCloseBtn(JButton closeBtn) {
        this.closeBtn = closeBtn;
    }

    public JPanel getProjectPanel() {
        return projectPanel;
    }

    public void setProjectPanel(JPanel projectPanel) {
        this.projectPanel = projectPanel;
    }

    public JScrollPane getProjectScroll() {
        return projectScroll;
    }

    public void setProjectScroll(JScrollPane projectScroll) {
        this.projectScroll = projectScroll;
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }
}
