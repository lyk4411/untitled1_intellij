package leetcode;

/**
 * Created by lyk on 2017/2/15.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class Base7 {
    public static void main(String[] args){

        Base7 base7 = new Base7();

        System.out.println(base7.convertTo7(111));
    }
    public String convertTo7(int num) {
        StringBuffer sb = new StringBuffer("");
        if(num == 0) return "0";
        boolean flag = num > 0 ? false : true;
        num = Math.abs(num);
        while(num != 0){
            sb.insert(0,num%7);
            num /= 7;
        }
        if(flag)sb.insert(0,"-");

        return sb.toString();
    }
}
