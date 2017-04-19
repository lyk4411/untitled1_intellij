package leetcode;

/**
 * Created by lyk on 2017/4/19.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ConvertaNumbertoHexadecimal {
    public static void main(String[] args) {
        ConvertaNumbertoHexadecimal cnh = new ConvertaNumbertoHexadecimal();
        System.out.println(cnh.toHex(123123));
        System.out.println(cnh.toHex(1231230));
        System.out.println(cnh.toHex(-123123));
    }
    char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

    public String toHex(int num) {
        if(num == 0) return "0";
        String result = "";
        while(num != 0){
            result = map[(num & 15)] + result;
            num = (num >>> 4);
        }
        return result;
    }
}
