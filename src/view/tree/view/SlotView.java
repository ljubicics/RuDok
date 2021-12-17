package view.tree.view;

import model.workspace.slotWorkspace.Slot;

import java.awt.*;

public class SlotView {
    public Slot slot;
    private Shape shape;
    private Stroke stroke;

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
        System.out.println("Nacrtao");
        g.fill(shape);
    }
}
