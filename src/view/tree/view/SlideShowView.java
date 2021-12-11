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
    private JButton btnPrevous = new JButton("Prevous");
    private JButton btnClose = new JButton("Close");
    private JLabel lblPresName = new JLabel();
    int currCard;
    int maxCard;

    public SlideShowView(Presentation presentation) {
        this.lblPresName.setText(presentation.getAutor());
        this.setLayout(new BorderLayout());
        this.add(lblPresName, BorderLayout.NORTH);

        cardPanel.setLayout(new CardLayout());
        presentationView = new PresentationView(presentation);
        this.currCard = 0;
        this.maxCard = presentation.getNodeChildren().size();

        for(Component c : presentationView.getBoxPanel().getComponents()) {
            if(c instanceof SlideView) {
                cardPanel.add(c);
            }
        }

        this.add(cardPanel, BorderLayout.CENTER);
        btnPrevous.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
            cardLayout.previous(cardPanel);
            currCard--;
            cardPanel.revalidate();
            cardPanel.repaint();

            if(currCard == 0) {
                btnPrevous.setEnabled(false);
            }
            if(currCard == maxCard - 1) {
                btnNext.setEnabled(false);
            }
        });

        btnNext.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
            cardLayout.next(cardPanel);
            currCard++;
            cardPanel.revalidate();
            cardPanel.repaint();

            if(currCard == maxCard) {
                btnNext.setEnabled(false);
            }
            if(currCard == 1) {
                btnPrevous.setEnabled(true);
            }
        });

        btnClose.addActionListener(e -> {
            presentation.setPresentationState(new EditState());
            for(Component c : cardPanel.getComponents()) {
                if(c instanceof SlideView) {
                    SlideView sw = (SlideView) c;
                    Slide slide = sw.getSlide();
                    slide.removeSubscriber(sw);
                }
            }
            presentation.removeSubscriber(presentationView);
        });

        btnPanel.add(btnPrevous);
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

    public JButton getBtnPrevous() {
        return btnPrevous;
    }

    public void setBtnPrevous(JButton btnPrevous) {
        this.btnPrevous = btnPrevous;
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

    public int getMaxCard() {
        return maxCard;
    }

    public void setMaxCard(int maxCard) {
        this.maxCard = maxCard;
    }

}
