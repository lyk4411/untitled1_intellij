package leetcode;

/**
 * Created by lyk on 2017/5/8.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LongestAbsoluteFilePath {
    public static void main(String[] args) {
        LongestAbsoluteFilePath lafp = new LongestAbsoluteFilePath();
        System.out.println(lafp.lengthLongestPath("dir\\n\\tsubdir1\\n\\t\\tfile1.ext" +
                "\\n\\t\\tsubsubdir1\\n\\tsubdir2\\n\\t\\tsubsubdir2\\n\\t\\t\\tfile2.ext"));
    }
    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        int[] stk = new int[paths.length + 1];
        int maxLen = 0;
        // 路径是定好的，覆盖的时候已经走完上一层，放心覆盖。
        for(String str: paths){
            int lev = str.lastIndexOf("\t") + 1;
            // 路径长度         “/” 占一格
            stk[lev+1] = stk[lev] + str.length() - lev + 1;
            if(str.contains("."))  maxLen = Math.max(maxLen, stk[lev+1]-1);   // 结尾处没有“/”, 所以减一
        }
        return maxLen;
    }

}
