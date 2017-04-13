package leetcode;

/**
 * Created by lyk on 2017/4/12.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class BeautifulArrangement {
    public static void main(String[] args) {
        BeautifulArrangement ba = new BeautifulArrangement();
        System.out.println(ba.countArrangement(5));
    }

    int count = 0;

//    private int countArrangement(int Number) {
//        if(Number == 0) return 0;
//        helper(Number,1,new int[Number + 1]);
//        return count;
//    }
//
//    private void helper(int number, int pos, int[] used) {
//        if(pos == (number + 1)){
//            count++;
//            return;
//        }
//        for (int i = 1; i <= number; i++) {
//            if(used[i] == 0 && ( i % pos == 0 || pos % i == 0)) {
//                used[i] = 1;
//                helper(number, pos + 1, used);
//                used[i] = 0;
//            }
//        }
//    }

    public int countArrangement(int N) {
        if (N == 0) return 0;
        helper(N, 1, new int[N + 1]);
        return count;
    }

    private void helper(int N, int pos, int[] used) {
        if (pos == (N + 1)) {
            count++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (used[i] == 0 && (i % pos == 0 || pos % i == 0)) {
                used[i] = 1;
                helper(N, pos + 1, used);
                used[i] = 0;
            }
        }
    }
}
