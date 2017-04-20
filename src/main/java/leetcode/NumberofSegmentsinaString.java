package leetcode;

/**
 * Created by lyk on 2017/4/20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class NumberofSegmentsinaString {

    public static void main(String[] args) {
        NumberofSegmentsinaString nss = new NumberofSegmentsinaString();
        System.out.println(nss.countSegments("hello world. hhhh.    adfafa"));
        System.out.println(nss.countSegments("hello world. hhhh....adfafa"));
    }
    public int countSegments(String s) {
        String trimmed = s.trim();
        if (trimmed.length() == 0) return 0;
        else return trimmed.split("\\s+").length;
    }

//    public int countSegments(String s) {
//        int res=0;
//        for(int i=0; i<s.length(); i++)
//            if(s.charAt(i)!=' ' && (i==0 || s.charAt(i-1)==' '))
//                res++;
//        return res;
//    }
}
