package controller;

public class ActionManager {
    private InfoAction infoAction;
    private NewAction newAction;
    private DeleteAction deleteAction;
    private EditAction editAction;

    public ActionManager() {
        initialiseActions();
    }

    public void initialiseActions() {
        infoAction = new InfoAction();
        newAction = new NewAction();
        deleteAction = new DeleteAction();
        editAction = new EditAction();
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
}
