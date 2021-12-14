package model.workspace.slotWorkspace;

import java.awt.*;

public class Slot {
    private Point position;
    private int width;
    private int height;
    private Color color;
    private Stroke stroke;

    public Slot(Point position, int width, int height, Color color, Stroke stroke) {
        this.position = position;
        this.width = width;
        this.height = height;
        this.color = color;
        this.stroke = new BasicStroke(3f);
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Stroke getStroke() {
        return stroke;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }


}