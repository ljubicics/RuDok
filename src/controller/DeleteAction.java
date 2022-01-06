package controller;

import model.commands.RemoveCommand;
import model.nodes.RuNode;
import model.nodes.RuNodeComposite;
import model.workspace.Workspace;
import observer.ErrorFactory;
import view.MainFrame;
import view.tree.model.MyTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteAction extends AbstractRudokAction{

    public DeleteAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("icons/delete.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Deletes selected object");
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("delete");
        MyTreeNode o = (MyTreeNode) MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
        if(o == null) {
            ErrorFactory.getInstance().generateError("Greska pri dodavanju ", "Niste selektovali objekat na koji zelite da obrisete", "Izaberite objekat i pokusajte ponovo", 1);
            return;
        }
        RuNode node = o.getN();
        if(!(node instanceof Workspace)) {
            MainFrame.getInstance().getCommandManager().addCommand(new RemoveCommand(o.getN()));
            /*RuNodeComposite parent = (RuNodeComposite) node.getParent();
            parent.removeChild(node);
             */
         SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
        } else {
            ErrorFactory.getInstance().generateError("Greska pri brisanju ", "Workspace se ne moze obrisati", "Izaberite drugi objekat", 0);
            return;
        }
    }
}
