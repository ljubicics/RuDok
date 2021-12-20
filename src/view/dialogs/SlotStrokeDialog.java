package view.dialogs;

import observer.ErrorFactory;
import view.MainFrame;
import view.tree.view.PresentationView;
import view.tree.view.ProjectView;

import javax.swing.*;
import java.awt.*;

public class SlotStrokeDialog extends JDialog {
    private JPanel buttonsPanel;
    private JPanel radBtnPanel;
    private JButton okBtn;
    private JButton cancelBtn;
    private JRadioButton isprekidanaRadBtn;
    private JRadioButton punaRadBtn;
    private ButtonGroup btnGroup;
    private JSlider widthSlider;
    private float width;
    private PresentationView presentationView;

    public SlotStrokeDialog(ProjectView projectView) {
        this.buttonsPanel = new JPanel();
        this.radBtnPanel = new JPanel();
        this.okBtn = new JButton("Ok");
        this.cancelBtn = new JButton("Cancel");
        this.isprekidanaRadBtn = new JRadioButton("Isprekidana linija");
        this.punaRadBtn = new JRadioButton("Puna linija");
        this.btnGroup = new ButtonGroup();
        this.presentationView = (PresentationView) projectView.getTabbedPane().getSelectedComponent();
        this.setTitle("Promenite tip stroke-a");
        this.setSize(new Dimension(400, 200));
        this.setModal(true);
        this.setLocationRelativeTo(MainFrame.getInstance().getSplitPaneSaver().getRightComponent());
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        widthSlider = new JSlider(0,0,10,1);
        widthSlider.setMajorTickSpacing(1);
        widthSlider.setMinorTickSpacing(1);
        widthSlider.setPaintTicks(true);
        widthSlider.setPaintLabels(true);
        btnGroup.add(isprekidanaRadBtn);
        btnGroup.add(punaRadBtn);
        buttonsPanel.add(okBtn);
        buttonsPanel.add(cancelBtn);
        radBtnPanel.setLayout(new GridLayout());
        radBtnPanel.add(punaRadBtn);
        radBtnPanel.add(isprekidanaRadBtn);
        this.add(widthSlider, BorderLayout.NORTH);
        this.add(radBtnPanel, BorderLayout.CENTER);
        this.add(buttonsPanel, BorderLayout.SOUTH);



        okBtn.addActionListener(e -> {
            width = (float) widthSlider.getValue();
            if(!(punaRadBtn.isSelected()) && !(isprekidanaRadBtn.isSelected())) {
                ErrorFactory.getInstance().generateError("Greska pri odabiru linije", "Greska pri odabiru vrste linije", "Selektujte vrstu linije", 0);
                return;
            }


                if(punaRadBtn.isSelected()) {
                    presentationView.getSlotStateManager().getAddSlotState().setStrokeSlota(new BasicStroke(width));
                } else {
                    presentationView.getSlotStateManager().getAddSlotState().setStrokeSlota(new BasicStroke(width, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 2.0f, new float[]{3.0f, 2.0f}, 0.0f));
                }
            dispose();
        });
        this.getRootPane().setDefaultButton(okBtn);
        this.pack();
        this.setVisible(true);
    }
}
