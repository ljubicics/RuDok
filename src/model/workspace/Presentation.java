package model.workspace;

import model.nodes.RuNodeComposite;
import model.state.EditState;
import model.state.PresentationState;


public class Presentation extends RuNodeComposite {

    private String autor;
    private String url;
    private PresentationState presentationState;

    public Presentation(String name, RuNodeComposite parent, String autor, String url) {
        super(name, parent);
        this.autor = autor;
        this.url = url;
        this.presentationState = new EditState();
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

    public PresentationState getPresentationState() {
        return presentationState;
    }

    public void setPresentationState(PresentationState presentationState) {
        this.presentationState = presentationState;
        this.presentationState.changeState(this);
    }
}
