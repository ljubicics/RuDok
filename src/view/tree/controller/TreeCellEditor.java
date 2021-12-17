package view.tree.controller;

import model.nodes.RuNode;
import model.state.ViewState;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Slide;
import observer.ErrorFactory;
import view.MainFrame;
import view.tree.model.MyTreeNode;
import view.tree.view.PresentationView;
import view.tree.view.ProjectView;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class TreeCellEditor extends DefaultTreeCellEditor implements ActionListener {

    private Object stavka=null;
    private JTextField edit=null;

    public TreeCellEditor(JTree tree, DefaultTreeCellRenderer renderer) {
        super(tree, renderer);
    }

    public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4, int arg5) {

        stavka=arg1;
        edit=new JTextField(arg1.toString());
        edit.addActionListener(this);
        return edit;
    }

    public boolean isCellEditable(EventObject arg0) {
        if (arg0 instanceof MouseEvent)
            if (((MouseEvent)arg0).getClickCount()==3){
                return true;
            }
        return false;
    }

    public void actionPerformed(ActionEvent e) {
        MyTreeNode mtn = (MyTreeNode) stavka;
        RuNode n = mtn.getN();

        if(e.getActionCommand().equals("")) {
            ErrorFactory.getInstance().generateError("Greska pri brisanju ", "Workspace se ne moze obrisati", "Izaberite drugi objekat", 0);
            return;
        } else {
            if (n instanceof Project) {
                n.setName(e.getActionCommand());
                this.cancelCellEditing();
            } else if (n instanceof Presentation) {
                ProjectView projectView = (ProjectView) MainFrame.getInstance().getSplitPaneSaver().getRightComponent();
                JTabbedPane jTabbedPane = null;
                for(Component c : projectView.getComponents()) {
                    if(c instanceof JTabbedPane) {
                        jTabbedPane = (JTabbedPane) c;
                    }
                }
                if(!(jTabbedPane.getSelectedComponent() instanceof PresentationView)) {
                    ErrorFactory.getInstance().generateError("Greska pri promeni naziva prezentacije", "Prezentacija je u slide show rezimu rada", "Prebacite u edit rezim rada", 1);
                    this.cancelCellEditing();
                    return;
                }
                n.setName(e.getActionCommand());
                this.cancelCellEditing();
            } else if (n instanceof Slide) {
                n.setName(e.getActionCommand());
                this.cancelCellEditing();
            } else {
                n.setName(e.getActionCommand());
                this.cancelCellEditing();
            }
        }
    }
}
