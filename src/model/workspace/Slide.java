package model.workspace;

import model.nodes.RuNode;
import model.workspace.slotWorkspace.Slot;

import java.util.ArrayList;
import java.util.UUID;

public class Slide extends RuNode {

    private ArrayList<Slot> slotArrayList;
    private UUID uuid;

    public ArrayList<Slot> getSlotArrayList() {
        return slotArrayList;
    }

    public void setSlotArrayList(ArrayList<Slot> slotArrayList) {
        this.slotArrayList = slotArrayList;
    }

    public Slide(String name, RuNode parent) {
        super(name, parent);
        uuid = UUID. randomUUID();
        slotArrayList = new ArrayList<>();
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
