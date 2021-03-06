package leetcode;

/**
 * Created by lyk on 2017/6/14.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ValidateIPAddress {
    public static void main(String[] args) {
        ValidateIPAddress VIPA = new ValidateIPAddress();
        System.out.println(VIPA.validIPAddress("172.16.254.1"));
        System.out.println(VIPA.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(VIPA.validIPAddress("256.256.256.256"));
        System.out.println(VIPA.validIPAddress("0.0.0.0"));
        System.out.println(VIPA.validIPAddress("0.0.-0.0"));
        System.out.println(VIPA.validIPAddress("0:0:0:0:0:0:0:0"));
        System.out.println(VIPA.validIPAddress("0:0:0:0:0:0:0:-0"));
    }

    public String validIPAddress(String IP) {
        if(isValidIPv4(IP)) return "IPv4";
        else if(isValidIPv6(IP)) return "IPv6";
        else return "Neither";
    }

    public boolean isValidIPv4(String ip) {
        if(ip.length()<7) return false;
        if(ip.charAt(0)=='.') return false;
        if(ip.charAt(ip.length()-1)=='.') return false;
        String[] tokens = ip.split("\\.");
        if(tokens.length!=4) return false;
        for(String token:tokens) {
            if(!isValidIPv4Token(token)) return false;
        }
        return true;
    }
    public boolean isValidIPv4Token(String token) {
        if(token.startsWith("0") && token.length()>1) return false;
        try {
            int parsedInt = Integer.parseInt(token);
            if(parsedInt<0 || parsedInt>255) return false;
            if(parsedInt==0 && token.charAt(0)!='0') return false;
        } catch(NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean isValidIPv6(String ip) {
        if(ip.length()<15) return false;
        if(ip.charAt(0)==':') return false;
        if(ip.charAt(ip.length()-1)==':') return false;
        String[] tokens = ip.split(":");
        if(tokens.length!=8) return false;
        for(String token: tokens) {
            if(!isValidIPv6Token(token)) return false;
        }
        return true;
    }
    public boolean isValidIPv6Token(String token) {
        if(token.length()>4 || token.length()==0) return false;
        char[] chars = token.toCharArray();
        for(char c:chars) {
            boolean isDigit = c>=48 && c<=57;
            boolean isUppercaseAF = c>=65 && c<=70;
            boolean isLowerCaseAF = c>=97 && c<=102;
            if(!(isDigit || isUppercaseAF || isLowerCaseAF))
                return false;
        }
        return true;
    }
}
