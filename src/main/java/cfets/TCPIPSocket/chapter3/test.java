package cfets.TCPIPSocket.chapter3;

import java.io.UnsupportedEncodingException;

/**
 * Created by lyk on 2016/7/26.
 * Package name: cfets.TCPIPSocket.chapter3
 * Porject name: untitled1
 */
public class test {

    public static  void  main(String[] args){
        try {
            System.out.println(String.valueOf("Test".getBytes("UTF-16BE")));

            System.out.println("Test".getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
