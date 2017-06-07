package leetcode;

/**
 * Created by lyk on 2017/6/7.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class NextGreaterElementIII {
    public static void main(String[] args) {
        NextGreaterElementIII ngeiii = new NextGreaterElementIII();
        System.out.println(ngeiii.nextGreaterElement(12));
        System.out.println(ngeiii.nextGreaterElement(123));
        System.out.println(ngeiii.nextGreaterElement(212));
        System.out.println(ngeiii.nextGreaterElement(21));
        System.out.println(ngeiii.nextGreaterElement(987789));
        System.out.println(ngeiii.nextGreaterElement(987789321));

    }
    public int nextGreaterElement(int n) {
        char[] a=(""+n).toCharArray();
        int i = a.length - 2;
        while (i >= 0 && a[i + 1] <= a[i]) {
            i--;
        }
        if(i<0)
            return -1;
        int j = a.length - 1;
        while (j >= 0 && a[j] <= a[i]) {
            j--;
        }
        swap(a, i, j);
        reverse(a, i + 1);
        try{
            return Integer.parseInt(new String(a));
        }
        catch(Exception e){
            return -1;
        }
    }
    private void reverse(char[] a, int start) {
        int i = start, j = a.length - 1;
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }
    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
