package view;

import javax.swing.*;

public class SlotActionBar extends JToolBar {
    public SlotActionBar() {
        super(SwingConstants.VERTICAL);
        setFloatable(false);
        add(MainFrame.getInstance().getActionManager().getAddNewSlotAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getDeleteSlotAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getSelectSlotAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getSlotColourAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getSlotStrokeAction());
    }
}
