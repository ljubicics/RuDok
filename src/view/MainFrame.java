package view;

import controller.ActionManager;
import controller.DoubleClickProjectController;
import model.commands.CommandManager;
import model.workspace.Workspace;
import observer.ISubscriber;
import observer.MyError;
import view.tree.model.MyTreeModel;
import view.tree.model.MyTreeNode;
import view.tree.view.MyTree;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements ISubscriber {
    private static MainFrame instance = null;
    private ActionManager actionManager;
    private JMenuBar menuBar;
    private JToolBar toolBar;
    private JToolBar slideShowToolBar;
    private MyTree myTree;
    private MyTreeModel myModel;
    private JSplitPane splitPaneSaver;
    private CommandManager commandManager;

    private MainFrame() {

    }

    private void initialise() {
        this.actionManager = new ActionManager();
        this.commandManager = new CommandManager();
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
        this.splitPaneSaver = splitPane;
    }

    private void initialiseTree(){
        Workspace w = new Workspace("Workspace", null);
        MyTreeNode node = new MyTreeNode(w);
        myModel = new MyTreeModel(node);
        myTree = new MyTree();
        myTree.setModel(myModel);
        new DoubleClickProjectController(myTree);
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

    public JSplitPane getSplitPaneSaver() {
        return splitPaneSaver;
    }

    public void setSplitPaneSaver(JSplitPane splitPaneSaver) {
        this.splitPaneSaver = splitPaneSaver;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public JMenuBar getMyMenuBar() {
        return menuBar;
    }

    public void setToolBar(ToolBar toolBar) {
        this.toolBar = toolBar;
    }

    public JToolBar getToolBar() {
        return toolBar;
    }

    public void reloadTree() {
        myModel.reload();
        for(int i = 0; i < myTree.getRowCount(); i++) {
            myTree.expandRow(i);
        }
    }

    public JToolBar getSlideShowToolBar() {
        return slideShowToolBar;
    }

    public void setSlideShowToolBar(JToolBar slideShowToolBar) {
        this.slideShowToolBar = slideShowToolBar;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public void setCommandManager(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    @Override
    public void update(Object notification) {
        MyError myError = (MyError) notification;
        JOptionPane.showMessageDialog(new JDialog(this), myError.getText() + "\n" + myError.getSolution(), myError.getTitle(), myError.getType());
    }
}
