package learnJVM.ch11;

import java.awt.*;

/**
 * Created by lyk on 2018-11-28.
 * Package name: learnJVM.ch11
 * Porject name: untitled1
 */
public class ThisEscape {
    private String name = null;

    public ThisEscape(EventSource source) {
        source.registerListener(new EventListener() {
            @Override
            public void onEvent(Event event) {
                doSomething(event);
            }
        });
        name = "TEST";
    }

    /**
     *
     * @param event
     */
    protected void doSomething(Event event) {
        System.out.println(name.toString());
    }
}