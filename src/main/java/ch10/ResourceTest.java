package ch10;

/**
 * Created by lyk on 2016/10/26.
 * Package name: ch10
 * Porject name: untitled1
 */

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.4 2007-04-30
 * @author Cay Horstmann
 */
public class ResourceTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                ResourceTestFrame frame = new ResourceTestFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

