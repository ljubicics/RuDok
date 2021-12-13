package model.workspace;

import model.nodes.RuNode;
import model.workspace.slotWorkspace.Slot;

import java.util.ArrayList;

public class Slide extends RuNode {

    private ArrayList<Slot> slotArrayList;

    public ArrayList<Slot> getSlotArrayList() {
        return slotArrayList;
    }

    public void setSlotArrayList(ArrayList<Slot> slotArrayList) {
        this.slotArrayList = slotArrayList;
    }

    public Slide(String name, RuNode parent) {
        super(name, parent);
        slotArrayList = new ArrayList<>();
    }


}
