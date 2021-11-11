package controller;

import model.nodes.RuNode;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Slide;
import model.workspace.Workspace;
import observer.ErrorFactory;
import view.MainFrame;
import view.dialogs.EditDialog;
import view.tree.model.MyTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class EditAction extends AbstractRudokAction{

    public EditAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F6, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("icons/edit.png"));
        putValue(NAME, "Edit");
        putValue(SHORT_DESCRIPTION, "Edit presentation");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        MyTreeNode mtn = (MyTreeNode) MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
        System.out.println(mtn);
        if(mtn == null) {
            ErrorFactory.getInstance().generateError("Greska pri dodavanju ", "Niste selektovali objekat na koji zelite da dodate", "Izaberite objekat i pokusajte ponovo", 1);
            return;
        }
        RuNode n = mtn.getN();
        if(n instanceof Workspace || n instanceof Project || n instanceof Slide) {
            ErrorFactory.getInstance().generateError("Greska pri dodavanju ", "Morate selektovati prezentaciju", "Izaberite objekat i pokusajte ponovo", 1);
            return;
        }
        if(n instanceof Presentation) {
            new EditDialog(MainFrame.getInstance(), n);
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
        }
    }
}
