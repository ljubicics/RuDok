package view.tree.view;

import model.workspace.slotWorkspace.Slot;

import java.awt.*;
import java.io.Serializable;

public class SlotView implements Serializable{
    public Slot slot;
    private Shape shape;

    public SlotView(Slot slot) {
        this.slot = slot;
        shape = new Rectangle((int)slot.getPosition().getX(), (int)slot.getPosition().getY(), slot.getWidth(), slot.getHeight());
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.setPaint(Color.BLACK);
        g.setStroke(slot.getStroke());
        g.draw(shape);
        g.setPaint(slot.getColor());
        g.fill(shape);
    }
}
