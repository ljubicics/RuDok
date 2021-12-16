package controller;

import model.factory.AbstractNodeFactory;
import model.factory.FactoryGenerator;
import model.nodes.RuNodeComposite;
import model.workspace.Slide;
import observer.ErrorFactory;
import view.MainFrame;

import view.tree.model.MyTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewAction extends AbstractRudokAction{

    public NewAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F10, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("icons/new.png"));
        putValue(NAME, "New");
        putValue(SHORT_DESCRIPTION, "New");
    }

    public void actionPerformed(ActionEvent e) {
        MyTreeNode o = (MyTreeNode) MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
        if(o == null || o.getN() instanceof Slide){
            ErrorFactory.getInstance().generateError("Greska pri dodavanju ", "Niste selektovali objekat na koji zelite da dodate", "Izaberite objekat i pokusajte ponovo", 0);
            return;
        }
        FactoryGenerator fg = new FactoryGenerator(o.getN());
        AbstractNodeFactory anf = fg.returnNodeFactory(o.getN());
        MyTreeNode mtn = new MyTreeNode(anf.getNFT(o.getN()));
        ((RuNodeComposite)o.getN()).add(mtn.getN());
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
        /*if(o == null) {
            ErrorFactory.getInstance().generateError("Greska pri dodavanju ", "Niste selektovali objekat na koji zelite da dodate", "Izaberite objekat i pokusajte ponovo", 0);
            return;
        }
        RuNode node = o.getN();
        if(node instanceof Workspace) {
            System.out.println(((Workspace) node).getNodeChildren().isEmpty());
            Project p = new Project("Projekat " + (((Workspace) node).getNodeChildren().size()+1), (Workspace) node);
            ((Workspace) node).addChild(p);
            System.out.println(((Workspace) node).getNodeChildren().isEmpty());
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
        }
        if(node instanceof Project) {
            new AddNewPresentationDialog(MainFrame.getInstance(), node);
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
        }
        if(node instanceof Presentation) {
            Slide s = new Slide("Slide " + (((Presentation)node).getNodeChildren().size()+1), node);
            ((Presentation) node).add(s);
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
       }
        if(node instanceof Slide) {
            ErrorFactory.getInstance().generateError("Greska pri dodavanju ", "Ne mozete dodati objekat na slide", "Izaberite drugi objekat i pokusajte ponovo", 0);
            return;
        }*/
    }
}
