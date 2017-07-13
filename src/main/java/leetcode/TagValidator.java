package leetcode;

import java.util.Stack;

/**
 * Created by lyk on 2017/7/13.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class TagValidator {
    public static void main(String[] args) {
        TagValidator tg = new TagValidator();
        System.out.println(tg.isValid("<DIV>This is the first line <![CDATA[<div>]]></DIV>"));
        System.out.println(tg.isValid("<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>"));
        System.out.println(tg.isValid("<A>  <B> </A>   </B>"));
        System.out.println(tg.isValid("<DIV>  unmatched <  </DIV>"));
        System.out.println(tg.isValid("<DIV> closed tags with invalid tag name  <b>123</b> </DIV>"));

    }

    public boolean isValid(String code) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < code.length();){
            if(i>0 && stack.isEmpty()) return false;
            if(code.startsWith("<![CDATA[", i)){
                int j = i+9;
                i = code.indexOf("]]>", j);
                if(i < 0) return false;
                i += 3;
            }else if(code.startsWith("</", i)){
                int j = i + 2;
                i = code.indexOf('>', j);
                if(i < 0 || i == j || i - j > 9) return false;
                for(int k = j; k < i; k++){
                    if(!Character.isUpperCase(code.charAt(k))) return false;
                }
                String s = code.substring(j, i++);
                if(stack.isEmpty() || !stack.pop().equals(s)) return false;
            }else if(code.startsWith("<", i)){
                int j = i + 1;
                i = code.indexOf('>', j);
                if(i < 0 || i == j || i - j > 9) return false;
                for(int k = j; k < i; k++){
                    if(!Character.isUpperCase(code.charAt(k))) return false;
                }
                String s = code.substring(j, i++);
                stack.push(s);
            }else{
                i++;
            }
        }
        return stack.isEmpty();
    }
}
