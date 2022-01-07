package model.workspace.slotWorkspace;

import controller.SerializableStrokeAdapter;

import java.awt.*;
import java.io.Serializable;

public class Slot implements Serializable {
    private Point position;
    private int width;
    private int height;
    private Color color;
    private SerializableStrokeAdapter stroke;

    public Slot(Point position, int width, int height, Color color, SerializableStrokeAdapter stroke) {
        this.position = position;
        this.width = width;
        this.height = height;
        this.color = color;
        this.stroke = stroke;
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

    public void setStroke(SerializableStrokeAdapter stroke) {
        this.stroke = stroke;
    }

    public SerializableStrokeAdapter getStroke() {
        return stroke;
    }
}
