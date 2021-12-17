package view.tree.view;

import model.state.EditState;
import model.workspace.Presentation;
import model.workspace.Slide;

import javax.swing.*;
import java.awt.*;

public class SlideShowView extends JPanel {
    private PresentationView presentationView;
    private JPanel cardPanel = new JPanel();
    private JPanel btnPanel = new JPanel();
    private JButton btnNext = new JButton("Next");
    private JButton btnPrevious = new JButton("Previous");
    private JButton btnClose = new JButton("Close");
    private JLabel lblPresName = new JLabel();
    private Presentation presentation;
    int currCard;


    public SlideShowView(Presentation presentation) {
        this.presentation = presentation;
        this.lblPresName.setText(presentation.getAutor());
        lblPresName.setHorizontalAlignment(JLabel.CENTER);
        lblPresName.setPreferredSize(new Dimension(0, 50));
        this.setLayout(new BorderLayout());
        JPanel jPanelWest = new JPanel();
        JPanel jPanelEast = new JPanel();
        jPanelWest.setPreferredSize(new Dimension(150, 0));
        jPanelEast.setPreferredSize(new Dimension(150, 0));
        this.add(jPanelWest, BorderLayout.WEST);
        this.add(jPanelEast, BorderLayout.EAST);
        this.add(lblPresName, BorderLayout.NORTH);


        cardPanel.setLayout(new CardLayout());
        presentationView = new PresentationView(presentation);
        this.currCard = 1;

        for(Component c : presentationView.getBoxPanel().getComponents()) {
            if(c instanceof SlideView) {
                cardPanel.add(c);
            }
        }

        btnPrevious.setEnabled(false);

        btnNext.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
            cardLayout.next(cardPanel);
            currCard++;
            cardPanel.revalidate();
            cardPanel.repaint();

            if(currCard == presentation.getNodeChildren().size()) {
                btnNext.setEnabled(false);
            }
            if(currCard >= 1) {
                btnPrevious.setEnabled(true);
            }
        });

        this.add(cardPanel, BorderLayout.CENTER);
        btnPrevious.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
            cardLayout.previous(cardPanel);
            currCard--;
            cardPanel.revalidate();
            cardPanel.repaint();

            if(currCard == 1) {
                btnPrevious.setEnabled(false);
            }
            btnNext.setEnabled(true);
        });

        btnClose.addActionListener(e -> {

            presentationView.setEditState();
            for(Component c : cardPanel.getComponents()) {
                if(c instanceof SlideView) {
                    SlideView sw = (SlideView) c;
                    Slide slide = sw.getSlide();
                    slide.removeSubscriber(sw);
                }
            }
            presentation.removeSubscriber(presentationView);
        });

        if(presentation.getNodeChildren().size() <= 1) {
            btnNext.setEnabled(false);
            btnPrevious.setEnabled(false);
        }

        btnPanel.add(btnPrevious);
        btnPanel.add(btnNext);
        btnPanel.add(btnClose);
        this.add(btnPanel, BorderLayout.SOUTH);
    }

    public PresentationView getPresentationView() {
        return presentationView;
    }

    public void setPresentationView(PresentationView presentationView) {
        this.presentationView = presentationView;
    }

    public JPanel getCardPanel() {
        return cardPanel;
    }

    public void setCardPanel(JPanel cardPanel) {
        this.cardPanel = cardPanel;
    }

    public JPanel getBtnPanel() {
        return btnPanel;
    }

    public void setBtnPanel(JPanel btnPanel) {
        this.btnPanel = btnPanel;
    }

    public JButton getBtnNext() {
        return btnNext;
    }

    public void setBtnNext(JButton btnNext) {
        this.btnNext = btnNext;
    }

    public JButton getBtnPrevious() {
        return btnPrevious;
    }

    public void setBtnPrevious(JButton btnPrevious) {
        this.btnPrevious = btnPrevious;
    }

    public JButton getBtnClose() {
        return btnClose;
    }

    public void setBtnClose(JButton btnClose) {
        this.btnClose = btnClose;
    }

    public JLabel getLblPresName() {
        return lblPresName;
    }

    public void setLblPresName(JLabel lblPresName) {
        this.lblPresName = lblPresName;
    }

    public int getCurrCard() {
        return currCard;
    }

    public void setCurrCard(int currCard) {
        this.currCard = currCard;
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }
}
