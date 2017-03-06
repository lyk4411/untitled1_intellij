package leetcode;

/**
 * Created by liuyongkai on 17/3/5.
 */
public class PalindromeNumber {
    public static void main(String[] args){
        PalindromeNumber pn = new PalindromeNumber();
        System.out.println(pn.isPalindrome(101));
        System.out.println(pn.isPalindrome(1345431));
        System.out.println(pn.isPalindrome(1011));
    }
    public boolean isPalindrome(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        while (x>rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return (x==rev || x==rev/10);
    }
}
