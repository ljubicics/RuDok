package model.workspace;

import model.nodes.RuNodeComposite;
import model.state.EditState;
import model.state.PresentationState;
import model.state.slotState.SelectSlotState;
import model.state.slotState.SlotState;


public class Presentation extends RuNodeComposite {

    private String autor;
    private String url;
    private PresentationState presentationState;
    private SlotState slotState;

    public Presentation(String name, RuNodeComposite parent, String autor, String url) {
        super(name, parent);
        this.autor = autor;
        this.url = url;
        this.presentationState = new EditState();
        this.slotState = new SelectSlotState();
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

    public SlotState getSlotState() {
        return slotState;
    }

    public void setSlotState(SlotState slotState) {
        this.slotState = slotState;
    }
}
