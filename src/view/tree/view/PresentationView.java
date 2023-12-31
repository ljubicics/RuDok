package view.tree.view;

import model.nodes.RuNode;
import model.state.PresentationStateManager;
import model.state.slotState.SlotState;
import model.state.slotState.SlotStateManager;
import model.workspace.Presentation;
import model.workspace.Slide;
import observer.ISubscriber;
import view.MainFrame;
import view.SlotActionBar;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PresentationView extends JPanel implements ISubscriber{

    private String autorName;
    public JLabel autorLbl;
    private JPanel boxPanel;
    private Presentation presentation;
    private List<RuNode> children;
    private String url;
    private String presentationName;
    private JPanel navigatorPanel;
    private SlotActionBar slotActionBar;
    private PresentationStateManager presentationStateManager;
    private SlotStateManager slotStateManager;
    private SlotState slotState;

    public PresentationView(Presentation presentation) {
        presentationStateManager = new PresentationStateManager();
        slotStateManager = new SlotStateManager();
        slotState = slotStateManager.getSelectSlotState();
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
        slotActionBar = new SlotActionBar();

        navigatorPanel = new JPanel();
        navigatorPanel.setLayout(new BoxLayout(navigatorPanel, BoxLayout.Y_AXIS));

        for(RuNode ruNode : children) {
            SlideView slideView = new SlideView((Slide) ruNode, url);
            boxPanel.add(slideView);
            boxPanel.add((Box.createRigidArea(new Dimension(0, 50))));
        }

        for(int i = 0; i < boxPanel.getComponentCount(); i++) {
            if(boxPanel.getComponent(i) instanceof SlideView) {
                SlideView slideView = new SlideView(((SlideView) boxPanel.getComponent(i)).getSlide(), url);
                slideView.setPreferredSize(new Dimension(90, 70));
                slideView.setMinimumSize(new Dimension(90, 70));
                slideView.setMaximumSize(new Dimension(90, 70));
                navigatorPanel.add(slideView);
                navigatorPanel.add((Box.createRigidArea(new Dimension(0, 10))));
                navigatorPanel.revalidate();
                navigatorPanel.repaint();
            }
        }



        JScrollPane scrollPaneRight = new JScrollPane();
        JScrollPane scrollPaneLeft = new JScrollPane();
        scrollPaneLeft.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneLeft.setPreferredSize(new Dimension(150, 0));
        scrollPaneRight.setViewportView(boxPanel);
        scrollPaneLeft.setViewportView(navigatorPanel);
        this.add(scrollPaneRight, BorderLayout.CENTER);
        this.add(scrollPaneLeft, BorderLayout.WEST);
        this.add(slotActionBar, BorderLayout.EAST);
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

    public JLabel getAutorLbl() {
        return autorLbl;
    }

    public void setAutorLbl(JLabel autorLbl) {
        this.autorLbl = autorLbl;
    }

    public JPanel getBoxPanel() {
        return boxPanel;
    }

    public void setBoxPanel(JPanel boxPanel) {
        this.boxPanel = boxPanel;
    }

    public String getPresentationName() {
        return presentationName;
    }

    public void setPresentationName(String presentationName) {
        this.presentationName = presentationName;
    }

    public JPanel getNavigatorPanel() {
        return navigatorPanel;
    }

    public void setNavigatorPanel(JPanel navigatorPanel) {
        this.navigatorPanel = navigatorPanel;
    }

    public void setEditState() {
        this.presentationStateManager.setEditState();
        radnja();
    }

    public void setViewState() {
        this.presentationStateManager.setViewState();
        radnja();
    }

    public void radnja() {
        this.presentationStateManager.getCurrentState().changeState(getPresentation());
    }

    public SlotActionBar getSlotActionBar() {
        return slotActionBar;
    }

    public void setSlotActionBar(SlotActionBar slotActionBar) {
        this.slotActionBar = slotActionBar;
    }

    public PresentationStateManager getPresentationStateManager() {
        return presentationStateManager;
    }

    public void setPresentationStateManager(PresentationStateManager presentationStateManager) {
        this.presentationStateManager = presentationStateManager;
    }

    public SlotStateManager getSlotStateManager() {
        return slotStateManager;
    }

    public void setSlotStateManager(SlotStateManager slotStateManager) {
        this.slotStateManager = slotStateManager;
    }

    /*public void setAddSlotState() {
        this.slotStateManager.setAddSlotState();

    }*/

    /*public void setDeleteSlotState() {
        this.slotStateManager.setDeleteSlotState();
    }

    public void setSelectSlotState() {
        this.slotStateManager.setSelectSlotState();
    }*/

   /* public void doAddActionSlot() {
        this.slotStateManager.
    }*/

    public SlotState getSlotState() {
        return slotState;
    }

    public void setSlotState(SlotState slotState) {
        this.slotState = slotState;
    }

    @Override
    public void update(Object notification) {
        Presentation p = (Presentation) notification;

        if(p.getParent() == null) {
            System.out.println(this.getParent());
            JTabbedPane tabbedPane1 = (JTabbedPane) this.getParent();
            if(tabbedPane1 == null) {
                return;
            }
            tabbedPane1.remove(this);
            tabbedPane1.revalidate();
            tabbedPane1.repaint();
            return;
        }

        if(!(this.presentationName.equals(p.getName()))) {
            if(this.getParent() instanceof JTabbedPane) {
                JTabbedPane tabbedPane = (JTabbedPane) this.getParent();
                for (int i = 0; i < tabbedPane.getComponentCount(); i++) {
                    if (tabbedPane.getTitleAt(i).equals(this.presentationName)) {
                        tabbedPane.setTitleAt(i, p.getName());
                        tabbedPane.revalidate();
                        tabbedPane.repaint();
                    }
                }
                this.presentationName = p.getName();
                return;
            }
        }

        if(!(this.getUrl().equals(p.getURL()))) {
            this.url = p.getURL();
            for(int i = 0; i < boxPanel.getComponentCount(); i++) {
                if(boxPanel.getComponent(i) instanceof SlideView) {
                    ((SlideView)boxPanel.getComponent(i)).setUrl(this.url);
                    (boxPanel.getComponent(i)).revalidate();
                    (boxPanel.getComponent(i)).repaint();
                }

                if(navigatorPanel.getComponent(i) instanceof SlideView) {
                    ((SlideView)navigatorPanel.getComponent(i)).setUrl(this.url);
                    (navigatorPanel.getComponent(i)).revalidate();
                    (navigatorPanel.getComponent(i)).repaint();
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
                SlideView slideView = new SlideView(mySlide, p.getURL());
                slideView.setPreferredSize(new Dimension(90, 70));
                slideView.setMinimumSize(new Dimension(90, 70));
                slideView.setMaximumSize(new Dimension(90, 70));
                navigatorPanel.add(slideView);
                navigatorPanel.add(Box.createVerticalStrut(10));
                navigatorPanel.revalidate();
                navigatorPanel.repaint();
                this.revalidate();
                this.repaint();

            }
            Slide mySlide2 = (Slide) p.getNodeChildren().get(p.getNodeChildren().size()-1);
            SlideView lastSlideView;
            try {
                if((boxPanel.getComponentCount() - 2) < 0)
                    return;
                 lastSlideView = (SlideView) boxPanel.getComponent(boxPanel.getComponentCount() - 2);
            }catch (ClassCastException e){
                lastSlideView = (SlideView)navigatorPanel.getComponent(navigatorPanel.getComponentCount()-2);
            }
            Slide lastSlide = lastSlideView.getSlide();
            if (!(lastSlide.equals(mySlide2))) {
                boxPanel.add(new SlideView(mySlide2, p.getURL()));
                boxPanel.add(Box.createRigidArea(new Dimension(0, 50)));
                boxPanel.revalidate();
                boxPanel.repaint();
                SlideView slideView = new SlideView(mySlide, p.getURL());
                slideView.setPreferredSize(new Dimension(90, 70));
                slideView.setMinimumSize(new Dimension(90, 70));
                slideView.setMaximumSize(new Dimension(90, 70));
                navigatorPanel.add(slideView);
                navigatorPanel.add(Box.createVerticalStrut(10));
                navigatorPanel.revalidate();
                navigatorPanel.repaint();
                this.revalidate();
                this.repaint();
            }

        }

    }
}
