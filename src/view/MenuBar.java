package view;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    public MenuBar() {
        JMenu mFile = new JMenu("File");
        mFile.add(MainFrame.getInstance().getActionManager().getNewAction());
        mFile.addSeparator();
        mFile.add(MainFrame.getInstance().getActionManager().getEditAction());

        JMenu mHelp = new JMenu("Help");
        mHelp.add(MainFrame.getInstance().getActionManager().getInfoAction());
        this.add(mFile);
        this.add(mHelp);
    }
}
