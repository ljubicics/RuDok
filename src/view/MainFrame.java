package view;

import controller.ActionManager;
import model.workspace.Project;
import model.workspace.Workspace;
import view.tree.model.MyTreeModel;
import view.tree.model.MyTreeNode;
import view.tree.view.MyTree;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private static MainFrame instance = null;
    private ActionManager actionManager;
    private MenuBar menuBar;
    private ToolBar toolBar;
    private MyTree myTree;
    private MyTreeModel myModel;

    private MainFrame() {

    }

    private void initialise() {
        this.actionManager = new ActionManager();
        initialiseTree();

        initialiseGUI();
    }

    private void initialiseGUI() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setSize((int) (screenWidth/1.2), (int) (screenHeight/1.2));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("RuDok");

        menuBar = new MenuBar();
        setJMenuBar(menuBar);
        toolBar = new ToolBar();
        add(toolBar, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(myTree ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JPanel panelRight = new JPanel();
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, panelRight);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(150);
        Dimension minSize = new Dimension(150,50);
        scrollPane.setMinimumSize(minSize);
        panelRight.setMinimumSize(minSize);
        add(splitPane);

    }

    private void initialiseTree(){
        Workspace w = new Workspace("Workspace", null);
        MyTreeNode node = new MyTreeNode(w);
        myModel = new MyTreeModel(node);
        myTree = new MyTree();
        myTree.setModel(myModel);
    }

    public static MainFrame getInstance() {
        if(instance == null) {
            instance = new MainFrame();
            instance.initialise();
        }
        return instance;
    }

    public static void setInstance(MainFrame instance) {
        MainFrame.instance = instance;
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

    public void setActionManager(ActionManager actionManager) {
        this.actionManager = actionManager;
    }

    public MyTree getMyTree() {
        return myTree;
    }

    public void setMyTree(MyTree myTree) {
        this.myTree = myTree;
    }

    public MyTreeModel getMyModel() {
        return myModel;
    }

    public void setMyModel(MyTreeModel myModel) {
        this.myModel = myModel;
    }
}
