package view.dialogs;

import model.nodes.RuNode;
import model.workspace.Presentation;
import model.workspace.Project;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class AddNewPresentationDialog extends JDialog {

    private String url;

    public AddNewPresentationDialog(JFrame parent, RuNode node) {
        setTitle("Add Autor and picture");
        JLabel nazivLbl = new JLabel("Naziv:");
        JLabel autorLbl = new JLabel("Autor:");
        JLabel slikaLbl = new JLabel("Slika:");

        JTextField nazivTF = new JTextField();
        JTextField autorTF = new JTextField();
        JTextField slikaTF = new JTextField();

        JButton btnBrowse = new JButton("Browse");
        JButton btnAdd = new JButton("Add");
        JButton btnClose = new JButton("Close");

        Dimension dim = new Dimension(150, 20);
        nazivTF.setPreferredSize(dim);
        autorTF.setPreferredSize(dim);
        slikaTF.setPreferredSize(dim);
        btnBrowse.setPreferredSize(new Dimension(80,20));

        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));

        JPanel panelTop = new JPanel();
        panelTop.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelTop.add(nazivLbl);
        panelTop.add(nazivTF);

        JPanel panelMid = new JPanel();
        panelMid.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelMid.add(autorLbl);
        panelMid.add(autorTF);

        JPanel panelBot = new JPanel();
        panelBot.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelBot.add(slikaLbl);
        panelBot.add(slikaTF);
        panelBot.add(btnBrowse);

        JPanel panelBtns = new JPanel();
        panelBtns.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelBtns.add(btnAdd);
        panelBtns.add(btnClose);

        panelCenter.add(panelTop);
        panelCenter.add(panelMid);
        panelCenter.add(panelBot);
        panelCenter.add(panelBtns);

        btnBrowse.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int value = fileChooser.showOpenDialog(fileChooser);
            if(value == JFileChooser.APPROVE_OPTION) {
                File f = fileChooser.getSelectedFile();
                slikaTF.setText(f.getPath());
                url = f.getPath();
                System.out.println(url);
            }
        });

        btnAdd.addActionListener(e -> {
            String autor = autorTF.getText();
            String naziv = nazivTF.getText();
            ((Project)node).add(new Presentation(naziv, (Project)node, autor, url));

           dispose();
        });

        btnClose.addActionListener(e -> dispose());
        this.add(panelCenter);

        this.setTitle("Add new presentation");
        this.setSize(300,200);
        this.setLocationRelativeTo(parent);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setModal(true);
        this.setVisible(true);
    }
}
