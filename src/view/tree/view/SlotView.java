package view.tree.view;

import model.workspace.slotWorkspace.Slot;

import java.awt.*;

public class SlotView {
    public Slot slot;

    public SlotView(Slot slot) {
        this.slot = slot;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.setPaint(Color.BLACK);
        g.setStroke(slot.getStroke());
        g.draw(slot.getShape());
        g.setPaint(slot.getColor());
        System.out.println("Nacrtao");
        g.fill(slot.getShape());
    }
}
