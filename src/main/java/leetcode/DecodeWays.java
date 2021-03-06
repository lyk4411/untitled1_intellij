package leetcode;

/**
 * Created by lyk on 2017/4/10.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class DecodeWays {
    public static void main(String[] args) {
        DecodeWays dw = new DecodeWays();
        System.out.println(dw.numDecodings("00123456321212"));
        System.out.println(dw.numDecodings("0123456321212"));
        System.out.println(dw.numDecodings("123456321212"));
        System.out.println(dw.numDecodings("1234563201212"));
        System.out.println(dw.numDecodings("12345632001212"));

    }
//    public int numDecodings(String s) {
//        if(s==null || s.length()==0 || s.charAt(0)=='0')
//            return 0;
//        if(s.length()==1)
//            return 1;
//
//        int[] dp = new int[s.length()];
//        dp[0]=1;
//        if(Integer.parseInt(s.substring(0,2))>26){
//            if(s.charAt(1)!='0'){
//                dp[1]=1;
//            }else{
//                dp[1]=0;
//            }
//        }else{
//            if(s.charAt(1)!='0'){
//                dp[1]=2;
//            }else{
//                dp[1]=1;
//            }
//        }
//
//        for(int i=2; i<s.length(); i++){
//            if(s.charAt(i)!='0'){
//                dp[i]+=dp[i-1];
//            }
//
//            int val = Integer.parseInt(s.substring(i-1, i+1));
//            if(val<=26 && val >=10){
//                dp[i]+=dp[i-2];
//            }
//        }
//
//        return dp[s.length()-1];
//    }


    public int numDecodings(String s) {
        if(s.length() == 0) return s.length();
        int[] dp = new int[s.length() + 1];
        // 初始化第一种解码方式
        dp[0] = 1;
        // 如果第一位是0，则无法解码
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2; i <= s.length(); i++){
            // 如果字符串的第i-1位和第i位能组成一个10到26的数字，说明我们可以在第i-2位的解码方法上继续解码
            if(Integer.parseInt(s.substring(i-2, i)) <= 26 && Integer.parseInt(s.substring(i-2, i)) >= 10){
                dp[i] += dp[i - 2];
            }
            // 如果字符串的第i-1位和第i位不能组成有效二位数字，在第i-1位的解码方法上继续解码
            if(Integer.parseInt(s.substring(i-1, i)) != 0){
                dp[i] += dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}
