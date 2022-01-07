package model.state.slotState;

import java.io.Serializable;

public class SlotStateManager implements Serializable {
    private AddSlotState addSlotState;
    private DeleteSlotState deleteSlotState;
    private SelectSlotState selectSlotState;


    public SlotStateManager() {
        initialise();
    }

    public void initialise() {
        addSlotState = new AddSlotState();
        deleteSlotState = new DeleteSlotState();
        selectSlotState = new SelectSlotState();
    }

    public AddSlotState getAddSlotState() {
        return addSlotState;
    }

    public void setAddSlotState(AddSlotState addSlotState) {
        this.addSlotState = addSlotState;
    }

    public DeleteSlotState getDeleteSlotState() {
        return deleteSlotState;
    }

    public void setDeleteSlotState(DeleteSlotState deleteSlotState) {
        this.deleteSlotState = deleteSlotState;
    }

    public SelectSlotState getSelectSlotState() {
        return selectSlotState;
    }

    public void setSelectSlotState(SelectSlotState selectSlotState) {
        this.selectSlotState = selectSlotState;
    }
}
