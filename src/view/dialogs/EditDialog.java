package view.dialogs;

import model.nodes.RuNode;
import model.workspace.Presentation;
import view.MainFrame;
import view.tree.model.MyTreeNode;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class EditDialog extends JDialog {

    private JLabel nazivLbl;
    private JLabel autorLbl;
    private JLabel slikaLbl;
    private JTextField nazivTF;
    private JTextField autorTF;
    private JTextField slikaTF;
    private JButton browseBtn;
    private JButton editBtn;
    private JButton cancelBtn;
    private String url;

    public EditDialog(JFrame parent, RuNode rn) {
        autorLbl = new JLabel("Autor: ");
        slikaLbl = new JLabel("Slika: ");
        autorTF = new JTextField();
        slikaTF = new JTextField();
        browseBtn = new JButton("Browse");
        editBtn = new JButton("Edit");
        cancelBtn = new JButton("Cancel");

        Dimension dim = new Dimension(150, 20);
        autorTF.setPreferredSize(dim);
        slikaTF.setPreferredSize(dim);
        browseBtn.setPreferredSize(new Dimension(80,20));

        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));

        JPanel panelTop = new JPanel();
        panelTop.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panelMid = new JPanel();
        panelMid.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelMid.add(autorLbl);
        panelMid.add(autorTF);

        JPanel panelBot = new JPanel();
        panelBot.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelBot.add(slikaLbl);
        panelBot.add(slikaTF);
        panelBot.add(browseBtn);

        JPanel panelBtns = new JPanel();
        panelBtns.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelBtns.add(editBtn);
        panelBtns.add(cancelBtn);

        panelCenter.add(panelTop);
        panelCenter.add(panelMid);
        panelCenter.add(panelBot);
        panelCenter.add(panelBtns);

        browseBtn.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int value = fileChooser.showOpenDialog(fileChooser);
            if(value == JFileChooser.APPROVE_OPTION) {
                File f = fileChooser.getSelectedFile();
                slikaTF.setText(f.getPath());
                url = f.getPath();
                System.out.println(url);
            }
        });

        editBtn.addActionListener(e -> {
            ((Presentation)rn).setAutor(autorTF.getText());
            ((Presentation)rn).setURL(url);
            dispose();
        });

        cancelBtn.addActionListener(e -> dispose());


        this.setSize(300,200);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.add(panelCenter);
        this.setModal(true);
        this.setLocationRelativeTo(parent);
        this.setVisible(true);


    }
}
