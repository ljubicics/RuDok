package model.workspace;

import model.nodes.RuNode;
import model.nodes.RuNodeComposite;


public class Presentation extends RuNodeComposite {

    private String autor;
    private String url;

    public Presentation(String name, RuNodeComposite parent, String autor, String url) {
        super(name, parent);
        this.autor = autor;
        this.url = url;
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

    public String getURL() {
        return url;
    }

    public void setURL(String url) {
        this.url = url;
    }
}
