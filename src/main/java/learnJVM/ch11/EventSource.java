package learnJVM.ch11;

/**
 * Created by lyk on 2018-11-28.
 * Package name: learnJVM.ch11
 * Porject name: untitled1
 */
public class EventSource {
    public void registerListener(EventListener listener) {
        listener.onEvent(null);
    }

}
