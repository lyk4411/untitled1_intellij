package effectiveJava.Chapter6.Item32;// EnumSet - a modern replacement for bit fields - Page 160

import java.util.*;

public class Text {
    public enum Style { BOLD, ITALIC, UNDERLINE, STRIKETHROUGH }

    // Any Set could be passed in, but EnumSet is clearly best
    public void applyStyles(Set<Style> styles) {
        // Body goes here
    }

    // Sample use
    public static void main(String[] args) {
        Text text = new Text();
        text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
        for(Style s : Style.values()){
            System.out.println(s);
        }
        System.out.println("==================================");
        System.out.println(EnumSet.of(Style.BOLD, Style.ITALIC));
    }
}
