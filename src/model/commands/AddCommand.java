package model.commands;

import model.factory.AbstractNodeFactory;
import model.factory.FactoryGenerator;
import model.nodes.RuNode;
import model.nodes.RuNodeComposite;
import model.workspace.Slide;
import model.workspace.slotWorkspace.Slot;
import view.MainFrame;
import view.tree.model.MyTreeNode;

import javax.swing.*;
import java.util.ArrayList;

public class AddCommand extends AbstractCommand{
    private RuNode node;
    private MyTreeNode dete;
    private MyTreeNode selektovani;
    private ArrayList<Slot> slots = new ArrayList<>();

    public AddCommand(MyTreeNode selektovani, RuNode node) {
        this.selektovani = selektovani;
        this.node = node;
    }

    @Override
    public void doCommand() {
        FactoryGenerator fg = new FactoryGenerator(selektovani.getN());
        AbstractNodeFactory anf = fg.returnNodeFactory(selektovani.getN());
        dete = new MyTreeNode(anf.getNFT(selektovani.getN()));
        if (dete.getN() instanceof Slide){
            ((Slide)dete.getN()).getSlotArrayList().addAll(this.slots);
            System.out.println("Vracam slotove na slajd");
        }
        ((RuNodeComposite)selektovani.getN()).add(dete.getN());
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
        MainFrame.getInstance().getMyTree().expandPath(MainFrame.getInstance().getMyTree().getSelectionPath());
    }

    @Override
    public void undoCommand() {
        ((RuNodeComposite)node).removeChild(dete.getN());
        if (dete.getN() instanceof Slide){
            for (Slot s : ((Slide) dete.getN()).getSlotArrayList()){
                slots.add(s);
            }
        }
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
    }
}
