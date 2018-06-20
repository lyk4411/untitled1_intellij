package leetcode;

/**
 * Created by lyk on 2018-6-20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MaskingPersonalInformation {
    public String maskPII(String S) {
        int atIndex = S.indexOf('@');
        if (atIndex >= 0) { // email
            return (S.substring(0, 1) + "*****" + S.substring(atIndex - 1)).toLowerCase();
        } else { // phone
            String digits = S.replaceAll("\\D+", "");
            String local = "***-***-" + digits.substring(digits.length() - 4);
            if (digits.length() == 10) return local;
            String ans = "+";
            for (int i = 0; i < digits.length() - 10; ++i)
                ans += "*";
            return ans + "-" + local;
        }
    }

    public static void main(String[] args) {
        MaskingPersonalInformation mpi = new MaskingPersonalInformation();
        System.out.println(mpi.maskPII("LeetCode@LeetCode.com"));
        System.out.println(mpi.maskPII("AB@qq.com"));
        System.out.println(mpi.maskPII("1(234)567-890"));
        System.out.println(mpi.maskPII("86-(10)12345678"));
    }
}
