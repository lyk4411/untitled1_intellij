package learnJVM.ch08;

/**
 * Created by lyk on 2018-11-8.
 * Package name: learnJVM.ch08
 * Porject name: untitled1
 */
public class ch08ex01 {
    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
//            placeholder = null;
        }

        System.gc();
    }

}
