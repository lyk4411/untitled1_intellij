package leetcode;

/**
 * Created by lyk on 2017/4/11.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PalindromePartitioningII {
    public static void main(String[] args) {
        PalindromePartitioningII ppii = new PalindromePartitioningII();
        System.out.println(ppii.minCut("abcba"));
    }
    public int minCut(String s) {
        int n = s.length();

        boolean dp[][] = new boolean[n][n];
        int cut[] = new int[n];

        for (int j = 0; j < n; j++) {
            cut[j] = j; //set maximum # of cut
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i+1][j-1])) {
                    dp[i][j] = true;

                    // if need to cut, add 1 to the previous cut[i-1]
                    if (i > 0){
                        cut[j] = Math.min(cut[j], cut[i-1] + 1);
                    }else{
                        // if [0...j] is palindrome, no need to cut
                        cut[j] = 0;
                    }
                }
            }
        }

        return cut[n-1];
    }
//    public int minCut(String s) {
//        List<List<String>> lists = partition(s);
//        int min = Integer.MAX_VALUE;
//        Integer[] as = lists.stream().sorted(Comparator.comparing(l -> l.size())).map(l -> l.size()).
//                toArray(Integer[]::new);
//        for (Integer a : as) {
//            System.out.println(a);
//        }
//        return as[0] - 1;
//    }
//    public List<List<String>> partition(String s) {
//        List<List<String>> result = new ArrayList<List<String>>();
//
//        if (s == null || s.length() == 0) {
//            return result;
//        }
//
//        ArrayList<String> partition = new ArrayList<String>();//track each possible partition
//        addPalindrome(s, 0, partition, result);
//
//        return result;
//    }
//
//    private void addPalindrome(String s, int start, ArrayList<String> partition,
//                               List<List<String>> result) {
//        //stop condition
//        if (start == s.length()) {
//            ArrayList<String> temp = new ArrayList<String>(partition);
//            result.add(temp);
//            return;
//        }
//
//        for (int i = start + 1; i <= s.length(); i++) {
//            String str = s.substring(start, i);
//            if (isPalindrome(str)) {
//                partition.add(str);
//                addPalindrome(s, i, partition, result);
//                partition.remove(partition.size() - 1);
//            }
//        }
//    }
//
//    private boolean isPalindrome(String str) {
//        int left = 0;
//        int right = str.length() - 1;
//
//        while (left < right) {
//            if (str.charAt(left) != str.charAt(right)) {
//                return false;
//            }
//
//            left++;
//            right--;
//        }
//
//        return true;
//    }
}
