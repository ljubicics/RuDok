package view;

import javax.swing.*;

public class ToolBar extends JToolBar {

    public ToolBar() {
        super(SwingConstants.HORIZONTAL);
        setFloatable(false);
        this.add(MainFrame.getInstance().getActionManager().getNewAction());
        this.addSeparator();
        this.add(MainFrame.getInstance().getActionManager().getInfoAction());
        this.addSeparator();
        this.add(MainFrame.getInstance().getActionManager().getDeleteAction());
        this.addSeparator();
        this.add(MainFrame.getInstance().getActionManager().getEditAction());
        this.addSeparator();
        this.add(MainFrame.getInstance().getActionManager().getSlideShowAction());

    }
}
