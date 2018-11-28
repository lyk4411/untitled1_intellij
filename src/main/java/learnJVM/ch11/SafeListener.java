package learnJVM.ch11;

/**
 * Created by lyk on 2018-11-28.
 * Package name: learnJVM.ch11
 * Porject name: untitled1
 */

import java.awt.Event;

public class SafeListener {

    private final EventListener listener;
    private String              name = null;

    private SafeListener() {
        listener = new EventListener() {

            public void onEvent(Event event) {
                doSomething();
            }
        };
        name = "TEST";
    }

    public static SafeListener newInstance(EventSource eventSource) {
        SafeListener safeListener = new SafeListener();
        eventSource.registerListener(safeListener.listener);
        return safeListener;
    }

    /**
     *
     */
    protected void doSomething() {
        System.out.println(name.toString());
    }
}