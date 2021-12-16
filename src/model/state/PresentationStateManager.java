package model.state;

public class PresentationStateManager {
    private EditState editState;
    private ViewState viewState;
    private PresentationState currentState;

    public PresentationStateManager() {
        initialiseStateManager();
    }

    public void initialiseStateManager() {
        editState = new EditState();
        viewState = new ViewState();
        currentState = editState;
    }

    public PresentationState getCurrentState() {
        return currentState;
    }

    public void setEditState() {
        currentState = editState;
    }

    public void setViewState() {
        currentState = viewState;
    }

}
