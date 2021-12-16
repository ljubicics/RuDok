package model.workspace;

import model.nodes.RuNodeComposite;
import model.state.PresentationState;
import model.state.PresentationStateManager;
import model.state.slotState.SlotState;
import model.state.slotState.SlotStateManager;


public class Presentation extends RuNodeComposite {

    private String autor;
    private String url;
    private SlotState slotState;
    private SlotStateManager slotStateManager = new SlotStateManager();

    public Presentation(String name, RuNodeComposite parent, String autor, String url) {
        super(name, parent);
        this.autor = autor;
        this.url = url;
        this.slotState = slotStateManager.getSelectSlotState();
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


    public SlotState getSlotState() {
        return slotState;
    }

    public void setSlotState(SlotState slotState) {
        this.slotState = slotState;
    }

    public SlotStateManager getSlotStateManager() {
        return slotStateManager;
    }

    public void setSlotStateManager(SlotStateManager slotStateManager) {
        this.slotStateManager = slotStateManager;
    }
}
