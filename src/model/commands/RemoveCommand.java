package model.commands;

import model.factory.AbstractNodeFactory;
import model.factory.FactoryGenerator;
import model.nodes.RuNode;
import model.nodes.RuNodeComposite;
import view.MainFrame;
import view.tree.model.MyTreeNode;

import javax.swing.*;

public class RemoveCommand extends AbstractCommand{
    private RuNode node;
    private RuNode parent;
    private MyTreeNode selektovani;

    public RemoveCommand(MyTreeNode selektovani, RuNode node) {
        this.selektovani = selektovani;
        this.node = node;
        this.parent = node.getParent();
    }

    @Override
    public void doCommand() {
        ((RuNodeComposite)parent).removeChild(node);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
    }

    @Override
    public void undoCommand() {
        FactoryGenerator fg = new FactoryGenerator(parent);
        AbstractNodeFactory anf = fg.returnNodeFactory(parent);
        MyTreeNode mtn = new MyTreeNode(anf.getNFT(parent));
        ((RuNodeComposite)parent).add(mtn.getN());
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
    }
}
