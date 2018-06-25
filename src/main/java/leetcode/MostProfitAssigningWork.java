package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2018-6-26.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MostProfitAssigningWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int N = difficulty.length;
        Point[] jobs = new Point[N];
        for (int i = 0; i < N; ++i)
            jobs[i] = new Point(difficulty[i], profit[i]);
        Arrays.sort(jobs, (a, b) -> a.x - b.x);
        Arrays.sort(worker);

        int ans = 0, i = 0, best = 0;
        for (int skill: worker) {
            while (i < N && skill >= jobs[i].x)
                best = Math.max(best, jobs[i++].y);
            ans += best;
        }

        return ans;
    }

    public static void main(String[] args) {
        MostProfitAssigningWork mpaw = new MostProfitAssigningWork();
        System.out.println(mpaw.maxProfitAssignment(
                new int[]{2,4,6,8,10},
                new int[]{10,20,30,40,50},
                new int[]{4,5,6,7}
        ));
    }
}
