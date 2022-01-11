package model.commands;

import model.factory.AbstractNodeFactory;
import model.factory.FactoryGenerator;
import model.nodes.RuNode;
import model.nodes.RuNodeComposite;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Slide;
import model.workspace.slotWorkspace.Slot;
import view.MainFrame;
import view.tree.model.MyTreeNode;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RemoveCommand extends AbstractCommand{
    private RuNode node;
    private RuNode parent;
    private ArrayList<Slot> slots = new ArrayList<>();
    private ArrayList<Project> sharedPresentations = new ArrayList<>();

    public RemoveCommand(RuNode node) {
        this.node = node;
        this.parent = node.getParent();
        if (node instanceof Slide) {
            for (Slot s : ((Slide) node).getSlotArrayList()) {
                System.out.println("Punim slotove");
                slots.add(s);
            }
        }
        if(node instanceof Presentation) {
            for (int i = 0; i < MainFrame.getInstance().getMyTree().getModel().getChildCount(MainFrame.getInstance().getMyTree().getModel().getRoot()); i++) {
                MyTreeNode myTreeNode = (MyTreeNode) MainFrame.getInstance().getMyTree().getModel().getChild(MainFrame.getInstance().getMyTree().getModel().getRoot(), i);
                RuNodeComposite projectComposite = (RuNodeComposite) myTreeNode.getN();
                if (projectComposite.getNodeChildren().contains(node) && !(projectComposite.equals(parent))) {
                    this.sharedPresentations.add((Project) projectComposite);
                }
            }
        }
    }

    @Override
    public void doCommand() {
        ((RuNodeComposite)parent).removeChild(node);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
        if (node instanceof Project){;
            MainFrame.getInstance().getSplitPaneSaver().setRightComponent(new JPanel());
            MainFrame.getInstance().setJMenuBar(MainFrame.getInstance().getMyMenuBar());
            MainFrame.getInstance().add(MainFrame.getInstance().getToolBar(), BorderLayout.NORTH);
            MainFrame.getInstance().revalidate();
            MainFrame.getInstance().repaint();
        }
        if(node instanceof Presentation && ((Presentation) node).isShared()) {
            System.out.println("ULAZI");
            for(int i = 0; i < MainFrame.getInstance().getMyTree().getModel().getChildCount(MainFrame.getInstance().getMyTree().getModel().getRoot()); i++) {
                MyTreeNode myTreeNode = (MyTreeNode) MainFrame.getInstance().getMyTree().getModel().getChild(MainFrame.getInstance().getMyTree().getModel().getRoot(), i);
                RuNodeComposite projectComposite = (RuNodeComposite) myTreeNode.getN();
                for(int j = 0; j < projectComposite.getNodeChildren().size(); j++) {
                    RuNodeComposite ruNodeComposite = (RuNodeComposite) projectComposite.getChildAt(j);
                    if (ruNodeComposite.getName().equals(node.getName())) {
                        projectComposite.removeChild(ruNodeComposite);
                    }
                }
            }
        }
    }

    @Override
    public void undoCommand() {
        if (node instanceof Slide){
            ((Slide)node).getSlotArrayList().addAll(this.slots);
        }
        if(node instanceof Presentation) {
            for(int i = 0; i < sharedPresentations.size(); i++) {
                sharedPresentations.get(i).add(node);
            }
        }
        ((RuNodeComposite)parent).add(node);
        node.setParent(parent);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
    }
}
