package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewAction extends AbstractRudokAction{

    public NewAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F10, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("images\\new.png"));
        putValue(NAME, "New");
        putValue(SHORT_DESCRIPTION, "New");
    }

    public void actionPerformed(ActionEvent e) {

    }
}
