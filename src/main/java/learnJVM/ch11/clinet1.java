package learnJVM.ch11;

/**
 * Created by lyk on 2018-11-28.
 * Package name: learnJVM.ch11
 * Porject name: untitled1
 */
public class clinet1 {

    /**
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        EventSource es = new EventSource();
        //        new ThisEscape(es);
        SafeListener.newInstance(es);
    }
}
