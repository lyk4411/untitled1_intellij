package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by lyk on 2018-7-5.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MinimumCosttoHireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int N = quality.length;
        Worker[] workers = new Worker[N];
        for (int i = 0; i < N; ++i)
            workers[i] = new Worker(quality[i], wage[i]);
        Arrays.sort(workers);

        double ans = 1e9;
        int sumq = 0;
        PriorityQueue<Integer> pool = new PriorityQueue();
        for (Worker worker: workers) {
            pool.offer(-worker.quality);
            sumq += worker.quality;
            if (pool.size() > K)
                sumq += pool.poll();
            if (pool.size() == K)
                ans = Math.min(ans, sumq * worker.ratio());
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumCosttoHireKWorkers mchkw = new MinimumCosttoHireKWorkers();
        System.out.println(mchkw.mincostToHireWorkers(
                new int[]{10,20,5},new int[]{70,50,30},2));
        System.out.println(mchkw.mincostToHireWorkers(
                new int[]{3,1,10,10,1},new int[]{4,8,2,2,7},3));
    }
}

//    思路：
//    注意到我们需要小的W/Q比，而且所有人这个比值是一样的，但是假定我们选了k个人，最后给他们的开
//    的W/Q又一定是k个人中最大的，不然有的人就满足不了最小的wage，所以W/Q是由大的数值主导。
//
//    这样的话，就可以先对W/Q排序，这样W/Q值就是最后选的那个人，然后只要求Q总和最小的k个就好，于
//    是sort+PriorityQueue
class Worker implements Comparable<Worker> {
    public int quality, wage;
    public Worker(int q, int w) {
        quality = q;
        wage = w;
    }

    public double ratio() {
        return (double) wage / quality;
    }

    public int compareTo(Worker other) {
        return Double.compare(ratio(), other.ratio());
    }
}

