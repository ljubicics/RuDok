package model.workspace;

import model.nodes.RuNode;
import model.nodes.RuNodeComposite;

import java.awt.*;

public class Presentation extends RuNodeComposite {

    private String autor;
    private Image img;

    public Presentation(String name, RuNodeComposite parent, String autor, Image img) {
        super(name, parent);
        this.autor = autor;
        this.img = img;
    }

    public void addChild(RuNode n) {
        if(n instanceof Slide)
            super.add(n);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
