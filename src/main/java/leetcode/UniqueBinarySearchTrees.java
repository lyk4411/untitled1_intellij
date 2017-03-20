package leetcode;

/**
 * Created by lyk on 2017/3/20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        UniqueBinarySearchTrees ubst = new UniqueBinarySearchTrees();
        System.out.println(ubst.numTrees(10));
        System.out.println(ubst.numTrees(15));
        System.out.println(ubst.numTrees(5));
        System.out.println(ubst.numTrees(4));
        System.out.println(ubst.numTrees(3));
        System.out.println(ubst.numTrees(2));
        System.out.println(ubst.numTrees(1));
        System.out.println(ubst.numTrees(0));
    }
    public int numTrees(int n) {
        if(n ==0 || n ==1) return 1;
        int res[] =new int[n+1];
        res[0]=1;
        for(int i =1 ; i <= n ; i++){
            for(int j = 0; j < i; j++){
                res[i] += res[j]*res[i-j-1];
            }
        }
        return res[n];
    }
}
