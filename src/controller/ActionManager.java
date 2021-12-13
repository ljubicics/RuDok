package controller;

public class ActionManager {
    private InfoAction infoAction;
    private NewAction newAction;
    private DeleteAction deleteAction;
    private EditAction editAction;
    private SlideShowAction slideShowAction;
    private AddNewSlotAction addNewSlotAction;
    private DeleteSlotAction deleteSlotAction;
    private SelectSlotAction selectSlotAction;
    private SlotColourAction slotColourAction;
    private SlotStrokeAction slotStrokeAction;

    public ActionManager() {
        initialiseActions();
    }

    public void initialiseActions() {
        infoAction = new InfoAction();
        newAction = new NewAction();
        deleteAction = new DeleteAction();
        editAction = new EditAction();
        slideShowAction = new SlideShowAction();
        addNewSlotAction = new AddNewSlotAction();
        deleteSlotAction = new DeleteSlotAction();
        selectSlotAction = new SelectSlotAction();
        slotColourAction = new SlotColourAction();
        slotStrokeAction = new SlotStrokeAction();
    }

    public InfoAction getInfoAction() {
        return infoAction;
    }

    public void setInfoAction(InfoAction infoAction) {
        this.infoAction = infoAction;
    }

    public NewAction getNewAction() {
        return newAction;
    }

    public void setNewAction(NewAction newAction) {
        this.newAction = newAction;
    }

    public DeleteAction getDeleteAction() {
        return deleteAction;
    }

    public void setDeleteAction(DeleteAction deleteAction) {
        this.deleteAction = deleteAction;
    }

    public EditAction getEditAction() {
        return editAction;
    }

    public void setEditAction(EditAction editAction) {
        this.editAction = editAction;
    }

    public SlideShowAction getSlideShowAction() {
        return slideShowAction;
    }

    public void setSlideShowAction(SlideShowAction slideShowAction) {
        this.slideShowAction = slideShowAction;
    }

    public AddNewSlotAction getAddNewSlotAction() {
        return addNewSlotAction;
    }

    public void setAddNewSlotAction(AddNewSlotAction addNewSlotAction) {
        this.addNewSlotAction = addNewSlotAction;
    }

    public DeleteSlotAction getDeleteSlotAction() {
        return deleteSlotAction;
    }

    public void setDeleteSlotAction(DeleteSlotAction deleteSlotAction) {
        this.deleteSlotAction = deleteSlotAction;
    }

    public SelectSlotAction getSelectSlotAction() {
        return selectSlotAction;
    }

    public void setSelectSlotAction(SelectSlotAction selectSlotAction) {
        this.selectSlotAction = selectSlotAction;
    }

    public SlotColourAction getSlotColourAction() {
        return slotColourAction;
    }

    public void setSlotColourAction(SlotColourAction slotColourAction) {
        this.slotColourAction = slotColourAction;
    }

    public SlotStrokeAction getSlotStrokeAction() {
        return slotStrokeAction;
    }

    public void setSlotStrokeAction(SlotStrokeAction slotStrokeAction) {
        this.slotStrokeAction = slotStrokeAction;
    }
}
