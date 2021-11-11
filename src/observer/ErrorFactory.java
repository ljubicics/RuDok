package observer;

import java.util.ArrayList;
import java.util.List;

public class ErrorFactory implements IPublisher{

    private static ErrorFactory instance;
    List<ISubscriber> subscribers = new ArrayList<>();

    private ErrorFactory() {
    }

    public static ErrorFactory getInstance() {
        if (instance == null) {
            instance = new ErrorFactory();
        }
        return instance;
    }

    public void generateError(String title, String text, String solution, int type) {
        MyError myError = new MyError(title, text, type, solution);
        notifySubscribers(myError);
    }

    public static void setInstance(ErrorFactory instance) {
        ErrorFactory.instance = instance;
    }

    public List<ISubscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<ISubscriber> subscribers) {
        this.subscribers = subscribers;
    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        if(sub == null)
            return;
        if(this.subscribers ==null)
            this.subscribers = new ArrayList<>();
        if(this.subscribers.contains(sub))
            return;
        this.subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        if(sub == null || this.subscribers == null || !this.subscribers.contains(sub))
            return;
        this.subscribers.remove(sub);
    }

    @Override
    public void notifySubscribers(Object notification) {
        if(notification == null || this.subscribers == null || this.subscribers.isEmpty())
            return;

        for(ISubscriber listener : subscribers){
            listener.update(notification);
        }
    }
}
