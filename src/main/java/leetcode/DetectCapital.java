package leetcode;

/**
 * Created by lyk on 2017/2/22.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class DetectCapital {
    public static  void main(String[] args){
        DetectCapital dc = new DetectCapital();
        System.out.println(dc.detectCapitalUse(new String("asdfjlka")));
        System.out.println(dc.detectCapitalUse(new String("USA")));
        System.out.println(dc.detectCapitalUse(new String("asdfjlLa")));


    }
    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }
}
