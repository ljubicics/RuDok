package model.commands;

import model.factory.AbstractNodeFactory;
import model.factory.FactoryGenerator;
import model.nodes.RuNode;
import model.nodes.RuNodeComposite;
import view.MainFrame;
import view.tree.model.MyTreeNode;

import javax.swing.*;

public class AddCommand extends AbstractCommand{
    private RuNode node;
    private MyTreeNode dete;
    private MyTreeNode selektovani;
    //private int brojac = 0;

    public AddCommand(MyTreeNode selektovani, RuNode node) {
        this.selektovani = selektovani;
        this.node = node;
    }

    @Override
    public void doCommand() {
        //brojac++;
        FactoryGenerator fg = new FactoryGenerator(selektovani.getN());
        AbstractNodeFactory anf = fg.returnNodeFactory(selektovani.getN());
        dete = new MyTreeNode(anf.getNFT(selektovani.getN()));
        ((RuNodeComposite)selektovani.getN()).add(dete.getN());
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
        MainFrame.getInstance().getMyTree().expandPath(MainFrame.getInstance().getMyTree().getSelectionPath());
    }

    @Override
    public void undoCommand() {
       // brojac--;
        ((RuNodeComposite)node).removeChild(dete.getN());
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
    }
}
