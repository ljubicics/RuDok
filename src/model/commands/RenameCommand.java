package model.commands;

import model.nodes.RuNode;
import view.MainFrame;

import javax.swing.*;

public class RenameCommand extends AbstractCommand{
    private String newName;
    private String oldName;
    private RuNode node;

    public RenameCommand(String newName, RuNode node) {
        this.newName = newName;
        this.node = node;
        this.oldName = node.getName();
    }

    @Override
    public void doCommand() {
        node.setName(newName);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
    }

    @Override
    public void undoCommand() {
        node.setName(oldName);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
    }
}
