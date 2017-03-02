package ch11;

/**
 * Created by lyk on 2016/12/13.
 * Package name: ch11
 * Porject name: untitled1
 */

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Xin {

    public static void main(String[] args) throws Exception {

        try(Scanner in = new Scanner(new FileInputStream("d:\\haha.txt"));
            PrintWriter out = new PrintWriter("d:\\hehe.txt")) {
            while(in.hasNext()) {
                out.println(in.next().toUpperCase());
            }
        }
    }
}