package ch7;

/**
 * Created by lyk on 2016/10/6.
 * Package name: ch7
 * Porject name: untitled1
 */
import javax.swing.*;
import java.awt.*;

/**
 * @version 1.32 2007-04-14
 * @author Cay Horstmann
 */
public class SizedFrameTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                SizedFrame frame = new SizedFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class SizedFrame extends JFrame
{
    public SizedFrame()
    {
        // get screen dimensions

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        // set frame width, height and let platform pick screen location

        setSize(screenWidth / 2, screenHeight / 2);
        setLocationByPlatform(true);

        // set frame icon and title

        Image img = kit.getImage("icon.gif");
        setIconImage(img);
        setTitle("SizedFrame");
    }
}
