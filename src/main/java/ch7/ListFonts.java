package ch7;

/**
 * Created by lyk on 2016/10/7.
 * Package name: ch7
 * Porject name: untitled1
 */

import java.awt.*;

/**
 * @version 1.11 2004-06-05
 * @author Cay Horstmann
 */
public class ListFonts
{
    public static void main(String[] args)
    {
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getAvailableFontFamilyNames();

        for (String fontName : fontNames)
            System.out.println(fontName);
        System.out.println(fontNames.length);
    }
}
