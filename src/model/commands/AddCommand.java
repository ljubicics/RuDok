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
import java.util.ArrayList;

public class AddCommand extends AbstractCommand{
    private RuNode parent;
    private RuNode selektovani;
    private MyTreeNode dete;
    private ArrayList<Slot> slots = new ArrayList<>();

    public AddCommand(RuNode selektovani) {
        this.selektovani = selektovani;
        this.parent = selektovani.getParent();

    }

    @Override
    public void doCommand() {
        if(dete == null) {
            FactoryGenerator fg = new FactoryGenerator(selektovani);
            AbstractNodeFactory anf = fg.returnNodeFactory(selektovani);
            dete = new MyTreeNode(anf.getNFT(selektovani));
            if (dete.getN() instanceof Slide) {
                ((Slide) dete.getN()).getSlotArrayList().addAll(this.slots);
            }
            ((RuNodeComposite) selektovani).add(dete.getN());
        } else {
            ((RuNodeComposite) selektovani).add(dete.getN());

        }
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
        MainFrame.getInstance().getMyTree().expandPath(MainFrame.getInstance().getMyTree().getSelectionPath());
    }

    @Override
    public void undoCommand() {
        ((RuNodeComposite)selektovani).removeChild(dete.getN());
        if (dete.getN() instanceof Slide){
            for (Slot s : ((Slide) dete.getN()).getSlotArrayList()){
                slots.add(s);
            }
        }
        if(dete.getN() instanceof Presentation && ((Presentation) dete.getN()).isShared()) {
            System.out.println("ULAYIII");
            for(int i = 0; i < MainFrame.getInstance().getMyTree().getModel().getChildCount(MainFrame.getInstance().getMyTree().getModel().getRoot()); i++) {
                MyTreeNode myTreeNode = (MyTreeNode) MainFrame.getInstance().getMyTree().getModel().getChild(MainFrame.getInstance().getMyTree().getModel().getRoot(), i);
                RuNodeComposite projectComposite = (RuNodeComposite) myTreeNode.getN();
                for(int j = 0; j < projectComposite.getNodeChildren().size(); j++) {
                    RuNodeComposite ruNodeComposite = (RuNodeComposite) projectComposite.getChildAt(j);
                    if (ruNodeComposite.getName().equals(dete.getN().getName())) {
                        projectComposite.removeChild(ruNodeComposite);
                    }
                }
            }
        }
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
    }
}
