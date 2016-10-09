package cfets.TCPIPSocket.chapter3;

import java.io.UnsupportedEncodingException;

/**
 * Created by lyk on 2016/8/4.
 * Package name: cfets.TCPIPSocket.chapter3
 * Porject name: untitled1
 */
public class test {
    public  static void main(String args[]){
        System.out.println("types".getBytes());
        try {
            System.out.println(new String("types".getBytes("UTF-8"),"UTF-8"));
            System.out.println(new String("types".getBytes("UTF-16"),"UTF-8"));
            System.out.println(new String("types".getBytes("IBM037"),"UTF-8"));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
