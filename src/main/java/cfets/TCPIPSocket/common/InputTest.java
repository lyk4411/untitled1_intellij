package cfets.TCPIPSocket.common;

import java.util.Scanner;

/**
 * Created by lyk on 2016/9/13.
 * Package name: cfets.TCPIPSocket.common
 * Porject name: untitled1
 */
public class InputTest
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        // get first input
        System.out.print("What is your name? ");
        String name = in.nextLine();

        // get second input
        System.out.print("How old are you? ");
        int age = in.nextInt();

        // display output on console
        System.out.println("Hello, " + name + ". Next year, you'll be " + (age + 1));
    }
}