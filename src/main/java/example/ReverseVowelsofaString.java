package example;

/**
 * Created by lyk on 2017/4/20.
 * Package name: example
 * Porject name: untitled1
 */
public class ReverseVowelsofaString {
    public static void main(String[] args) {
        ReverseVowelsofaString rvs = new ReverseVowelsofaString();
        System.out.println(rvs.reverseVowels("hello world."));
    }
    public String reverseVowels(String s) {
        if(s == null || s.length()==0) return s;
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length()-1;
        while(start<end){

            while(start<end && !vowels.contains(chars[start]+"")){
                start++;
            }

            while(start<end && !vowels.contains(chars[end]+"")){
                end--;
            }

            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
        return new String(chars);
    }
}
