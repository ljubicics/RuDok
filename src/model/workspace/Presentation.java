package model.workspace;

import model.nodes.RuNodeComposite;

import java.io.Serializable;

public class Presentation extends RuNodeComposite implements Serializable {

    private String autor;
    private String url;

    public Presentation(String name, RuNodeComposite parent, String autor, String url) {
        super(name, parent);
        this.autor = autor;
        this.url = url;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
        notifySubscribers(this);
    }

    public String getURL() {
        return url;
    }

    public void setURL(String url) {
        this.url = url;
        notifySubscribers(this);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
