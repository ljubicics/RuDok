package model.commands;

import model.factory.AbstractNodeFactory;
import model.factory.FactoryGenerator;
import model.nodes.RuNode;
import model.nodes.RuNodeComposite;
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

    public RemoveCommand(RuNode node) {
        this.node = node;
        this.parent = node.getParent();
        if (node instanceof Slide) {
            for (Slot s : ((Slide) node).getSlotArrayList()) {
                System.out.println("Punim slotove");
                slots.add(s);
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
    }

    @Override
    public void undoCommand() {
        FactoryGenerator fg = new FactoryGenerator(parent);
        AbstractNodeFactory anf = fg.returnNodeFactory(parent);
        MyTreeNode mtn = new MyTreeNode(anf.getNFT(parent));
        if (mtn.getN() instanceof Slide){
            ((Slide)mtn.getN()).getSlotArrayList().addAll(this.slots);
        }
        ((RuNodeComposite)parent).add(mtn.getN());
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
    }
}
