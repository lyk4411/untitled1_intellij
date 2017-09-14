package headfirst.singleton.IoDH;

/**
 * Created by lyk on 2017/9/14.
 * Package name: headfirst.singleton.IoDH
 * Porject name: untitled1
 */
public class Singleton {
    private Singleton() {
    }

    private static class HolderClass {
        private final static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return HolderClass.instance;
    }

    public static void main(String args[]) {
        Singleton s1, s2;
        s1 = Singleton.getInstance();
        s2 = Singleton.getInstance();
        System.out.println(s1==s2);
    }
}
