package ch10;

/**
 * Created by lyk on 2016/10/27.
 * Package name: ch10
 * Porject name: untitled1
 */


import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

/**
 * A frame that loads image and text resources.
 */
public class ResourceTestFrame extends JFrame
{
    public ResourceTestFrame()
    {
        setTitle("ResourceTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        URL aboutURL = getClass().getResource("about.gif");
        Image img = Toolkit.getDefaultToolkit().getImage(aboutURL);
        setIconImage(img);

        JTextArea textArea = new JTextArea();
        InputStream stream = getClass().getResourceAsStream("about.txt");
        Scanner in = new Scanner(stream);
        while (in.hasNext())
            textArea.append(in.nextLine() + "\n");
        add(textArea);
    }

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 300;
}