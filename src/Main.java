import observer.ErrorFactory;
import view.MainFrame;

public class Main {

    public static void main(String[] args) {
        MainFrame mf  = MainFrame.getInstance();
        mf.setVisible(true);
        ErrorFactory errorFactory = ErrorFactory.getInstance();
        errorFactory.addSubscriber(mf);
    }
}
