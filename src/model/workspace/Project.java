package model.workspace;

import model.nodes.RuNodeComposite;
import view.MainFrame;

import javax.swing.*;
import java.io.File;
import java.io.Serializable;

public class Project extends RuNodeComposite implements Serializable {

    private File projectFile;
    private transient boolean changed;

    public Project(String name, RuNodeComposite parent) {
        super(name, parent);
        this.projectFile = null;
    }

    public void setChanged(boolean changed) {
        if (this.changed!=changed){
            this.changed=changed;
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
        }
    }

    public boolean isChanged() {
        return changed;
    }

    public File getProjectFile() {
        return projectFile;
    }


    public void setProjectFile(File projectFile) {
        this.projectFile = projectFile;
    }

}