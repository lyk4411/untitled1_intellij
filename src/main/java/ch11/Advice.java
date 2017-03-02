package ch11;

/**
 * Created by lyk on 2016/12/13.
 * Package name: ch11
 * Porject name: untitled1
 */
import java.io.InputStream;

public class Advice {

    public static void main(String[] args) throws Exception {
        InputStream in = null;
        Exception ex = null;
        try{
            try{
                //code.....;
                int i =0;
            } catch (Exception e) {
                ex = e;
                throw e;
            }
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                if(ex == null)
                    throw e;
            }
        }
    }
}