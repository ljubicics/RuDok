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
    private RedoAction redoAction;
    private UndoAction undoAction;
    private SaveProjectAction saveProjectAction;
    private OpenProjectAction openProjectAction;
    private ShareAction shareAction;

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
        redoAction = new RedoAction();
        undoAction = new UndoAction();
        saveProjectAction = new SaveProjectAction();
        openProjectAction = new OpenProjectAction();
        shareAction = new ShareAction();
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

    public RedoAction getRedoAction() {
        return redoAction;
    }

    public void setRedoAction(RedoAction redoAction) {
        this.redoAction = redoAction;
    }

    public UndoAction getUndoAction() {
        return undoAction;
    }

    public void setUndoAction(UndoAction undoAction) {
        this.undoAction = undoAction;
    }

    public SaveProjectAction getSaveProjectAction() {
        return saveProjectAction;
    }

    public void setSaveProjectAction(SaveProjectAction saveProjectAction) {
        this.saveProjectAction = saveProjectAction;
    }

    public OpenProjectAction getOpenProjectAction() {
        return openProjectAction;
    }

    public void setOpenProjectAction(OpenProjectAction openProjectAction) {
        this.openProjectAction = openProjectAction;
    }

    public ShareAction getShareAction() {
        return shareAction;
    }

    public void setShareAction(ShareAction shareAction) {
        this.shareAction = shareAction;
    }
}
