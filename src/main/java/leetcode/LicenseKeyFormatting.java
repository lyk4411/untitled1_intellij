package leetcode;

/**
 * Created by lyk on 2017/5/17.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LicenseKeyFormatting {
    public static void main(String[] args) {
        LicenseKeyFormatting lkf = new LicenseKeyFormatting();
        System.out.println(lkf.licenseKeyFormatting("2-4A0r7----------4k",3));
        System.out.println("=================");
        System.out.println(lkf.licenseKeyFormatting("2-4A0r7-4k",3));
        System.out.println("=================");
        System.out.println(lkf.licenseKeyFormatting("24A0r74k",3));
        System.out.println("=================");
    }
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        System.out.println(s.length());
        for (int i = s.length() - 1; i >= 0; i--)
            if (s.charAt(i) != '-')
                sb.append(sb.length() % (k + 1) == k ? '-' : "").append(s.charAt(i));
        return sb.reverse().toString().toUpperCase();
    }
}
