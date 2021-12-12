package view;

import javax.swing.*;

public class SlideShowToolBar extends JToolBar {
    public SlideShowToolBar() {
        this.setFloatable(false);
        this.add(MainFrame.getInstance().getActionManager().getSlideShowAction());
        this.addSeparator();
    }
}
